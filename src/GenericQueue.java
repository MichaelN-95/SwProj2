import java.util.Iterator;

public class GenericQueue<T> implements IQueue<T>, Iterable<T>{

    IList <T> queue ;

    public GenericQueue() {
        queue= new GenericArrayList<T>();
    }

    public GenericQueue(GenericLinkedList<T> list) {
        queue=list;
    }

    /**
     * Inserts the specified element into the queue
     *
     * @param element the element argument.
     */
    @Override
    public void enqueue(T element) {
        queue.add(element);
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     */
    @Override
    public T dequeue() {
        if (queue.isEmpty())
        {
            System.out.println("There are no elements to remove");
            return null;

        }else return this.queue.remove(0);
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     */
    @Override
    public T first() {
        return queue.get(0);
    }

    /**
     * Tests if this Queue is empty.
     *
     * @return {@code true} if and only if this queue contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

}