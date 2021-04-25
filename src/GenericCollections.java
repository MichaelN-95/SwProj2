public class GenericCollections {
    public static <T extends Comparable<T>> void sort(IList<T> listToSort)
    {
        for (int i = 0; i < listToSort.size(); i++) //number of passes
        {
            //keeps track of positions per pass
            for (int j = 0; j < (listToSort.size() - 1 - i); j++)
            {
                //if left value is greater than right value
                if (listToSort.get(j).compareTo(listToSort.get(j+1)) > 0)
                {
                    //swap values
                    T temp = listToSort.get(j);
                    listToSort.set(j,listToSort.get(j+1));
                    listToSort.set(j+1, temp);
                }
            }
        }
    }

    public static void rotate(GenericArrayList<Person> myList, int i) {
    }

    public static String max(GenericArrayList<Person> myList) {
        return null;
    }
}
