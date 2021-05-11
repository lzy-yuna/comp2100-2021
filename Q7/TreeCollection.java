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
 The goal of this task it to write a program that loads/stores a list of trees in XML format. `TreeCollection.java` class contains a
 list of `Tree` instances. Each tree has its own `kind`, which needs to be saved as an attribute of XML node. Additionally, each tree
 can have three possible properties: `dimension`, `color` and `types`. `dimension` property has two integer attributes: `diameter` and
 `height`. `types` property has a list of `type` elements. Note that not every tree has all three properties. Some properties of trees
 may be missing (for example, see the test cases in TreesTest.java). You job is to implement the below methods in `TreeCollection.java`:

* `saveToFile`
* `loadFromFile`

Note that these methods should take into account the available properties of a given tree. You are allowed to add additional asserts
and test cases to test your solutions. You can use `getAttribute(String name)` and `setAttribute(String name, String value)` of `Element`
class to get and set the attributes of XML node. **Please upload `TreeCollection.java` file to wattle!**
 *
 */
public class TreeCollection {

	private final List<Tree> trees;

	public TreeCollection(List<Tree> trees) {
		this.trees = trees;
	}

	public List<Tree> getTrees() {
		return trees;
	}

	/**
	 * Implement this method to save the list of trees to XML file
	 * HINT: `setAttribute(String name, String value)` in `Element` can be used to set `kind`, `diameter` and `height` properties
	 * @param file
	 */
	public void saveToFile(File file) {
		//START YOUT CODE
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.newDocument();

			Element rootElement = d.createElement("TreeCollection");
			d.appendChild(rootElement);

			for (Tree tree : trees) {
				Element subTree = d.createElement("Tree");
				subTree.setAttribute("Kind", tree.getKind());

				if (tree.getDimension() != null) {
					subTree.setAttribute("Dimension", tree.getDimension().getDiameter() + " " +
							tree.getDimension().getHeight());
				}

				if (tree.getColor() != null) {
					subTree.setAttribute("Color", tree.getColor());
				}

				if (tree.getTypes() != null) {
					StringBuilder types = new StringBuilder();
					for (int i = 0; i < tree.getTypes().size(); i++) {
						if (i == 0) {
							types.append(tree.getTypes().get(i));
						} else {
							types.append(";").append(tree.getTypes().get(i));
						}
					}
					subTree.setAttribute("Types", types.toString());
				}

				rootElement.appendChild(subTree);
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

		//END YOUT CODE
	}

	/**
	 * Implement this method to load from the XML file to create a `TreeCollection`
	 * HINT: `getAttribute(String name)`in `Element` can be used to get `kind`, `diameter` and `height` properties
	 * @param file
	 * @return
	 */
	public static TreeCollection loadFromFile(File file) {
		//START YOUT CODE

		List<Tree> loadedTrees = new ArrayList<>();

		try {
			Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

			d.getDocumentElement().normalize();

			NodeList subTrees = d.getElementsByTagName("Tree");

			for (int i = 0; i < subTrees.getLength(); i++) {
				if (subTrees.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element subTree = (Element) subTrees.item(i);

					String kind = subTree.getAttribute("Kind");

					String dimensionString = subTree.getAttribute("Dimension");
					Dimension dimension = null;
					if (!dimensionString.equals("")) {
						dimension = new Dimension(Integer.parseInt(dimensionString.split(" ")[0]),
								Integer.parseInt(dimensionString.split(" ")[1]));
					}

					String color = null;
					if (!subTree.getAttribute("Color").equals("")) {
						color = subTree.getAttribute("Color");
					}

					String[] types = null;

					String typesString = subTree.getAttribute("Types");
					if (!typesString.equals("")) {
						types = typesString.split(";");
					}

					Tree tree = new Tree();
					tree.withKind(kind);
					tree.withColor(color);
					tree.withDimension(dimension);
					if (types != null) {
						for (String type : types) {
							tree.addType(type);
						}
					}

					loadedTrees.add(tree);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new TreeCollection(loadedTrees);
		//END YOUT CODE	
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof TreeCollection) {
			TreeCollection treeCollection = (TreeCollection) o;
			return this.trees.equals(treeCollection.trees);
		}

		return false;
	}
}
