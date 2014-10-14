package repositories;

import domain.*;

public interface ITransactionRepository extends IRepository<Transaction>{

	public Transaction ofSeller(Seller seller);
	public Transaction ofSeller(int sellerId);
	public Transaction ofBuyer(Buyer buyer);
	public Transaction ofBuyer(int buyerId);
	public Transaction ofOffer(Offer offer);
	public Transaction ofOffer(int offerId);
	
}
