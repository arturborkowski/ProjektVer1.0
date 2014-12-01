package repositories.impl.mySqlImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Transaction;

public class TransactionBuilder implements IEntityBuilder<Transaction> {


	@Override
	public Transaction build(ResultSet rs) throws SQLException {
		Transaction tr = new Transaction();
		tr.setId(rs.getInt("id"));
		tr.setBuyerId(rs.getInt("buyerId"));
		tr.setSellerId(rs.getInt("sellerId"));
		tr.setTotalPrice(rs.getDouble("totalPrice"));
		tr.setDateOf(rs.getString("dateOf"));
		tr.setOfferId(rs.getInt("offerId"));
		return tr;
	}

}
