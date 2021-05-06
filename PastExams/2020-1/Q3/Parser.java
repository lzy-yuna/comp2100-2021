import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Implement a parser to extract the columns and values from tokens and execute
 * the SQL command to insert new customers. Do not insert customers if the
 * following errors are found: 
 * 1 - some brackets are missing 
 * 2 - some column names are wrong
 * 
 * Please see the columns names in Customer.java file. Please see test cases in
 * ParserTest.java
 */
public class Parser {

	Tokeniser tokeniser;
	XMLTable table;

	public Parser(Tokeniser tokeniser, XMLTable table) {
		this.tokeniser = tokeniser;
		this.table = table;
	}

	/**
	 * Extract the columns and values from tokens and execute the SQL command to insert new customers
	 */
	public void parseExp() {

		// TODO: Complete this method
		// START YOUR CODE
		if (tokeniser.hasNext()) {
			Token nextCommand = tokeniser.takeNext();

			if (nextCommand != null) {
				if (nextCommand.type == Token.Type.INSERT_INTO) {
					String tableName = nextCommand.value.split(" ")[0];
					String columnString = nextCommand.value.split(" ")[1];
					boolean validColumns = true;
					String[] columns = columnString.substring(1, columnString.length() - 1).split(",");
					List<String> columnsTrue = Arrays.asList(Customer.KEY_ID, Customer.KEY_NAME, Customer.KEY_CITY,
						Customer.KEY_ADDRESS, Customer.KEY_POSTCODE, Customer.KEY_COUNTRY);
					for (String column : columns) {
						if (!columnsTrue.contains(column)) {
							validColumns = false;
							break;
						}
					}
					if (validColumns) {
						if (tokeniser.hasNext()) {
							Token values = tokeniser.takeNext();
							if (values.type == Token.Type.VALUES) {
								String insertValueBracket = values.value;
								String[] insertValues = insertValueBracket.substring(1, insertValueBracket.length() - 1).split(",");
								for (int i  = 0; i < insertValues.length; i++) {
									insertValues[i] = insertValues[i].replace("'", "").strip();
								}
								Customer c = new Customer(Integer.parseInt(insertValues[0]), insertValues[1], insertValues[2],
										insertValues[3], insertValues[4], insertValues[5]);
								table.insert(tableName, c);
							}
						}
					}
				}
			}
		}

		// END YOUR CODE
	}
}
