/**
 * The given code is provided to assist you to complete the required tasks. But the 
 * given code is often incomplete. You have to read and understand the given code 
 * carefully, before you can apply the code properly. You might need to implement 
 * additional procedures, such as error checking and handling, in order to apply the 
 * code properly.
 */
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

// you need to import some xml libraries

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

// import any standard library if needed

/**
 * A book collection holds 0 or more books in a collection.
 */
public class BookCollection {
	private List<Book> books;

	/**
	 * Creates a new collection with no books by default.
	 */
	public BookCollection() {
		this.books = new ArrayList<Book>();
	}

	/**
	 * Creates a new book collection with the specified list of books pre-defined.
	 *
	 * @param books A books list.
	 */
	public BookCollection(List<Book> books) {
		this.books = books;
	}

	/**
	 * Returns the current list of books stored by this collection.
	 *
	 * @return A (mutable) list of books.
	 */
	public List<Book> getList() {
		return books;
	}

	/**
	 * Sets the list of books in this collection to the specified value.
	 */
	public void setList(List<Book> books) {
		this.books = books;
	}

	/**
	 * A simple human-readable toString implementation. Not particularly useful to
	 * save to disk.
	 *
	 * @return A human-readable string for printing
	 */
	@Override
	public String toString() {
		return this.books.stream().map(book -> " - " + book.display() + "\n").collect(Collectors.joining());
	}

	/**
	 * Saves this collection to the specified "bespoke" file.
	 *
	 * @param file The path to a file.
	 */
	public void saveToBespokeFile(File file) {
		// TODO: Implement this function yourself. The specific hierarchy is up to you,
		// but it must be in a bespoke format and should match the
		// load function.
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (Book element : this.books) {
				// Use ,,, as delimiter
				bw.write(element.title + ",,," + element.authorName + ",,," +
						element.yearReleased + ",,," + element.bookGenre.display());
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} ;
	}

	/**
	 * Saves this collection to the specified JSON file.
	 *
	 * @param file The path to a file.
	 */
	public void saveToJSONFile(File file) {
		// TODO: Implement this function yourself. The specific hierarchy is up to you,
		// but it must be in a JSON format and should match the load function.
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter fw = new FileWriter(file)) {
			gson.toJson(this.books, fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saves this collection to the specified XML file.
	 *
	 * @param file The path to a file.
	 */
	public void saveToXMLFile(File file) {
		// TODO: Implement this function yourself. The specific hierarchy is up to you,
		// but it must be in an XML format and should match the
		// load function.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.newDocument();

			Element rootElement = d.createElement("BookCollection");
			d.appendChild(rootElement);

			for (Book book : this.books) {
				Element titleElement = d.createElement("Book");
				titleElement.setAttribute("Title", book.title);

				Element authorElement = d.createElement("Author");
				authorElement.appendChild(d.createTextNode(book.authorName));
				titleElement.appendChild(authorElement);

				Element yearElement = d.createElement("YearReleased");
				yearElement.appendChild(d.createTextNode(Integer.toString(book.yearReleased)));
				titleElement.appendChild(yearElement);

				Element genreElement = d.createElement("BookGenre");
				genreElement.appendChild(d.createTextNode(book.bookGenre.display()));
				titleElement.appendChild(genreElement);

				rootElement.appendChild(titleElement);
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
			StreamResult result = new StreamResult(file);//Acts as a holder for a transformation result, which may be XML,..
			transformer.transform(source, result); //Transform the XML Source to a Result.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load a pre-existing book collection from a "bespoke" file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromBespokeFile(File file) {
		// TODO: Implement this function yourself.
		BookCollection rtn = new BookCollection();
		List<Book> book_list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			String line;
			// If there is next line, read-in it
			while ((line = br.readLine()) != null) {
				// Use ,,, as delimiter
				String[] element = line.split(",,,");
				// Look for the corresponding bookgenre
				BookGenre bookgenre = null;
				for (BookGenre genre : BookGenre.values()) {
					if (genre.name.equals(element[3]))
						bookgenre = genre;
				}
				if (bookgenre == null)
					throw new IllegalArgumentException("Bad argument for bookgenre, not in the enum type!");
				// New Book instance
				Book book = new Book(element[0], element[1], Integer.parseInt(element[2]), bookgenre);
				book_list.add(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rtn.setList(book_list);
		return rtn;
	}

	/**
	 * Load a pre-existing book collection from a JSON file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromJSONFile(File file) {
		// TODO: Implement this function yourself.
		Gson gson = new Gson();
		BookCollection rtn = new BookCollection();

		final Type BOOK_LIST_TYPE = new TypeToken<List<Book>>(){}.getType();
		try (JsonReader jr = new JsonReader(new FileReader(file))) {
			rtn.setList(gson.fromJson(jr, BOOK_LIST_TYPE));
		}catch (IOException e) {
			e.printStackTrace();
		}
		return rtn;
	}

	/**
	 * Load a pre-existing book collection from an XML file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromXMLFile(File file) {
		// TODO: Implement this function yourself.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		BookCollection rtn = new BookCollection();
		List<Book> book_list = new ArrayList<>();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(file);
			d.getDocumentElement().normalize();

			NodeList nodeList = d.getElementsByTagName("Book");

			for (int index = 0; index < nodeList.getLength(); index++) {
				if (nodeList.item(index).getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodeList.item(index);

					String title = element.getAttribute("Title");
					String author = element.getElementsByTagName("Author").item(0).getTextContent();
					int year = Integer.parseInt(element.getElementsByTagName("YearReleased").item(0).getTextContent());
					String genreS = element.getElementsByTagName("BookGenre").item(0).getTextContent();
					BookGenre bookgenre = null;

					for (BookGenre genre : BookGenre.values()) {
						if (genre.name.equals(genreS))
							bookgenre = genre;
					}
					if (bookgenre == null)
						throw new IllegalArgumentException("Bad argument for bookgenre, not in the enum type!");

					Book book = new Book(title, author, year ,bookgenre);
					book_list.add(book);
				}
				rtn.setList(book_list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rtn;
	}
}
