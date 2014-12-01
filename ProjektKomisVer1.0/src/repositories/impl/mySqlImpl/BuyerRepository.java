package repositories.impl.mySqlImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Buyer;
import domain.Transaction;
import repositories.IBuyerRepository;

public class BuyerRepository extends Repository<Buyer> implements IBuyerRepository{

	
	private String insertSql = 
			"INSERT INTO buyers (firstName, lastName, pesel, phoneNumber) VALUES (?,?,?,?)";
	private String updateSql =
			"UPDATE buyers SET firstName=?, lastName=?, pesel=?, phoneNumber=?"
			+ " WHERE id=?";

	
	
	public BuyerRepository(Connection connection, IEntityBuilder<Buyer> builder) {
		super(connection, builder);
	}



	@Override
	protected String getTableName() {
		return "buyers";
	}
	
	
	
	@Override
	protected String getInsertQuery() {
		return "INSERT INTO buyers (firstName, lastName, pesel, phoneNumber) VALUES (?,?,?,?)";
	}


	@Override
	protected String getUpdateQuery() {
		return updateSql;
	}
	
	

	@Override
	protected void setUpInsertQuery(Buyer entity) throws SQLException {
		insert.setString(1, entity.getFirstName());
		insert.setString(2, entity.getLastName());
		insert.setString(3, entity.getPesel());
		insert.setString(4, entity.getPhoneNumber());
		
	}


	@Override
	protected void setUpUpdateQuery(Buyer entity) throws SQLException {
		update.setString(1, entity.getFirstName());
		update.setString(2, entity.getLastName());
		update.setString(3, entity.getPesel());
		update.setString(4, entity.getPhoneNumber());
		update.setInt(5, entity.getId());
	}


	


	

	@Override
	public Buyer ofTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Buyer ofTransaction(int transactionId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
