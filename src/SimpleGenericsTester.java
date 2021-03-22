public class SimpleGenericsTester {
    public static void main(String[] args) throws Exception {

        //setting up values for generic arraylist & printing them
        GenericArrayList<Integer> aList = new GenericArrayList<>();
        aList.add(5); aList.add(3); aList.add(8);
        printArrayList("aList", aList);

        //setting up second array list
        GenericArrayList<String> aSecondList = new GenericArrayList<>();
        aSecondList.add("Tom"); aSecondList.add("Dick"); aSecondList.add("Harry");
        printArrayList("aSecondList", aSecondList);

        //setting up linked list with
        GenericLinkedList<String> aThirdList = new GenericLinkedList<>();
        aThirdList.addToStart("First");
        aThirdList.addToStart("second");
        aThirdList.addToStart("Third");

        //prooving generic usablity
        GenericLinkedList<Integer> anIntList = new GenericLinkedList<>();
        anIntList.add(1);
        anIntList.add(2);
        anIntList.addToStart(3);

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
        printLinkedList("anIntList", anIntList);
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