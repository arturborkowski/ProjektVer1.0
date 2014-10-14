package repositories.impl;

import repositories.IBuyerRepository;
import repositories.ICarRepository;
import repositories.IOfferRepository;
import repositories.IRepositoriesCatalog;
import repositories.ISellerRepository;
import repositories.ITransactionRepository;

public class DummyRepositoriesCatalog implements IRepositoriesCatalog {


	DummyDb db = new DummyDb();

	@Override
	public ICarRepository getCar() {
		return new DummyCarRepository(db);
	}


	@Override
	public IOfferRepository getOffers() {
		return new DummyOfferRepository(db);
	}


	@Override
	public ITransactionRepository getTransaction() {
		return new DummyTransactionRepository(db);
	}


	@Override
	public ISellerRepository getSeller() {
		return new DummySellerRepository(db);
	}


	@Override
	public IBuyerRepository getBuyer() {
		return new DummyBuyerRepository(db);
	}
	
	

}
