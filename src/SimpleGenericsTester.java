import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class SimpleGenericsTester {
    public static void main(String[] args) {
        ArrayList<String>tests = new ArrayList<>();
        arrayListTest(false);
       linkedListTest(false);
       stackTest(true);
//        tests.remove(1);


    }

    private static void linkedListTest(boolean b){

        if(b){//setting up linked list with
/**        GenericLinkedList<String> aThirdList = new GenericLinkedList<>();
 //        aThirdList.addToStart("First");
 //        aThirdList.addToStart("second");
 aThirdList.addToStart("Third"); */

        //proving generic usability for linked list
        /**  GenericLinkedList<Integer> anIntList = new GenericLinkedList<>();
         anIntList.add(1);
         anIntList.add(2);
         anIntList.addToStart(3);*/

        GenericLinkedList<String> aTestList = new GenericLinkedList<>();
         aTestList.add("First add");
         aTestList.add("Second add");
         aTestList.add("Third add");

        for (String string : (Iterable<String>) aTestList) {
            System.out.println();
            System.out.print(string + " ");
        }

/** testing stuff for linked lists */
//        aThirdList.addToStart("Me");
//        aThirdList.addToStart("Myself");
//        aThirdList.addToStart("I");

//        System.out.println("aThirdList size:" + aThirdList.size);
//        System.out.println("aTestList size:" + aTestList.size);
//        printLinkedList("aThirdList", aThirdList);
//        printLinkedList("aTestList", aTestList);
//        printLinkedList("anIntList", anIntList);

        //testing remove via index
//        aTestList.remove(5);
//        printLinkedList("atestlist", aTestList);
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

            //And here is an example of normal usage of iterators to traverse a collection
            for (Integer integer : (Iterable<Integer>) aList) {
                System.out.println();
                System.out.print(integer + " ");
            }

            //setting up second array list
//        GenericArrayList<String> arrayList = new GenericArrayList<>();
//        arrayList.add("Tom"); arrayList.add("Dick"); arrayList.add("Harry");
//        printArrayList("arrayList", arrayList);
//        System.out.println(aSList.contains("Kerri"));
            System.out.println("remove" + aSList.remove("Michael"));
//        System.out.println(aSList.contains("Fionn"));
        }
    }

    private static void stackTest(boolean b){
//       if (b) {
           GenericStack<Integer> numStack = new GenericStack<Integer>();
           numStack.push(2);numStack.push(6);numStack.push(9);numStack.push(69);
           GenericStack<String> strStack = new GenericStack<>();

           strStack.push("michael");strStack.push("fionn");strStack.push("kerri");
//           System.out.println(numStack.pop());
           System.out.println(numStack.peek());


//       }
        Iterator<Integer> iteratorI = numStack.iterator();
        Iterator<String> iteratorS = strStack.iterator();
        iterateInt(iteratorI);
        iterateString(iteratorS);


        //TODO fix this
        /* for (Integer integer : (Iterable<Integer>) numStack.iterator()) {
            System.out.println();
            System.out.print(integer + " ");
        }*/
    }
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