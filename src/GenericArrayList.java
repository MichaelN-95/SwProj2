
//TODO Clean up code and comment

import java.util.Iterator;
import java.util.NoSuchElementException;


public class GenericArrayList<T> implements IList<T>, Iterable<T>{

    //This will hold our data - remember an ArrayList is nothing more than a managed array
    private T[] buffer;

    //Index of next free location - will also help us to determine if the buffer is full
    private int size;

    // This will change as buffer fills up and we allocate more and more storage space
    private int currentCapacity;

    private static final int INITIAL_CAPACITY = 3;//nice and small so that we test it quickly
    //Default Constructor
    public GenericArrayList(){
        currentCapacity = INITIAL_CAPACITY;
        size = 0;
        buffer = (T[]) new Object[currentCapacity];
    }
    /** Add to the end of the list.
     *
     * Each time you need to grow the array you should declare a temporary array
     * which is double the currentCapacity of buffer.
     *
     * Copy everything in buffer to tempArray
     *
     * Then update the buffer reference to refer to tempArray
     *
     * @param elem The data to be added to the end of the managed array
     */
    @Override
    public void add(T elem){
        growArrayIfNeeded(); //I've farmed this out to a private "helper" method

        buffer[size++] = elem;
    }

    /**
     * Add an element to a specified index. Make sure to avoid adding beyond the end of the
     * array (no gaps or bufferOverflows).
     * Also, remember to "grow" the managed array, if required. * @param index where to insert (ignore if greater than nextFreeLoc - otherwise you'll get gaps)
     * @param elem the data to insert
     */
    public void add(int index, T elem){
        //if it's valid
        if (index <= size)
        {
            //Make sure that we "grow" the array if needed.
            growArrayIfNeeded();

            //shuffle everything up from right to left //Note that this is a much easier mechanism to implement than trying to insert the new
            //element and then shuffle everything from left to right
            if (size - index >= 0) System.arraycopy(buffer, index, buffer, index + 1, size - index);

            //Now everything has moved up we can simply insert the new element
            buffer[index] = elem;
            //Obviously, we've added an extra element so we must update to reflect this
            size++;
        }
    }
    /** Retrieve an element from the list
     *
     * @param index the location to be return
     * @return the data at buffer[index]
     */
    @Override
    public T get(int index){
        if(index >= size)
        {
            return null;
        }
        return buffer[index];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
        T removed;
        if (index>size){
            throw new IndexOutOfBoundsException();
        }else {
            removed = buffer[index];
            buffer[index] = element;
        }
        return removed;
    }

    /**
     * Searches through the array to see if a matching element is present
     * Note: We already use this mechanism for one of the remove() methods.
     * @param elem element to search the array for
     * @return whether the element was present in the list or not
     */
    @Override
    public boolean contains(T elem) {
        boolean matchFound = false;
        for (int index = 0; index <= size && !matchFound; index++){
            if(buffer[index].equals(elem)){
                matchFound = true;
            }
        }
        return matchFound;
    }

    /**
     *
     * @return whether the list is empty or not
     */
    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }

    /**
     *
     * @return the size (i.e. the number of elements stored) in the list
     */
    @Override
    public int size() {
        //System.out.println(buffer.length);
        return size;
    }

    @Override
    public T remove(int index) {
        if(index>=size || index < 0 ){throw new RuntimeException("Invalid index");}
        T element = (T) buffer[index];
        --size;
        System.arraycopy(buffer, index + 1, buffer, index, size - index);
        buffer[size] = null;
        return element;
    }

    /**
     * Removes the first occurrence of an element from the array
     * It does this by "closing the gap" after/if it finds a matching element in the array.
     * @param elem the element to remove
     */
    @Override
    public boolean remove(T elem) {
        boolean matchFound = false;
            if (contains(elem)) {
                for (int index = 0; index < size && !matchFound; index++) {
                    if (buffer[index].equals(elem)) {
                        matchFound = true;
                        --size;
                        System.arraycopy(buffer, index + 1, buffer, index, size - index);
                        buffer[size] = null;
                    }
                }
            }
        return matchFound;
    }

    /**
     * Private helper method to check if the currently allocated space is full.
     * If it is then it will allocate a bigger array, copy the contents, and set our
     * instance field (buffer) to refer to the newly allocated space.
     */
    private void growArrayIfNeeded(){
        if(size == currentCapacity){
            //Allocate double the space - that will keep us going for a while
            T[] tempArr = (T[]) new Object[buffer.length * 2];
            currentCapacity *= 2;
            //copy from the old space into the new
            for(int i = 0; i < buffer.length; i++){
                tempArr[i] = buffer[i];
            }
            //Now, update so that our managed array points at the newly created array
            buffer = tempArr;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericArrayListIterator();
    }

    @Override
    public void rotate(int distance) {
        for (int i = 0; i < distance; i++) {

            // take out the first element
            T temp = get(0);
            for (int j = 0; j < size() - 1; j++) {

                // shift array elements towards left by 1 place
                set(j,get(j+1));
            }
            set(size()-1, temp);
        }
    }

    //This is an inner-class of the GenericArrayList class
    class GenericArrayListIterator implements Iterator<T>{
        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if(cursor == size){
                throw new NoSuchElementException();
            }
            return buffer[cursor++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }
}

