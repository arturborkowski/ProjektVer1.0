package domain;

import java.util.ArrayList;
import java.util.List;

public class Offer extends Entity{

	private int carId;
	private double price;
	private List<Transaction> transactions;
	
	
	public Offer() {
		transactions = new ArrayList<Transaction>();
	}



	public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	
	
}

