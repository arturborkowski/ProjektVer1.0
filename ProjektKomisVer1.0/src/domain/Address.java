package domain;

public class Address {

	private String country;
	private String city;
	private String postalCode;
	private String street;
	private String houseNumber;
	private String localNumber;
	
	public Address() {
		country = "Poland";
		city = "Gdañsk";
		postalCode = "80-743";
		street = "D³uga";
		houseNumber = "15b";
		localNumber = "20";
	}

	
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

	
}
