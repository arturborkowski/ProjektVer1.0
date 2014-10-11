package domain;

public class Transaction extends Entity{

	private Offer offer;
	private Buyer buyer;
	private Seller seller;
	
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Offer getOffer() {
		return offer;
	}


	public void setOffer(Offer offer) {
		this.offer = offer;
	}


	public Buyer getBuyer() {
		return buyer;
	}


	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}


	public Seller getSeller() {
		return seller;
	}


	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	
	

}
