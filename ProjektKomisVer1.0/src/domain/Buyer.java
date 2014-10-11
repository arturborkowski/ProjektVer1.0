package domain;

public class Buyer extends Entity {

	private String firstName;
	private String lastName;
	private String pesel;
	private String phoneNumber;
	private Address address;
	private Transaction transaction;
	
	
	public Buyer() {
		// TODO Auto-generated constructor stub
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


	public Transaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	
}
