import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class SimpleGenericsTester {
    public static void main(String[] args) {
        arrayListTest(false);
//        linkedListTest(true);
        stackTest(true);
        queueTest(true);

    }

    private static void linkedListTest(boolean b){
        if(b){
            //setting an int list to test with
            GenericLinkedList<Integer> anIntList = new GenericLinkedList<>();
            anIntList.add(1);
            anIntList.add(2);
            anIntList.addToStart(3);
            Iterator<Integer> iteratorI = anIntList.iterator();

            //setting a string list to test with
            GenericLinkedList<String> aStringList = new GenericLinkedList<>();
            aStringList.add("First add");
            aStringList.add("Second add");
            aStringList.add("Third add");
            Iterator<String> iteratorS = aStringList.iterator();
            iterateString(iteratorS);

            aStringList.set(1, "Replaced");
            iteratorS = aStringList.iterator();
            iterateString(iteratorS);

        }
    }

    private static void arrayListTest(boolean b){
        //setting up values for generic arraylist & printing them
        if(b) {
            GenericArrayList<Integer> aList = new GenericArrayList<>();
            GenericArrayList<String> aSList = new GenericArrayList<>();
            Stack<Integer> stack = new Stack<>();
            aList.add(1);
            aList.add(2);
            aList.add(33);


            aSList.add("Michael");
            aSList.add("Fionn");
            aSList.add("Kerri");

            Iterator<Integer> iteratorI = aList.iterator();
            iterateInt(iteratorI);
            System.out.println(aList.set(1, 69));
            iteratorI = aList.iterator();
            iterateInt(iteratorI);
        }
    }

    private static void stackTest(boolean b){
       if (b) {
           GenericStack<Integer> numStack = new GenericStack<Integer>();
           numStack.push(2);numStack.push(6);numStack.push(9);numStack.push(69);
           GenericStack<String> strStack = new GenericStack<>();

           strStack.push("michael");strStack.push("fionn");strStack.push("kerri");
           System.out.println(numStack.pop());
           System.out.println(numStack.peek());

           /* setting up and iterating through items  */
           Iterator<Integer> iteratorI = numStack.iterator();
           Iterator<String> iteratorS = strStack.iterator();
           iterateInt(iteratorI);
           iterateString(iteratorS);
       }

    }

    private static void queueTest(boolean b){
        if (b){
            GenericQueue<Integer> intQ = new GenericQueue<Integer>();

            intQ.enqueue(1);intQ.enqueue(22);intQ.enqueue(69);

            System.out.println(intQ.first());
            Iterator<Integer> iteratorI = intQ.iterator();
            iterateInt(iteratorI);
        }
    }

    //Dedicated methods receive iterator and go through each element
    private static void iterateInt(Iterator<Integer> b){
        while(b.hasNext())
        {
            System.out.print(b.next() + " ");
        }
        System.out.println("\n");
    }

    private static void iterateString(Iterator<String> b){
        while(b.hasNext())
        {
            System.out.print(b.next() + " ");
        }
        System.out.println("\n");
    }

}