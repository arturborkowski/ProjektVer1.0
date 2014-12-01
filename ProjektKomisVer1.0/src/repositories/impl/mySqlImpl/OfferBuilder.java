package repositories.impl.mySqlImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Offer;

public class OfferBuilder implements IEntityBuilder<Offer> {


	@Override
	public Offer build(ResultSet rs) throws SQLException {
		Offer offer = new Offer();
		offer.setId(rs.getInt("id"));
		offer.setCarId(rs.getInt("carId"));
		offer.setPrice(rs.getDouble("price"));
		return offer;
	}

}
