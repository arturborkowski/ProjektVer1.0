package repositories.impl.mySqlImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Seller;

public class SellerBuilder implements IEntityBuilder<Seller> {

	@Override
	public Seller build(ResultSet rs) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("id"));
		seller.setFirstName(rs.getString("firstName"));
		seller.setLastName(rs.getString("lastName"));
		seller.setPesel(rs.getString("pesel"));
		seller.setPhoneNumber(rs.getString("phoneNumber"));
		return seller;
	}

}
