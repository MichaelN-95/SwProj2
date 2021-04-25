public class GenericCollectionsTester1 {
    public static void main(String[] args) {
        GenericArrayList<Person> myList = new GenericArrayList<>();
        myList.add(new Person(20, "Hegarty", "Dermot"));
        myList.add(new Person(23,"Minchin", "Tim"));
        myList.add(new Person(19, "DiCamillo", "Kate"));
        myList.add(new Person(28, "Hardinge", "Frances"));
        myList.add(new Person(24, "Bryson", "Bill"));
        myList.add(new Person(26, "Ness", "Patrick"));
        printList("Original List:", myList);

        GenericLinkedList<Person> testList = new GenericLinkedList<>();
        testList.add(new Person(20, "Hegarty", "Dermot"));
        testList.add(new Person(23,"Minchin", "Tim"));
        testList.add(new Person(19, "DiCamillo", "Kate"));
        testList.add(new Person(28, "Hardinge", "Frances"));
        testList.add(new Person(24, "Bryson", "Bill"));
        testList.add(new Person(26, "Ness", "Patrick"));

        GenericCollections.sort(testList);
        //This method uses compareTo() to do its job
//        GenericCollections.sort(myList);
        printList("\nSorted List based on natural ordering (age):", testList);
//        GenericCollections.rotate2(myList, 2);
//        printList("\nList rotated by two:", myList);
//        System.out.println("\nThe oldest person is " + GenericCollections.max(myList));
    }
    public static void printList(String message, GenericArrayList<Person> listToPrint)
    {
        System.out.println(message);
        for (Object currPerson: listToPrint){
            System.out.println(currPerson.toString());
        }
    }
    public static void printList(String message, GenericLinkedList<Person> listToPrint)
    {
        System.out.println(message);
        for (Object currPerson: listToPrint){
            System.out.println(currPerson.toString());
        }
    }
}
