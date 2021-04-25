import java.util.Iterator;

public interface IList <T> extends Iterable<T> {
    /**
     * Add an element to the end of the list
     * @param elem element to be added
     */
    public void add(T elem); //add to the end of the list
    public void add(int index, T element);
    public T get(int index);//throws an IndexOutOfBoundsException where appropriate
    /**
     * Replaces the element at the specified position in this list with the specified element
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public T set(int index, T element);//throws an IndexOutOfBounds exception where appropriate
    public int size();
    /**
     *
     * @param index
     * @return the element removed from the list
     */
    public T remove(int index);//throws an IndexOutOfBoundsException where appropriate
    /**
     *
     * @param elem the element to remove
     * @return whether the elements was removed or not
     */
    public boolean remove(T elem);//throws an IndexOutOfBoundsException where appropriate
    public boolean isEmpty();
    /**
     * This is new (to the interface) but should be straightforward to implement
     * @param element the element to search found
     * @return whether the element was found or not
     */
    public boolean contains(T element);

//    public Iterator<T> iterator();

}