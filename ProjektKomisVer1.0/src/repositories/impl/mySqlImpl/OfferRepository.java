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

public class OfferRepository implements IOfferRepository {
	
	private Connection connection;
	
	private String insertSql = 
			"INSERT INTO offers (carId, price) VALUES (?,?)";
	private String updateSql =
			"UPDATE offers SET carId=?, price=? WHERE id=?";
	private String deleteSql = 
			"DELETE FROM offers WHERE id=?";
	private String selectByIdSql = 
			"SELECT * FROM offers WHERE id=?";
	private String selectAllSql = 
			"SELECT * FROM offers";
	
	PreparedStatement insert;
	PreparedStatement update;
	PreparedStatement delete;
	PreparedStatement selectById;
	PreparedStatement selectAll;
	

	public OfferRepository(Connection connection) {
		this.connection = connection;
		
		try {
			insert = connection.prepareStatement(insertSql);
			update = connection.prepareStatement(updateSql);
			delete = connection.prepareStatement(deleteSql);
			selectById = connection.prepareStatement(selectByIdSql);
			selectAll = connection.prepareStatement(selectAllSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void add(Offer entity) {
		try {
			insert.setInt(1, entity.getCarId());
			insert.setDouble(2, entity.getPrice());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Offer entity) {
		try {
			update.setInt(1, entity.getCarId());
			update.setDouble(2, entity.getPrice());
			update.setInt(3, entity.getId());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void delete(Offer entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Offer get(int id) {
		Offer result = null;
		
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				result = new Offer();
				result.setId(rs.getInt("id"));
				result.setCarId(rs.getInt("carId"));
				result.setPrice(rs.getDouble("price"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Offer> getAll() {
		List<Offer> result = new ArrayList<Offer>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()){
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setCarId(rs.getInt("carId"));
				offer.setPrice(rs.getDouble("price"));
				result.add(offer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Offer withCarId(int carId) {
		Offer result = null;
		
		try {
			selectById.setInt(1, carId);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				result = new Offer();
				result.setId(rs.getInt("id"));
				result.setCarId(rs.getInt("carId"));
				result.setPrice(rs.getDouble("price"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


}
