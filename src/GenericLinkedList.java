public class GenericLinkedList<T> {
        Node head; // head of list
        Node tail; // tail of list
        int size; //size of list

        public void add(T val){
            if (size>0) {
                Node prev = tail;
                tail = new Node(val);
                prev.next = tail;
            }
            else {
                tail = new Node(val);
                head = tail;
            }
            size++;
        }
        public void addToStart(T val)
        {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void printList()
        {
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

    public T get(int i) {
            return null;
    }

    /* Linked list Node*/
        private class Node{
            T data;
            Node next;
            // Constructor to create a new node
            Node(T d) {
               this.data = d;
               this.next = null;
            }
        }
    }


