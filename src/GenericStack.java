import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericStack<T> implements IStack<T>, Iterable<T>{
    IList <T>stack;
    public GenericStack() {
        stack= new GenericArrayList<>();
    }

    public GenericStack(GenericLinkedList<T> linkedList) {
        stack = linkedList;
    }

    /**
     * Pushes an item onto the top of this stack
     *
     * @param element the element argument.
     */
    @Override
    public void push(T element) {
        stack.add(0,element);
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    @Override
    public T pop() {

        return this.stack.remove(0);
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack
     */
    @Override
    public T peek() {
        if (stack.size() == 0){

            throw new NoSuchElementException();
        }
        return stack.get(1);
    }

    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        return stack.size()==0;
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }
}
