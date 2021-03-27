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

