import java.util.Locale;

//TODO create loop method to go through items and reduce reuse code
public class GenericLinkedList<T> implements IList<T> {
    Node head; // head of list
    Node tail; // tail of list
    int size; //size of list

    public void addToStart(T elem) {
        Node newNode = new Node(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public int size() {
    return size;
    }

    @Override
    public T remove(int index) {

//        System.out.println("index called");
        int counter ; // the current position on the list
        Node leader ; // the current node
        Node trailer ; // the previous node
        Node removed;
        try {
            if (index == 1) // The head of the list is deleted
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

    //TODO remove last element fix for int
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
    public T get(int i) {
        int counter;
        Node current;
        if (i ==1){
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

    public void printList() {
        //us this to "walk" or traverse the list
        Node current = head;
        while(current != null){
            System.out.print(current.data + ", ");
            current = current.next;
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

