import java.io.Serializable;

/**
 * Different kinds of genres that a Book can be.
 */
public enum BookGenre implements Serializable {
	FICTION_ACTION("Action (Fiction)"), FICTION_COMEDY("Comedy (Fiction)"), FICTION_FANTASY("Fantasy (Fiction)"),
	NON_FICTION("Non-Fiction");

	String name;

	BookGenre(String name) {
		this.name = name;
	}

	/**
	 * Displays this genre as a human-readable name.
	 *
	 * @return The name of this genre type.
	 */
	public String display() {
		return this.name;
	}
}
