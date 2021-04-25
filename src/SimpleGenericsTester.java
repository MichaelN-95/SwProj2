import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

public class SimpleGenericsTester {
    public static void main(String[] args) {
//        arrayListTest(true);
        try {
//            linkedListTest(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            stackTest(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        queueTest(true);

    }

    private static void linkedListTest(boolean b) throws Exception {
        if(b){
            //setting an int list to test with
            GenericLinkedList<Integer> anIntList = new GenericLinkedList<>();
            anIntList.add(1);
            anIntList.add(2);
            anIntList.add(3);
            Iterator<Integer> iteratorI = anIntList.iterator();

            //setting a string list to test with
            GenericLinkedList<String> aStringList = new GenericLinkedList<>();
            aStringList.add("First add");
            aStringList.add("Second add");
            aStringList.add("Third add");
            Iterator<String> iteratorS = aStringList.iterator();
            iterateMe(aStringList);
            iterateMe(aStringList);
            aStringList.set(1, "Replaced");
//            iteratorS = aStringList.iterator();
//            iterateString(iteratorS);
//
//            for(Object strings: aStringList){
//                System.out.println(strings);
//            }

            iterateMe(aStringList);


        }
    }

    private static void arrayListTest(boolean b) throws Exception {
        //setting up values for generic arraylist & printing them
        if(b) {
            GenericArrayList<Integer> aList = new GenericArrayList<Integer>();
            GenericArrayList<String> aSList = new GenericArrayList<>();
            Stack<Integer> stack = new Stack<>();
            aList.add(1);
            aList.add(2);
            aList.add(33);


            aSList.add("Michael");
            aSList.add("Fionn");
            aSList.add("Kerri");

            Iterator<Integer> iteratorI = aList.iterator();
            iterateMe(aList);
            System.out.println(aList.set(1, 69));
            iteratorI = aList.iterator();
            iterateMe(aList);

            for (Integer ints:
            aList){
                System.out.println(ints);
            }

            iterateMe(aList);
        }
    }

    private static <T> void stackTest(boolean b) throws Exception {
       if (b) {
           GenericLinkedList<Integer> anIntList = new GenericLinkedList<>();
           GenericStack<Integer> test = new GenericStack<Integer>(anIntList);
           GenericStack<Integer> numStack = new GenericStack<>();
           numStack.push(2);numStack.push(6);numStack.push(9);numStack.push(69);
           iterateMe(numStack);
           GenericStack<String> strStack = new GenericStack<>();

           test.push(1);test.push(2); test.push(3);
           strStack.push("michael");strStack.push("Fionn");strStack.push("kerri");
           System.out.println("popped " +test.pop());
//           System.out.println("PEEKED " + test.peek());

           iterateMe(test);
           iterateMe(numStack);
           iterateMe(strStack);
       }

    }

    private static void queueTest(boolean b) throws Exception {
        if (b){
            GenericQueue<Integer> intQ = new GenericQueue<Integer>();

            //fix this
//            GenericStack<Integer> test = new GenericStack<Integer>(anIntList);
            intQ.enqueue(1);intQ.enqueue(22);intQ.enqueue(69);

            System.out.println(intQ.first());
            Iterator<Integer> iteratorI = intQ.iterator();
            iterateMe(intQ);
        }
    }

    //Stack dedicated iterate method
    private static <T> void iterateMe(IStack<T> stack) throws Exception {
        for (T details: stack){
            System.out.println(details);
        }
        System.out.println("\n");
    }

    //queue dedicated iterate method
    private static <T> void iterateMe(GenericQueue<T> queue) throws Exception {
        for (T details:
                queue){
            System.out.println(details);
        }
        System.out.println("\n");
    }

    //Lists dedicated iterate method
    private static <T> void iterateMe(IList<T> lists) throws Exception{
        for (T details:
                lists){
            System.out.println(details);
        }
        System.out.println("\n");
    }
}