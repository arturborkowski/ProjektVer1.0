package repositories;

import domain.*;

public interface ITransactionRepository extends IRepository<Transaction>{

	public Transaction ofSeller(int sellerId);
	public Transaction ofBuyer(int buyerId);
	public Transaction ofOffer(int offerId);
	
}
