import java.util.LinkedList;

public class SimpleGenericsTester {
    public static void main(String[] args) throws Exception {

        LinkedList<String> names = new LinkedList<String>();
        names.add("Brian");
        names.add("June");

        GenericArrayList<Integer> aList = new GenericArrayList<>();
        aList.add(5); aList.add(3); aList.add(8);
        printArrayList("aList", aList);


        GenericArrayList<String> aSecondList = new GenericArrayList<>();
        aSecondList.add("Tom"); aSecondList.add("Dick"); aSecondList.add("Harry");
        printArrayList("aSecondList", aSecondList);

        //Now - a similar test for the generic linked list class
        GenericLinkedList<String> aThirdList = new GenericLinkedList<>();
        aThirdList.addToStart("First");
        aThirdList.addToStart("Second");
        aThirdList.addToStart("Third");

        GenericLinkedList<String> aTestList = new GenericLinkedList<>();
        aTestList.add("First add");
        aTestList.add("Second add");
        aTestList.add("Third add");


//        aThirdList.addToStart("Me");
//        aThirdList.addToStart("Myself");
//        aThirdList.addToStart("I");

        System.out.println("aThirdList size:" + aThirdList.size);
        System.out.println("aTestList size:" + aTestList.size);
        printLinkedList("aThirdList", aThirdList);
        printLinkedList("aTestList", aTestList);
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
//        for(int i = 0; i < listToPrint.size(); i++)
//        {
//            System.out.print(listToPrint.get(i) + " ");
//        }
        System.out.println();
    }

}