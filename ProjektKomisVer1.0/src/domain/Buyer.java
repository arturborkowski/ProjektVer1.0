package domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Entity {

	private String firstName;
	private String lastName;
	private String pesel;
	private String phoneNumber;
	private Address address;
	
	private List<Transaction> transactions;
	
	
	public Buyer() {
		setId(1);
		firstName = "Jan";
		lastName = "Kowalski";
		pesel = "45021309342";
		phoneNumber = "511-232-123";
		address = new Address();
		transactions = new ArrayList<Transaction>();
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


	public void setTransaction(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}



}
