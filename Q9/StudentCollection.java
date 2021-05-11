import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 
 *
The goal of this task is to write a program that loads/stores a list of students in XML format. `StudentCollection.java` class contains
a list of `Student` instances. Each student has his/her `age` and `name`, which need to be saved as attributes of XML node. Additionally,
each student can have three possible properties: `height`, `weight` and `courses`. `courses` property contains a list of `course` elements.
Each course has a course `name` attribute and a `grade` value. Note that not every student has all three properties. Some properties of students may be missing
(for example, see the test cases in StudentsTest.java). You job is to implement the below two methods in `StudentCollection.java`:

* `saveToFile`
* `loadFromFile`

Note that these methods should take into account the available properties of a given student. You are allowed to add additional asserts
and test cases to test your solutions. You can use `getAttribute(String name)` and `setAttribute(String name, String value)` of `Element`
class to get and set the attributes of XML node. **Please upload `StudentCollection.java` to wattle!**
 */
public class StudentCollection {

	private final List<Student> students;

	public StudentCollection(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Implement this method to save the list of students to XML file
	 * HINT: `setAttribute(String name, String value)` in `Element` can be used to set `name` and `age` properties
	 * @param file
	 */
	public void saveToFile(File file) {
		//START YOUR CODE
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.newDocument();

			Element rootElement = d.createElement("Students");
			d.appendChild(rootElement);

			for (Student student : students) {
				Element subStudent = d.createElement("Student");

				subStudent.setAttribute("Name", student.getName());

				if (student.getAge() != null) {
					subStudent.setAttribute("Age", Integer.toString(student.getAge()));
				}

				if (student.getHeight() != null) {
					subStudent.setAttribute("Height", Integer.toString(student.getHeight()));
				}

				if (student.getWeight() != null) {
					subStudent.setAttribute("Weight", Integer.toString(student.getWeight()));
				}

				if (student.getCourses() != null) {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < student.getCourses().size(); i++) {
						String courseS = student.getCourses().get(i).getName() +
								"," + student.getCourses().get(i).getGrade();
						if (i == 0) {
							sb.append(courseS);
						} else {
							sb.append(";").append(courseS);
						}
					}
					subStudent.setAttribute("Courses", sb.toString());
				}

				rootElement.appendChild(subStudent);
			}

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(d);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//END YOUR CODE
	}

	/**
	 * Implement this method to load from the XML file to create a `StudentCollection`
	 * HINT: `getAttribute(String name)`in `Element` can be used to get `name` and `age` properties
	 * @param file
	 * @return
	 */
	public static StudentCollection loadFromFile(File file) {
		//START YOUR CODE
		List<Student> students = new ArrayList<>();

		try {
			Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

			d.getDocumentElement().normalize();

			NodeList nodeList = d.getElementsByTagName("Student");

			for (int i = 0; i < nodeList.getLength(); i++) {
				if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element currentStudent = (Element) nodeList.item(i);

					String name = currentStudent.getAttribute("Name");

					Integer age = null;
					if (!currentStudent.getAttribute("Age").equals("")) {
						age = Integer.parseInt(currentStudent.getAttribute("Age"));
					}

					Integer height = null;
					if (!currentStudent.getAttribute("Height").equals("")) {
						height = Integer.parseInt(currentStudent.getAttribute("Height"));
					}

					Integer weight = null;
					if (!currentStudent.getAttribute("Weight").equals("")) {
						weight = Integer.parseInt(currentStudent.getAttribute("Weight"));
					}

					List<Course> courses = null;
					if (!currentStudent.getAttribute("Courses").equals("")) {
						courses = new ArrayList<>();
						for (String course : currentStudent.getAttribute("Courses").split(";")) {
							courses.add(new Course(course.split(",")[0], Integer.parseInt(course.split(",")[1])));
						}
					}

					Student student = new Student();
					student.withName(name).withAge(age).withWeight(weight).withHeight(height);
					if (courses != null) {
						for (Course course : courses) {
							student.addCourse(course);
						}
					}
					students.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StudentCollection(students);
		//END YOUR CODE
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof StudentCollection) {
			StudentCollection studentCollection = (StudentCollection) o;
			return this.students.equals(studentCollection.students);
		}

		return false;
	}
}
