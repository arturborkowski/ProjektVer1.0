package repositories.impl.mySqlImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Car;
import domain.Offer;
import repositories.IOfferRepository;

public class OfferRepository extends Repository<Offer> implements IOfferRepository {
	

	private String insertSql = 
			"INSERT INTO offers (carId, price) VALUES (?,?)";
	private String updateSql =
			"UPDATE offers SET carId=?, price=? WHERE id=?";



	public OfferRepository(Connection connection, IEntityBuilder<Offer> builder) {
		super(connection, builder);
	}





	@Override
	protected void setUpInsertQuery(Offer entity) throws SQLException {
		insert.setInt(1, entity.getCarId());
		insert.setDouble(2, entity.getPrice());		
	}



	@Override
	protected void setUpUpdateQuery(Offer entity) throws SQLException {
		update.setInt(1, entity.getCarId());
		update.setDouble(2, entity.getPrice());
		update.setInt(3, entity.getId());		
		
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
		return "offers";
	}
	
	
	
	@Override
	public Offer withCarId(int carId) {
		
		try {
			selectById.setInt(1, carId);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				
				return builder.build(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
