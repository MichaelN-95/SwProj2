import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.function.Consumer;


public class GenericLinkedList<T> implements IList<T>, Iterable<T> {
    Node head; // head of list
    Node tail; // tail of list
    int size; //size of list

    @Override
    public void add(T elem) {
        if (size>0) {
            //setting up the tail/end of the list and adding the value
            Node prev = tail;
            tail = new Node(elem);

            prev.next = tail;
        }
        //if list is empty make this the first node
        else {
            tail = new Node(elem);
            head = tail;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        int counter = 0;
        if (index>size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node trailing = null, current;

        if (index ==0){
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
            size++;
        }
        else {
            counter = 1; //beginning of the list
            current = head;
            while (counter != index) //while the position has not been found
            {
                trailing = current;
                current = current.next;
                counter++;
            }
            trailing.next.data = element;
        }

    }

    @Override
    public T get(int i) {
        int counter;
        Node current;
        if (i ==0){
            return head.data;
        }else {
            try {
                counter = 1; //beginning of the list
                current = head;
                while (counter != i) //while the position has not been found
                {
                    current = current.next;
                    counter++;
                }
                return current.data;
            }catch (NullPointerException e){
                System.out.println("Could not find item at index: " +i);
                return null;
            }
        }
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
        int counter = 0;
        if (index>size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node trailing = null, current;

        if (index ==1){
            current = head;
            head.data = element;
        }
        else {
            counter = 1; //beginning of the list
            current = head;
            while (counter != index) //while the position has not been found
            {
                trailing = current;
                current = current.next;
                counter++;
            }
            trailing.next.data = element;
        }
        return current.data;
    }


    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @param index
     * @return the element removed from the list
     */
    @Override
    public T remove(int index) {

//        System.out.println("index called");
        int counter ; // the current position on the list
        Node leader ; // the current node
        Node trailer ; // the previous node
        Node removed;
        try {
            if (index == 0) // The head of the list is deleted
            {
                removed = head;
                head = head.next; // The next node becomes the new head
                size--; //dectement size of the list
                return removed.data;
            } else if (index > 1)// find the node at the desired position
            {
                counter = 1; //beginning of the list
                leader = head;
                trailer = leader;
                while (counter != index) //while the position has not been found
                {
                    trailer = leader; // iterate through the list
                    leader = leader.next;
                    counter++;
                }
                removed = trailer.next;
                trailer.next = leader.next; //delete the desired node
                size--; //decrement size of the list
                return removed.data;
            }
        }catch (NullPointerException e){
            System.out.println("Could not find item at index: " + index);
        }

        return null;
    }

    /**
     *
     * @param elem the element to remove
     * @return whether the elements was removed or not
     */
    @Override
    public boolean remove(T elem) {
//        System.out.println("elem called");
        Node leader = head; // the current node
        Node trailer ; // the previous node

        //confirming elem is in the list
        if (contains(elem)){
            //if the sent element is first in the list
            if (elem == head.data){
                head = head.next;
                return true;
            }else if (elem== tail.data){
                trailer = leader;
                while (leader.next != null) {
                    trailer = leader;
                    leader = leader.next;
                }
                trailer.next = null;
                tail = trailer;
                size--;
                return true;

            }else {
                trailer = leader;
                while (leader.next != null) {
                    if (leader.data.equals(elem)) {
                            System.out.println("equals");
                            trailer.next = leader.next;
                            size--;
                            return true;
                    }
                    leader = leader.next;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This is new (to the interface) but should be straightforward to implement
     * @param element the element to search found
     * @return whether the element was found or not
     */
    @Override
    public boolean contains(T element) {
        Node current = head;
        while(current != null){
            if(current.data.equals(element)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return "GenericLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericLinkedListIterator();
    }

    //dedicated rotate netg
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

    class GenericLinkedListIterator implements Iterator<T>{
        int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (cursor== size)throw new NoSuchElementException();
            cursor++;
            return get(cursor);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }
    /* Linked list Node*/
    private class Node{
            T data;
            Node next;
            // Constructor to create a new node
            Node(T d) {
               data = d;
               next = null;
            }
        }
}

