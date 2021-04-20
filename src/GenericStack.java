import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericStack<T> implements IStack<T>{
    private GenericLinkedList<T> stack = null;
    public GenericStack() {
        stack= new GenericLinkedList<T>();
    }

    /**
     * Pushes an item onto the top of this stack
     *
     * @param element the element argument.
     */
    @Override
    public void push(T element) {
        stack.addToStart(element);
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    @Override
    public T pop() {

        return stack.remove(1);
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
        System.out.println(stack.toString());
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
        return stack.size==0;
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }
}
