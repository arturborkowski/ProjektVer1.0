package repositories.impl.mySqlImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Car;

public class CarBuilder implements IEntityBuilder<Car> {


	@Override
	public Car build(ResultSet rs) throws SQLException {
		Car car = new Car();
		car.setId(rs.getInt("id"));
		car.setMark(rs.getString("mark"));
		car.setModel(rs.getString("model"));
		car.setProductionYear(rs.getString("productionYear"));
		car.setMileage(rs.getString("mileage"));
		car.setBodyNumber(rs.getString("bodyNumber"));
		car.setOfferId(rs.getInt("offerId"));
		return car;
	}

}
