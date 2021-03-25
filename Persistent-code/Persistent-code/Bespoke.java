import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bespoke {
	
	/*
	 * Contains information about log entries
	 * key = id, value = log object
	 */
	public Map<Integer, SimpleLog> data;
	
	public static void main(String[] args)
	{
		Bespoke b = new Bespoke();
		String delimiter = ",";
		
		//loading...
		
		b.loadData("resources/listoferrors.txt", delimiter);
			
		for(Map.Entry<Integer, SimpleLog> e : b.data.entrySet())
			System.out.println(e.getValue().toString());
			
		//saving...
		b.saveData("resources/listoferrors_1.txt", delimiter, true);
	}

	/*
	 * Save Data into a File
	 * @param filePath
	 * @param delimiter (comma, tab, semi-colon, ...)
	 * @param append 
	 */
	public void saveData(String filePath, String delimiter, Boolean append) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, append)))
		{
			/*
			 * There are many ways to write to a file in java. For example using FileWriter, FileOutputStream, BufferedWriter, ...
			 * BufferedWriter is very common, has a buffer (which is good when you have IO operations - may achieve better performance).
			 */
			for(Map.Entry<Integer, SimpleLog> e : data.entrySet())
			{
				SimpleLog p = e.getValue();

				String record = p.toString();

				bw.write(record); 
				bw.newLine();
				//bw.flush();
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void loadData(String filePath, String delimiter)
	{
		 try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
		 {
			 String record;

			 this.data = new HashMap<Integer, SimpleLog>();

			 while((record = br.readLine()) != null)
			 {
				 String[] tokens = record.split(delimiter);
				 int id = Integer.parseInt(tokens[0]);

				 SimpleLog p = new SimpleLog(id, tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
				 data.put(id, p);
			 }
		 }catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}