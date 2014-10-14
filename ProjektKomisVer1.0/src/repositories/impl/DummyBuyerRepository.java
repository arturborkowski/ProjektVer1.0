package repositories.impl;

import java.util.List;

import domain.Buyer;
import domain.Seller;
import domain.Transaction;
import repositories.IBuyerRepository;

public class DummyBuyerRepository implements IBuyerRepository {

	DummyDb db;
	
	public DummyBuyerRepository(DummyDb db)  {
		super();
		this.db = db;
	}

	@Override
	public void add(Buyer entity) {
		db.buyers.add(entity);		
	}

	@Override
	public void update(Buyer entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Buyer entity) {
		db.buyers.remove(entity);		
	}

	@Override
	public Buyer get(int id) {
		for(Buyer b: db.buyers){
			if(b.getId()==id)
				return b;
		}
		return null;
	}

	@Override
	public List<Buyer> getAll() {
		return db.buyers;
	}

	@Override
	public Buyer ofTransaction(Transaction transaction) {
		for(Buyer b: db.buyers){
			if(b.getTransactions().contains(transaction))
				return b;
		}
		return null;
	}

	@Override
	public Buyer ofTransaction(int transactionId) {
		for(Buyer b: db.buyers){
			for(Transaction t: b.getTransactions())
				if(t.getId()==transactionId)
					return b;
		}
		return null;
	}

}
