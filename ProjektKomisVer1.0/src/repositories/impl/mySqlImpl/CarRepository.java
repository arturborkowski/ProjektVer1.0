package repositories.impl.mySqlImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import domain.Car;
import domain.Entity;
import domain.Offer;
import repositories.ICarRepository;

public class CarRepository extends Repository<Car> implements ICarRepository{

	
	
// szablony zapytañ sql-owych //
	private String insertSql=
			"INSERT INTO cars (mark, model, productionYear, engine, mileage, bodynumber, offerId)"
			+" VALUES (?,?,?,?,?,?,?)";
	private String updateSql=
			"UPDATE cars SET mark=?, model=?, productionYear=?, engine=?, mileage=?, bodynumber=?, offerId=?"
			+" WHERE id=?";

	
	
	public CarRepository(Connection connection, IEntityBuilder<Car> builder) {
		super(connection, builder);
	}



	@Override
	protected void setUpInsertQuery(Car entity) throws SQLException {
		insert.setString(1, entity.getMark());
		insert.setString(2, entity.getModel());
		insert.setString(3, entity.getProductionYear());
		insert.setString(4, entity.getEngine());
		insert.setString(5, entity.getMileage());
		insert.setString(6, entity.getBodyNumber());
		insert.setInt(7, entity.getOfferId());
		
	}



	@Override
	protected void setUpUpdateQuery(Car entity) throws SQLException {
		update.setString(1, entity.getMark());
		update.setString(2, entity.getModel());
		update.setString(3, entity.getProductionYear());
		update.setString(4, entity.getEngine());
		update.setString(5, entity.getMileage());
		update.setString(6, entity.getBodyNumber());
		update.setInt(7, entity.getOfferId());
		update.setInt(8, entity.getId());
		
	}



	@Override
	protected String getInsertQuery() {
		return insertSql;
	}



	@Override
	protected String getUpdateQuery() {
		return updateSql;
	}



	@Override
	protected String getTableName() {
		return "cars";
	}



	@Override
	public Car byOfferId(int offerId) {		
		
		try {
			selectById.setInt(1, offerId);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				return builder.build(rs);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	



	

}
