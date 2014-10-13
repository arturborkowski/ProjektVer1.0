package domain;

import java.util.ArrayList;
import java.util.List;

public class Offer extends Entity{

	private Car car;
	private int price;
	private List<Transaction> transactions;
	
	
	public Offer() {
		setId(1);
		transactions = new ArrayList<Transaction>();
	}



	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	
	
}

