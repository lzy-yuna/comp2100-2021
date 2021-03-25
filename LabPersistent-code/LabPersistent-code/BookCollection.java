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


		
		
		
	}

	/**
	 * Saves this collection to the specified JSON file.
	 *
	 * @param file The path to a file.
	 */
	public void saveToJSONFile(File file) {
		// TODO: Implement this function yourself. The specific hierarchy is up to you,
		// but it must be in a JSON format and should match the load function.

		
		
		
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
	
		
		
		
	}

	/**
	 * Load a pre-existing book collection from a "bespoke" file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromBespokeFile(File file) {
		// TODO: Implement this function yourself.
		
		
		
	}

	/**
	 * Load a pre-existing book collection from a JSON file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromJSONFile(File file) {
		// TODO: Implement this function yourself.

	
		
		
	}

	/**
	 * Load a pre-existing book collection from an XML file.
	 *
	 * @param file The file to load from. This is guaranteed to exist.
	 * @return An initialised book collection.
	 */
	public static BookCollection loadFromXMLFile(File file) {
		// TODO: Implement this function yourself.
		
		
		
		
	}
}
