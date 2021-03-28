public class GenericLinkedList<T> implements IList<T> {
    Node head; // head of list
    Node tail; // tail of list
    int size; //size of list

    public void addToStart(T elem)
    {
        Node newNode = new Node(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void printList() {
        //us this to "walk" or traverse the list
        Node current = head;
        while(current != null){
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    public int size() {
    return size;
    }

    @Override
    public T remove(int index) {
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
            System.out.println("Index number does not exist");
        }
        return null;
    }

    @Override
    public boolean remove(T elem) {

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T element) {
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

    public T get(int i) {
            return null;
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

