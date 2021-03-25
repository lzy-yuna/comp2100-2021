import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class PDJSON {

	private List<PersonJSON> people;

	public PDJSON() {
		people = new ArrayList<PersonJSON>();
	}

	public void saveData(String filePath) {
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter fw = new FileWriter(filePath)){
			gson.toJson(people, fw);		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<PersonJSON> loadData(String filePath) {
		Gson gson = new Gson();
		JsonReader jsonReader = null;

		final Type CUS_LIST_TYPE = new TypeToken<List<PersonJSON>>() {}.getType();
		//or TypeToken.getParameterized(ArrayList.class, PersonJSON.class).getType();
		
		try{
			jsonReader = new JsonReader(new FileReader(filePath));
		}catch (Exception e) {
			e.printStackTrace();
		}

		return gson.fromJson(jsonReader, CUS_LIST_TYPE); 
	}

	public static void main(String[] args) {
		PDJSON pdj = new PDJSON();
		pdj.people.add(new PersonJSON(1,"Bart", "Simpson", new AddressJSON("Springfield", "USA")));
		pdj.people.add(new PersonJSON(2,"Homer", "Simpson", new AddressJSON("Springfield", "USA")));
		pdj.people.add(new PersonJSON(3,"Mickey", "Mouse", new AddressJSON("Orlando", "USA")));

		pdj.saveData("resources/listofpeople.json");

		List<PersonJSON> lp = pdj.loadData("resources/listofpeople.json"); 
		for(PersonJSON pj : lp)
		{
			System.out.println(pj.toString());
		}
	}
}