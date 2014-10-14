package repositories.impl;

import java.util.List;

import domain.Seller;
import domain.Transaction;
import repositories.ISellerRepository;

public class DummySellerRepository implements ISellerRepository{

	DummyDb db;
	
	public DummySellerRepository(DummyDb db)  {
		super();
		this.db = db;
	}

	@Override
	public void add(Seller entity) {
		db.sellers.add(entity);		
	}

	@Override
	public void update(Seller entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Seller entity) {
		db.sellers.remove(entity);		
	}

	@Override
	public Seller get(int id) {
		for(Seller s: db.sellers){
			if(s.getId()==id)
				return s;
		}
		return null;
	}

	@Override
	public List<Seller> getAll() {
		return db.sellers;
	}

	@Override
	public Seller ofTransaction(Transaction transaction) {
		for(Seller s: db.sellers){
			if(s.getTransactions().contains(transaction))
				return s;
		}
		return null;
	}

	@Override
	public Seller ofTransaction(int transactionId) {
		for(Seller s: db.sellers){
			for(Transaction t: s.getTransactions())
				if(t.getId()==transactionId)
					return s;
		}
		return null;
	}

}
