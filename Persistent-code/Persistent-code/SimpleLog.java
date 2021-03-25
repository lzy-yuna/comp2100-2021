
/**
 * 
 * Class SimpleLog - simple representation for log entries
 * There are many logging frameworks, if you want to know more about it: java.util.logging package, Log4J or TinyLog are good options
 * 
 *
 */

public class SimpleLog{
	private int 	id;
	private String 	dateTime;
	private String 	errorMessage;
	private String 	level;
	private String 	className;
	private String 	methodName;
	
	public SimpleLog(int id, String dateTime, String errorMessage, String level, String className, String methodName) {
		this.id 			= id;
		this.dateTime 		= dateTime;
		this.errorMessage 	= errorMessage;
		this.level 			= level;
		this.className 		= className;
		this.methodName 	= methodName;
	}

	/*
	 * getters and setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	@Override
	public String toString()
	{
		return this.getId() + ", " + this.getDateTime() + "," + this.getErrorMessage() + 
				"," + this.getLevel() + "," + this.getClassName() + "," + this.getMethodName();
	}
}