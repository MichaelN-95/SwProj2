public class SimpleGenericsTester {
    public static void main(String[] args) throws Exception {
        GenericArrayList<Integer> aList = new GenericArrayList<>();
        aList.add(5); aList.add(3); aList.add(8);
        printArrayList("aList", aList);
        GenericArrayList<String> aSecondList = new GenericArrayList<>();
        aSecondList.add("Tom"); aSecondList.add("Dick"); aSecondList.add("Harry");
        printArrayList("aSecondList", aSecondList);
        //Now - a similar test for the generic linked list class
        GenericLinkedList<String> aThirdList = new GenericLinkedList<>();
        aThirdList.add("Me"); aThirdList.add("Myself"); aThirdList.add("I");
        printLinkedList("aThirdList", aThirdList);
    }
    private static <T> void printArrayList(String listName, GenericArrayList<T>
            listToPrint) {
        System.out.println(listName + " contains:");
        for(int i = 0; i < listToPrint.size(); i++)
        {
            System.out.print(listToPrint.get(i) + " ");
        }
        System.out.println();
    }
    private static <T> void printLinkedList(String listName, GenericLinkedList<T>
            listToPrint) throws Exception {
        System.out.println(listName + " contains:");
        for(int i = 0; i < listToPrint.size(); i++)
        {
            System.out.print(listToPrint.get(i) + " ");
        }
        System.out.println();
    }

}