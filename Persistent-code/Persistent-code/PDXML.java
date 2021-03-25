import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class PDXML {
	
	List<Person> people;
	
	public PDXML()
	{
		people = new ArrayList<Person>();
	}
	
	public List<Person> loadData(String filePath)
	{
		File f = new File(filePath);
		//create a DocumentBuilder instance: DocumentBuilderFactory 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//list
		List<Person> lp = new ArrayList<Person>();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(f); //parse file f, it is the root of the document tree
			d.getDocumentElement().normalize(); //remove redundancies such as spaces between <  >, line breaks, some white spaces, ...
			
			//get the list of nodes by tag name (all <person> items)
			NodeList nl = d.getElementsByTagName("Person");
			
			for(int i = 0; i < nl.getLength(); i++)
			{
				Node n = nl.item(i); 
				if(n.getNodeType() == Node.ELEMENT_NODE) {
					Element element		= (Element) n;
					Integer id 			= Integer.parseInt(element.getAttribute("id"));	
					String firstname 	= element.getElementsByTagName("FirstName").item(0).getTextContent();
					String lastname 	= element.getElementsByTagName("LastName").item(0).getTextContent();
					
					Person p 			= new Person(id, firstname, lastname);
					lp.add(p);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lp;
	}
	
	public void saveData(String filePath)
	{
		File f = new File(filePath);
		
		//Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents. (see doc)
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			//DocumentBuilder obtain a Document from XML (parser)
			DocumentBuilder db = dbf.newDocumentBuilder(); //create a new instance of DocumentBuilder
			Document d = db.newDocument(); //obtain new instance of a DOM document

			//create the structure of my document
			Element rootElement = d.createElement("People");//<People>
			d.appendChild(rootElement); //append the root to the document

			//loop through all people to create each person element
			for(Person person : people)
			{
				Element personElement = d.createElement("Person");//<Person>..
				personElement.setAttribute("id", Integer.toString(person.getId()));//<Person id="1">..

				Element firstnameElement = d.createElement("FirstName");//<FirstName> ... </FirstName>
				firstnameElement.appendChild(d.createTextNode(person.getFirstname()));//<FirstName> here goes firstname </FirstName>
				personElement.appendChild(firstnameElement);//<Person id="1"><FirstName> here goes firstname </FirstName></Person>

				Element lastnameElement = d.createElement("LastName");
				lastnameElement.appendChild(d.createTextNode(person.getLastname()));
				personElement.appendChild(lastnameElement);
				
				rootElement.appendChild(personElement);
			}

			//transform a source tree into a result tree
			//Used to process XML from a variety of sources and write the transformation output to a variety of sinks (see transformer documentation)
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			//set encoding
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			//indent the output document
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			//create document 
			DOMSource source = new DOMSource(d); //Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
			StreamResult result = new StreamResult(f);//Acts as a holder for a transformation result, which may be XML,..
			transformer.transform(source, result); //Transform the XML Source to a Result.
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		PDXML xml = new PDXML();

		xml.people.add(new Person(10,"Lisa", "Simpson"));
		xml.people.add(new Person(11,"Homer", "Simpson"));
		xml.people.add(new Person(12,"Maggie", "Simpson"));

		xml.saveData("resources/people1.xml");

		List<Person> newPeople = xml.loadData("resources/people.xml");
		for(Person p : newPeople)
		{
			System.out.println(p.toString());
		}
	}
}