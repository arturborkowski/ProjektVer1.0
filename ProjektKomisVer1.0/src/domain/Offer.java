package domain;

public class Offer extends Entity{

	private Car car;
	private int price;
	
	
	public Offer() {
		// TODO Auto-generated constructor stub
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

