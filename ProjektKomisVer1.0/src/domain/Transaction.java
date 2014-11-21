package domain;

import java.util.ArrayList;
import java.util.List;

public class Transaction extends Entity{

	private int offerId;
	private int buyerId;
	private int sellerId;
	private double totalPrice;
	private String dateOf;
	
	


	public Transaction(){
		
	}
	
	
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
		
	public String getDateOf() {
		return dateOf;
	}

	public void setDateOf(String dateOf) {
		this.dateOf = dateOf;
	}



}
