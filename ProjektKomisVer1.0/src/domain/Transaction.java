package domain;

import java.util.List;

public class Transaction extends Entity{

	private List<Offer> offers;
	private List<Buyer> buyers;
	private List<Seller> sellers;
	
	public Transaction(){
		
	}
	
	
	
	public List<Offer> getOffers() {
		return offers;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	public List<Buyer> getBuyers() {
		return buyers;
	}
	public void setBuyers(List<Buyer> buyers) {
		this.buyers = buyers;
	}
	public List<Seller> getSellers() {
		return sellers;
	}
	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}
	
	
	
	
	

}
