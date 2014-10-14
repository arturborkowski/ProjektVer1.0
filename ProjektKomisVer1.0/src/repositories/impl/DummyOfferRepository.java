package repositories.impl;

import java.util.List;

import domain.Car;
import domain.Offer;
import repositories.IOfferRepository;

public class DummyOfferRepository implements IOfferRepository {

	private DummyDb db;
	
	public DummyOfferRepository(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public Offer withCar(Car car) {
		for(Offer of: db.offers){
			if(of.getCar()==car)
				return of;
		}
		return null;
	}

	@Override
	public void add(Offer entity) {
		db.offers.add(entity);		
	}

	@Override
	public void update(Offer entity) {
		
	}

	@Override
	public void delete(Offer entity) {
		db.offers.remove(entity);		
	}

	@Override
	public Offer get(int id) {
		for(Offer of: db.offers){
			if(of.getId()==id)
				return of;
		}
		return null;
	}

	@Override
	public List<Offer> getAll() {
		return db.offers;
	}

}
