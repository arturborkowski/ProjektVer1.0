package repositories;

import domain.*;

public interface IBuyerRepository extends IRepository<Buyer>{

	public Buyer ofTransaction(Transaction transaction);
	public Buyer ofTransaction(int transactionId);
	
}
