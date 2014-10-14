package repositories;

import domain.*;

public interface ISellerRepository extends IRepository<Seller>{

	public Seller ofTransaction(Transaction transaction);
	public Seller ofTransaction(int transactionId);
	
}
