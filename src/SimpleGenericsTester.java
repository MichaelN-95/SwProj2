import java.util.ArrayList;
import java.util.Iterator;

public class SimpleGenericsTester {
    public static void main(String[] args) {
        ArrayList<String>tests = new ArrayList<>();
        arrayListTest();
       linkedListTest();
//        tests.remove(1);


    }

    private static void linkedListTest(){
        //setting up linked list with
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
    private static void arrayListTest(){
        //setting up values for generic arraylist & printing them
        GenericArrayList<Integer> aList = new GenericArrayList<>();
        GenericArrayList<String> aSList = new GenericArrayList<>();
        aList.add(1); aList.add(2); aList.add(33);
        aSList.add("Michael"); aSList.add("Fionn"); aSList.add("Kerri");
        printArrayList("aSList", aSList);

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
        printArrayList("aSList", aSList);
    }


    private static <T> void printArrayList(String listName, GenericArrayList<T> listToPrint) {
        System.out.println(listName + " contains:");
        for(int i = 0; i < listToPrint.size(); i++)
        {
            System.out.print(listToPrint.get(i) + " ");
        }
        System.out.println("\n");
    }
    private static <T> void printLinkedList(String listName, GenericLinkedList<T> listToPrint) throws Exception {
        System.out.println(listName + " contains:");
        listToPrint.printList();
        System.out.println();
    }

}