import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Some basic tests for the Book Collection class.
 */
public class BookCollectionTest {
	private BookCollection collection;

	@Before
	public void createCollection() {
		// Create a new collection
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book("Thinking in Java (4th ed.)", "Eckel, Bruce", 2006, BookGenre.NON_FICTION));
		books.add(new Book("The Ultimate Hitchhiker's Guide to the Galaxy", "Adams, Douglas", 1979,
				BookGenre.FICTION_COMEDY));
		books.add(new Book("The Hobbit", "Tolkien, J.R.R.", 1937, BookGenre.FICTION_FANTASY));

		this.collection = new BookCollection(books);
	}

	@Test(timeout=1000)
	public void testBespoke() throws Exception {
		// Save it to the specified file.
		File file = new File("my_book_collection.bin");

		// Ensure that there is nothing there right now:
		file.delete();

		this.collection.saveToBespokeFile(file);

		// Load it from the specified file.
		BookCollection comparisonCollection = BookCollection.loadFromBespokeFile(file);

		compareCollections(this.collection, comparisonCollection);

		// Delete file after test
		file.delete();
	}

	@Test(timeout=1000)
	public void testJSON() throws Exception {
		// Save it to the specified file.
		File file = new File("my_book_collection.json");

		// Ensure that there is nothing there right now:
		file.delete();

		this.collection.saveToJSONFile(file);

		// Load it from the specified file.
		BookCollection comparisonCollection = BookCollection.loadFromJSONFile(file);

		compareCollections(this.collection, comparisonCollection);

		// Delete file after test
		file.delete();
	}

	@Test(timeout=1000)
	public void testXML() throws Exception {

		// Save it to the specified file.
		File file = new File("my_book_collection.xml");

		// Ensure that there is nothing there right now:
		file.delete();

		this.collection.saveToXMLFile(file);

		// Load it from the specified file.
		BookCollection comparisonCollection = BookCollection.loadFromXMLFile(file);

		compareCollections(this.collection, comparisonCollection);

		// Delete file after test
		file.delete();
	}

	/**
	 * Checks that two collections are identical.
	 *
	 * @param goodCollection       The known good collection.
	 * @param comparisonCollection The potentially bad collection.
	 */
	private static void compareCollections(BookCollection goodCollection, BookCollection comparisonCollection) {
		
		assertNotNull(goodCollection);
		assertNotNull(comparisonCollection);
		
		// Check that they are of the same length
		assertEquals(goodCollection.getList().size(), comparisonCollection.getList().size());

		// Check that the fields of each book match
		for (int i = 0; i < comparisonCollection.getList().size(); i++) {
			Book knownGoodBook = goodCollection.getList().get(i);
			Book loadedBook = comparisonCollection.getList().get(i);

			assertEquals(knownGoodBook, loadedBook);
		}
	}
}
