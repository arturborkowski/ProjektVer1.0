package repositories;

import domain.*;

public interface IOfferRepository extends IRepository<Offer> {

	
	public Offer withCar(Car car);
}
