package repositories.impl;

import java.util.ArrayList;
import java.util.List;

import domain.Car;
import domain.Offer;
import repositories.ICarRepository;

public class DummyCarRepository implements ICarRepository {

	
	private DummyDb db;
	
	public DummyCarRepository(DummyDb db) {
		super();
		this.db = db;
	}

	
	@Override
	public void add(Car entity) {
		db.cars.add(entity);
	}

	@Override
	public void update(Car entity) {
		
	}

	@Override
	public void delete(Car entity) {
		db.cars.remove(entity);		
	}

	@Override
	public Car get(int id) {
		for(Car c: db.cars){
			if(c.getId()==id)
				return c;
		}
		return null;
	}

	@Override
	public List<Car> getAll() {
		return db.cars;
	}


	@Override
	public Car byOffer(Offer offer) {
		for(Offer of: db.offers) {
			if(of == offer){
				return of.getCar();
			}
		}
		return null;
	}


	@Override
	public Car byOffer(int offerId) {
		for(Offer of: db.offers) {
			if(of.getId() == offerId){
				return of.getCar();
			}
		}
		return null;
	}

}
