package repositories.impl;

import java.util.List;

import domain.Buyer;
import domain.Offer;
import domain.Seller;
import domain.Transaction;
import repositories.ITransactionRepository;

public class DummyTransactionRepository implements ITransactionRepository {

	DummyDb db;
	
	public DummyTransactionRepository(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Transaction entity) {
		db.transactions.add(entity);
		
	}

	@Override
	public void update(Transaction entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Transaction entity) {
		db.transactions.remove(entity);		
	}

	@Override
	public Transaction get(int id) {
		for(Transaction tr: db.transactions) {
			if(tr.getId()==id)
				return tr;
		}
		return null;
	}

	@Override
	public List<Transaction> getAll() {
		return db.transactions;
	}

	@Override
	public Transaction ofSeller(Seller seller) {
		for(Transaction tr: db.transactions){
			if(tr.getSeller()==seller)
				return tr;
		}
		return null;
	}

	@Override
	public Transaction ofSeller(int sellerId) {
		for(Transaction tr: db.transactions){
			if(tr.getSeller().getId()==sellerId)
				return tr;
			}
		return null;
	}

	@Override
	public Transaction ofBuyer(Buyer buyer) {
		for(Transaction tr: db.transactions){
			if(tr.getBuyer()==buyer)
				return tr;
		}
		return null;
	}

	@Override
	public Transaction ofBuyer(int buyerId) {
		for(Transaction tr: db.transactions) {
			if(tr.getBuyer().getId()==buyerId)
				return tr;
		}
		return null;
	}

	@Override
	public Transaction ofOffer(Offer offer) {
		for(Transaction tr: db.transactions){
			if(tr.getOffers().contains(offer))
				return tr;
		}
		return null;
	}

	@Override
	public Transaction ofOffer(int offerId) {
		for(Transaction tr: db.transactions){
			for(Offer of: tr.getOffers()){
				if(of.getId()==offerId)
					return tr;
			}
		}
		return null;
	}

}
