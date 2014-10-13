package domain;

import java.util.ArrayList;
import java.util.List;

public class Transaction extends Entity{

	private List<Offer> offers;
	private Buyer buyer;
	private Seller seller;
	
	public Transaction(){
		setId(1);
		offers = new ArrayList<Offer>();
	}
	
	
	
	public List<Offer> getOffers() {
		return offers;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
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
