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

public class BuyerRepository implements IBuyerRepository{

	private Connection connection;
	
	private String insertSql = 
			"INSERT INTO buyers (firstName, lastName, pesel, phoneNumber) VALUES (?,?,?,?)";
	private String selectByIdSql =
			"SELECT * FROM buyers WHERE id=?";
	private String updateSql =
			"UPDATE buyers SET firstName=?, lastName=?, pesel=?, phoneNumber=?"
			+ " WHERE id=?";
	private String deleteSql = 
			"DELETE FROM buyers WHERE id=?";
	private String selectAllSql =
			"SELECT * FROM buyers";
	
	PreparedStatement insert;
	PreparedStatement update;
	PreparedStatement selectById;
	PreparedStatement delete;
	PreparedStatement selectAll;
	
	public BuyerRepository(Connection connection) {
		this.connection = connection;
		
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

	
	@Override
	public void add(Buyer entity) {
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
	public void update(Buyer entity) {
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
	public void delete(Buyer entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Buyer get(int id) {
		Buyer result = null;
		
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				result = new Buyer();
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
	public List<Buyer> getAll() {

		List<Buyer> result = new ArrayList<Buyer>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			
			while(rs.next()) {
				Buyer buyer = new Buyer();
				buyer.setId(rs.getInt("id"));
				buyer.setFirstName(rs.getString("firstName"));
				buyer.setLastName(rs.getString("lastName"));
				buyer.setPesel(rs.getString("pesel"));
				buyer.setPhoneNumber(rs.getString("phoneNuber"));
				result.add(buyer);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
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
