package repositories.impl.mySqlImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import domain.Buyer;
import domain.Offer;
import domain.Seller;
import domain.Transaction;
import repositories.ITransactionRepository;

public class TransactionRepository implements ITransactionRepository {
	
	Connection connection;
	
	private String insertSql = 
			"INSERT INTO transactions (buyerId, sellerId, totalPrice, dateOf, offerId) VALUES (?,?,?,?,?)";
	private String updateSql =
			"UPDATE transactions SET buyerId=?, sellerId=?, totalPrice=?, dateOf=?, offerId=? WHERE id=?";
	private String deleteSql = 
			"DELETE FROM transactions WHERE id=?";
	private String selectByIdSql = 
			"SELECT * FROM transactions WHERE id=?";
	private String selectAllSql = 
			"SELECT * FROM transactions";

	PreparedStatement insert;
	PreparedStatement update;
	PreparedStatement delete;
	PreparedStatement selectById;
	PreparedStatement selectAll;
	
	public TransactionRepository(Connection connection) {
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
	public void add(Transaction entity) {
		try {
			insert.setInt(1, entity.getBuyerId());
			insert.setInt(2, entity.getSellerId());
			insert.setDouble(3, entity.getTotalPrice());
			insert.setString(4, entity.getDateOf());
			insert.setInt(5, entity.getOfferId());
			insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Transaction entity) {
		try {
			update.setInt(1, entity.getBuyerId());
			update.setInt(2, entity.getSellerId());
			update.setDouble(3, entity.getTotalPrice());
			update.setString(4, entity.getDateOf());
			update.setInt(5, entity.getOfferId());
			update.setInt(6, entity.getId());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Transaction entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Transaction get(int id) {
		Transaction result = null;
		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				result = new Transaction();
				result.setId(rs.getInt("id"));
				result.setBuyerId(rs.getInt("buyerId"));
				result.setSellerId(rs.getInt("sellerId"));
				result.setTotalPrice(rs.getDouble("totalPrice"));
				result.setDateOf(rs.getString("dateOf"));
				result.setOfferId(rs.getInt("offerId"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}

	@Override
	public List<Transaction> getAll() {
		List<Transaction> result = new ArrayList<Transaction>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			
			while(rs.next()) {
				Transaction tr = new Transaction();
				tr.setId(rs.getInt("id"));
				tr.setBuyerId(rs.getInt("buyerId"));
				tr.setSellerId(rs.getInt("sellerId"));
				tr.setTotalPrice(rs.getDouble("totalPrice"));
				tr.setDateOf(rs.getString("dateOf"));
				tr.setOfferId(rs.getInt("offerId"));
				result.add(tr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public Transaction ofSeller(int sellerId) {
		Transaction result = null;
		
		try {
			selectById.setInt(1, sellerId);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				result = new Transaction();
				result.setId(rs.getInt("id"));
				result.setBuyerId(rs.getInt("buyerId"));
				result.setSellerId(rs.getInt("sellerId"));
				result.setTotalPrice(rs.getDouble("totalPrice"));
				result.setDateOf(rs.getString("dateOf"));
				result.setOfferId(rs.getInt("offerId"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Transaction ofBuyer(int buyerId) {
		Transaction result = null;
		
		try {
			selectById.setInt(1, buyerId);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				result = new Transaction();
				result.setId(rs.getInt("id"));
				result.setBuyerId(rs.getInt("buyerId"));
				result.setSellerId(rs.getInt("sellerId"));
				result.setTotalPrice(rs.getDouble("totalPrice"));
				result.setDateOf(rs.getString("dateOf"));
				result.setOfferId(rs.getInt("offerId"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Transaction ofOffer(int offerId) {
		Transaction result = null;
		
		try {
			selectById.setInt(1, offerId);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {
				result = new Transaction();
				result.setId(rs.getInt("id"));
				result.setBuyerId(rs.getInt("buyerId"));
				result.setSellerId(rs.getInt("sellerId"));
				result.setTotalPrice(rs.getDouble("totalPrice"));
				result.setDateOf(rs.getString("dateOf"));
				result.setOfferId(rs.getInt("offerId"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
