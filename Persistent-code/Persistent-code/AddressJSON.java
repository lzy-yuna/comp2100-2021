import com.google.gson.annotations.SerializedName;

public class AddressJSON {
	//@SerializedName("Cidade")
	private String city;
	private String country;
	
	public AddressJSON(String city, String country)
	{
		this.city = city;
		this.country = country;
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
	
	@Override
	public String toString(){
		return city + ", " + country;
	}
}
