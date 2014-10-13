package domain;

public class Car extends Entity {

	private String mark;
	private String model;
	private String productionYear;
	private String engine;
	private String mileage;
	private String bodyNumber;
	private Offer offer;
	
	public Car() {
		setId(1);
		mark = "Volvo";
		model = "S80";
		productionYear = "2007";
		engine = "2.5 TSi";
		mileage = "85000";
		bodyNumber = "PHJK2332HH14903L-32";
		offer = null;
	}

	

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getBodyNumber() {
		return bodyNumber;
	}

	public void setBodyNumber(String bodyNumber) {
		this.bodyNumber = bodyNumber;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	

}
