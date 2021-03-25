import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * To serialize an object means to convert its state to a byte stream so that the byte stream can be 
 * reverted back into a copy of the object. A Java object is serializable if its class or any of its 
 * superclasses implements either the java.io.Serializable interface or its subinterface, java.io.Externalizable. 
 * Deserialization is the process of converting the serialized form of an object back into a copy of the object.
 * For example, the java.awt.Button class implements the Serializable interface, so you can serialize a java.awt.Button 
 * object and store that serialized state in a file. Later, you can read back the serialized state and deserialize into 
 * a java.awt.Button object. https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html
 */
public class PDSerialization implements Serializable{

	private static final long serialVersionUID = 2L;
	public int id; //transient
	public String name;

	public PDSerialization(String name, int id)
	{
		this.name = name;
		this.id = id;
	}

	public static void main(String[] args) 
	{
		PDSerialization pds_sv = new PDSerialization("Lisa", 321);
		pds_sv.saveData("resources/listofpeople.ser");

		PDSerialization pds_ld = loadData("resources/listofpeople.ser");
		System.out.println("id: " + pds_ld.id + " - " + pds_ld.name);
		System.out.println(pds_ld);
	}

	public void saveData(String filePath)
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath)))
		{
			oos.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PDSerialization loadData(String filePath)
	{
		PDSerialization data = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath)))
		{	
			data = (PDSerialization) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return data;
	}
}
