package repositories.impl.mySqlImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import domain.Car;
import domain.Offer;
import repositories.ICarRepository;

public class CarRepository implements ICarRepository {

	private Connection connection;
	
	
// szablony zapytañ sql-owych //
	private String insertSql=
			"INSERT INTO cars (mark, model, productionYear, engine, mileage, bodynumber, offerId)"
			+" VALUES (?,?,?,?,?,?,?)";
	private String selectByIdSql=
			"SELECT * FROM cars WHERE id=?";
	private String updateSql=
			"UPDATE cars SET mark=?, model=?, productionYear=?, engine=?, mileage=?, bodynumber=?, offerId=?"
			+" WHERE id=?";
	private String deleteSql=
			"DELETE FROM cars WHERE id=?";
	private String selectAllSql=
			"SELECT * FROM cars";
	
	PreparedStatement insert;
	PreparedStatement selectById;
	PreparedStatement update;
	PreparedStatement delete;
	PreparedStatement selectAll;
	
	
	
	public CarRepository(Connection connection) {
		this.connection = connection;
		
		try {
			
			insert = connection.prepareStatement(insertSql);
			selectById = connection.prepareStatement(selectByIdSql);
			update = connection.prepareStatement(updateSql);
			delete = connection.prepareStatement(deleteSql);
			selectAll = connection.prepareStatement(selectAllSql);	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public void add(Car entity) {
		
		try {
			insert.setString(1, entity.getMark());
			insert.setString(2, entity.getModel());
			insert.setString(3, entity.getProductionYear());
			insert.setString(4, entity.getEngine());
			insert.setString(5, entity.getMileage());
			insert.setString(6, entity.getBodyNumber());
			insert.setInt(7, entity.getOfferId());
			insert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Car entity) {
		
		try {
		update.setString(1, entity.getMark());
		update.setString(2, entity.getModel());
		update.setString(3, entity.getProductionYear());
		update.setString(4, entity.getEngine());
		update.setString(5, entity.getMileage());
		update.setString(6, entity.getBodyNumber());
		update.setInt(7, entity.getOfferId());
		update.setInt(8, entity.getId());
		update.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Car entity) {

		try {
			
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Car get(int id) {
		Car result = null;			//zmienna przechowuj¹ca nam obiekt z bazy
		
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				result = new Car();
				result.setId(rs.getInt("id"));
				result.setMark(rs.getString("mark"));
				result.setModel(rs.getString("model"));
				result.setProductionYear(rs.getString("productionYear"));
				result.setMileage(rs.getString("mileage"));
				result.setBodyNumber(rs.getString("bodyNumber"));
				result.setOfferId(rs.getInt("offerId"));
				return result;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return result;
	}
	

	@Override
	public List<Car> getAll() {
		List<Car> result = new ArrayList<Car>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				Car car = new Car();
				
				car.setId(rs.getInt("id"));
				car.setMark(rs.getString("mark"));
				car.setModel(rs.getString("model"));
				car.setProductionYear(rs.getString("productionYear"));
				car.setMileage(rs.getString("mileage"));
				car.setBodyNumber(rs.getString("bodyNumber"));
				car.setOfferId(rs.getInt("offerId"));
				result.add(car);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Car byOfferId(int offerId) {
		Car result = null;			
		
		try {
			selectById.setInt(1, offerId);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				result = new Car();
				result.setId(rs.getInt("id"));
				result.setMark(rs.getString("mark"));
				result.setModel(rs.getString("model"));
				result.setProductionYear(rs.getString("productionYear"));
				result.setMileage(rs.getString("mileage"));
				result.setBodyNumber(rs.getString("bodyNumber"));
				result.setOfferId(rs.getInt("offerId"));
				return result;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return result;
	}

}
