import java.io.Serializable;

/**
 * A Book object stores metadata about a particular book, including authorship
 * and copyright info.
 */
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	public String title;
	public String authorName;
	public int yearReleased;
	public BookGenre bookGenre;

	/**
	 * Creates an uninitialised book (for e.g. loading).
	 */
	public Book() {
		// Default, uninitialised values.
	}

	/**
	 * Creates a new instance of a book.
	 *
	 * @param title        The title of the book.
	 * @param authorName   The author name in the format of ("Lastname, Firstname").
	 * @param yearReleased The year that the book was first released.
	 * @param bookGenre    The genre of the book.
	 */
	public Book(String title, String authorName, int yearReleased, BookGenre bookGenre) {
		this.title = title;
		this.authorName = authorName;
		this.yearReleased = yearReleased;
		this.bookGenre = bookGenre;
	}

	public String display() {
		return String.format("\"%s\", a %s book, written by %s and released in %d", this.title,
				this.bookGenre.display(), this.authorName, this.yearReleased);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Book) {
			Book b = (Book) o;
			return this.title.equals(b.title) && this.authorName.equals(b.authorName)
					&& this.yearReleased == b.yearReleased && this.bookGenre == b.bookGenre;
		}

		return false;
	}
}
