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
        return new GenericStackIterator<T>();
    }

    class GenericStackIterator<T> implements Iterator<T>{
        int cursor = 0;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
             return cursor < stack.size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (cursor== stack.size)throw new NoSuchElementException();
            cursor++;
            return (T) stack.get(cursor);
        }
    }

}
