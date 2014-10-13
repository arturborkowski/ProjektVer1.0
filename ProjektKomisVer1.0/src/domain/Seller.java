package domain;

import java.util.List;

public class Seller extends Entity{

	private String firstName;
	private String lastName;
	private String pesel;
	private String phoneNumber;
	private Address address;
	private List<Transaction> transactions;
	
	
	public Seller() {
		setId(1);
		firstName = "Zbigniew";
		lastName = "Malinowski";
		pesel = "54091865333";
		phoneNumber = "609-932-543";
		address = new Address();
	}

	

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPesel() {
		return pesel;
	}


	public void setPesel(String pesel) {
		this.pesel = pesel;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}



	public List<Transaction> getTransactions() {
		return transactions;
	}



	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}



	
}
