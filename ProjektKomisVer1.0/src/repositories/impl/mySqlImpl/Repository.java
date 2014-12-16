package repositories.impl.mySqlImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.MysqlErrorNumbers;

import repositories.IRepository;
import unitofwork.IUnitOfWork;
import unitofwork.IUnitOfWorkRepository;
import domain.Buyer;
import domain.Entity;

public abstract class Repository<TEntity extends Entity> implements IRepository<TEntity>, IUnitOfWorkRepository {

	
	protected IUnitOfWork uow;
	protected Connection connection;
	protected PreparedStatement insert;
	protected PreparedStatement update;
	protected PreparedStatement selectById;
	protected PreparedStatement delete;
	protected PreparedStatement selectAll;
	protected IEntityBuilder<TEntity> builder;
	
	
	
// kilka przygotowanych zapytañ, które powtarzaj¹ siê dla ka¿dej klasy potomnej
	protected String selectByIdSql =
			"SELECT * FROM "+getTableName()+" WHERE id=?";
	protected String deleteSql = 
			"DELETE FROM "+getTableName()+" WHERE id=?";
	protected String selectAllSql =
			"SELECT * FROM "+getTableName();
	protected String insertSql = getInsertQuery();  
	protected String updateSql = getUpdateQuery();  
	
	
	
	
// KONSTRUKTOR, gdzie ustawiamy zapytania mysql-owe jako PreparedStatement
	protected Repository(Connection connection, IEntityBuilder<TEntity> builder, IUnitOfWork uow){
		this.connection = connection;
		this.builder = builder;
		this.uow = uow;
		
		try {	
			insert = connection.prepareStatement(insertSql);
			update = connection.prepareStatement(updateSql);
			selectById = connection.prepareStatement(selectByIdSql);
			delete = connection.prepareStatement(deleteSql);
			selectAll = connection.prepareStatement(selectAllSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
// METODY CRUDE
	
	
//add
	@Override
	public void add(TEntity entity) {
		
		uow.markAsNew(entity, this);		
	}
	
//update
	@Override
	public void update(TEntity entity) {
		
		uow.markAsDirty(entity, this);
	}

//delete
	@Override
	public void delete(TEntity entity) {
		
		uow.markAsDeleted(entity, this);
	}	
	
	
	@Override
	public void persistUpdate(Entity entity){
		
		try {
			setUpUpdateQuery((TEntity) entity);
			update.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void persistDelete(Entity entity) {
		
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void persistAdd(Entity entity) {
		
		try {
			setUpInsertQuery((TEntity) entity);
			insert.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

//get
	@Override
	public TEntity get(int id) {
		
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				return builder.build(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
//get All
	@Override
	public List<TEntity> getAll() {

		List<TEntity> result = new ArrayList<TEntity>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			
			while(rs.next()) {
				
				result.add(builder.build(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	
	

	// metody ustawiaj¹ce indywidualne parametry do zapytañ dla klasy ka¿dego z typów dla operacji INSERT i UPDATE
	protected abstract void setUpInsertQuery(TEntity entity) throws SQLException;
	protected abstract void setUpUpdateQuery(TEntity entity) throws SQLException;
	
	// metody przekazuj¹ce indywidualne dla klasy ka¿dego z typów treœci zapytania dla operacji INSERT i UPDATE
	protected abstract String getInsertQuery();
	protected abstract String getUpdateQuery();
	
	// zwraca nazwê tabeli w BD
	protected abstract String getTableName();
}
