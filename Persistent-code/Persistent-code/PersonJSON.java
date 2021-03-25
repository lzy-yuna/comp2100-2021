
public class PersonJSON {
	private int id;
	private String firstname;
	private String lastname;
	private AddressJSON address;
	
	public PersonJSON(int id, String firstname, String lastname, AddressJSON address)
	{
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public AddressJSON getAddress() {
		return address;
	}

	public void setAddress(AddressJSON address) {
		this.address = address;
	}

	public String toString()
	{
		return "id: " + this.id + " - Firstname: " + this.firstname + " - Lastname: " + this.lastname + ", " + getAddress().toString();
	}
}
