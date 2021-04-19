/**
 * Base class for Element, which contains a pair of key and value.
 */
 
public class Element<T extends Comparable<T>>{
    public T key;
    public Object value;

    public Element(T key, Object value){
        this.key = key;
        this.value = value;
    }

}
