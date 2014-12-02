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

public class TransactionRepository extends Repository<Transaction> implements ITransactionRepository {
	

	

	public TransactionRepository(Connection connection, IEntityBuilder<Transaction> builder) {
		super(connection, builder);
		
	}




	@Override
	public Transaction ofBuyer(int buyerId) {
		
		try {
			selectById.setInt(1, buyerId);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {

				return builder.build(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Transaction ofOffer(int offerId) {
		
		try {
			selectById.setInt(1, offerId);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {

				return builder.build(rs);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public Transaction ofSeller(int sellerId) {
		
		try {
			selectById.setInt(1, sellerId);
			ResultSet rs = selectById.executeQuery();
			
			while(rs.next()) {

				return builder.build(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}




	@Override
	protected void setUpInsertQuery(Transaction entity) throws SQLException {
		insert.setInt(1, entity.getBuyerId());
		insert.setInt(2, entity.getSellerId());
		insert.setDouble(3, entity.getTotalPrice());
		insert.setString(4, entity.getDateOf());
		insert.setInt(5, entity.getOfferId());
		
	}




	@Override
	protected void setUpUpdateQuery(Transaction entity) throws SQLException {
		update.setInt(1, entity.getBuyerId());
		update.setInt(2, entity.getSellerId());
		update.setDouble(3, entity.getTotalPrice());
		update.setString(4, entity.getDateOf());
		update.setInt(5, entity.getOfferId());
		update.setInt(6, entity.getId());
		
	}




	@Override
	protected String getInsertQuery() {
		return "INSERT INTO transactions (buyerId, sellerId, totalPrice, dateOf, offerId) VALUES (?,?,?,?,?)";
	}




	@Override
	protected String getUpdateQuery() {
		return "UPDATE transactions SET buyerId=?, sellerId=?, totalPrice=?, dateOf=?, offerId=? WHERE id=?";
	}




	@Override
	protected String getTableName() {
		return "transactions";
	}

}
