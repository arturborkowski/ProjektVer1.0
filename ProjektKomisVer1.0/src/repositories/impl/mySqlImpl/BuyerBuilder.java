package repositories.impl.mySqlImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Buyer;

public class BuyerBuilder implements IEntityBuilder<Buyer> {


// implementacja metody z IBuilderRepository (tworzy obiekt Buyer)
	@Override
	public Buyer build(ResultSet rs) throws SQLException {
		Buyer buyer = new Buyer();
		buyer.setId(rs.getInt("id"));
		buyer.setFirstName(rs.getString("firstName"));
		buyer.setLastName(rs.getString("lastName"));
		buyer.setPesel(rs.getString("pesel"));
		buyer.setPhoneNumber(rs.getString("phoneNumber"));
		return buyer;
	}

}
