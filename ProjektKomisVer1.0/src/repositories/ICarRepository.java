package repositories;

import domain.*;

public interface ICarRepository extends IRepository<Car> {
	
	/* Wyszukuje samochody po ofercie, a przeci¹¿ona metoda 
	 * po ID oferty
	 */
	
	public Car byOffer(Offer offer);
	public Car byOffer(int offerId);
}
