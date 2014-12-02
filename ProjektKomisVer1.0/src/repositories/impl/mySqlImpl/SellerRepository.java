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

public class SellerRepository extends Repository<Seller> implements ISellerRepository {
	

	
	
	public SellerRepository(Connection connection, IEntityBuilder<Seller> builder) {
		super(connection, builder);	
	}

	
	
	@Override
	protected String getTableName() {
		return "sellers";
	}
	
	
	@Override
	protected String getInsertQuery() {
		return "INSERT INTO sellers (firstName, lastName, pesel, phoneNumber) VALUES (?,?,?,?)";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE sellers SET firstName=?, lastName=?, pesel=?, phoneNumber=?"
				+ " WHERE id=?";
	}
	
	@Override
	protected void setUpInsertQuery(Seller entity) throws SQLException {
		insert.setString(1, entity.getFirstName());
		insert.setString(2, entity.getLastName());
		insert.setString(3, entity.getPesel());
		insert.setString(4, entity.getPhoneNumber());
		
	}

	@Override
	protected void setUpUpdateQuery(Seller entity) throws SQLException {
		update.setString(1, entity.getFirstName());
		update.setString(2, entity.getLastName());
		update.setString(3, entity.getPesel());
		update.setString(4, entity.getPhoneNumber());
		update.setInt(5, entity.getId());
		
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
