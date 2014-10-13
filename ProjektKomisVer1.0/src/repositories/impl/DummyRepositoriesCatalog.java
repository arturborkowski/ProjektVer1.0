package repositories.impl;

import repositories.ICarRepository;
import repositories.IRepositoriesCatalog;

public class DummyRepositoriesCatalog implements IRepositoriesCatalog {


	DummyDb db = new DummyDb();

	@Override
	public ICarRepository getCars() {
		return new DummyCarRepository(db);
	}
	

}
