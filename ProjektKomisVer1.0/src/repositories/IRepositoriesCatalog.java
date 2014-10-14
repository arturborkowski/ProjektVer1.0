package repositories;

public interface IRepositoriesCatalog {

	public ICarRepository getCar();
	public IOfferRepository getOffers();
	public ITransactionRepository getTransaction();
	public ISellerRepository getSeller();
	public IBuyerRepository getBuyer();
}
