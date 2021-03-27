public interface IList <T> {
    /**
     * Add an element to the end of the list
     * @param elem element to be added
     */
    public void add(T elem); //add to the end of the list
    public T get(int index);//throws an IndexOutOfBoundsException where appropriate
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


}