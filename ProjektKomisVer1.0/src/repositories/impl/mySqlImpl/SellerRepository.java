package repositories.impl.mySqlImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Seller;
import domain.Transaction;
import repositories.ISellerRepository;

public class SellerRepository implements ISellerRepository {
	
	private Connection connection;

	
	private String insertSql =
			"INSERT INTO sellers (firstName, lastName, pesel, phoneNumber) VALUES (?,?,?,?)";
	private String selectByIdSql =
			"SELECT * FROM sellers WHERE id=?";
	private String updateSql =
			"UPDATE sellers SET firstName=?, lastName=?, pesel=?, phoneNumber=?"
			+ " WHERE id=?";
	private String deleteSql = 
			"DELETE FROM sellers WHERE id=?";
	private String selectAllSql =
			"SELECT * FROM sellers";
	
	PreparedStatement insert;
	PreparedStatement selectById;
	PreparedStatement update;
	PreparedStatement delete;
	PreparedStatement selectAll;
	
	
	public SellerRepository(Connection connection) {
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
	public void add(Seller entity) {

		try {
			
			insert.setString(1, entity.getFirstName());
			insert.setString(2, entity.getLastName());
			insert.setString(3, entity.getPesel());
			insert.setString(4, entity.getPhoneNumber());
			insert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Seller entity) {
		
		try {
			
			update.setString(1, entity.getFirstName());
			update.setString(2, entity.getLastName());
			update.setString(3, entity.getPesel());
			update.setString(4, entity.getPhoneNumber());
			update.setInt(5, entity.getId());
			update.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}

	@Override
	public void delete(Seller entity) {
		
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Seller get(int id) {
		
		Seller result = null;
		
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				result = new Seller();
				result.setId(rs.getInt("id"));
				result.setFirstName(rs.getString("firstName"));
				result.setLastName(rs.getString("lastName"));
				result.setPesel(rs.getString("pesel"));
				result.setPhoneNumber(rs.getString("phoneNumber"));
				return result;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Seller> getAll() {
		
		List<Seller> result = new ArrayList<Seller>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()) {
				Seller seller = new Seller();
				seller.setId(rs.getInt("id"));
				seller.setFirstName(rs.getString("firstName"));
				seller.setLastName(rs.getString("lastName"));
				seller.setPesel(rs.getString("pesel"));
				seller.setPhoneNumber(rs.getString("phoneNumber"));
				result.add(seller);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Seller ofTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller ofTransaction(int transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
