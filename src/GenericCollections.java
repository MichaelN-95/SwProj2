public class GenericCollections {
    public static <T extends Comparable<T>> void sort(IList<T> listToSort)
    {
        for (int i = 0; i < listToSort.size(); i++) //number of passes{
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

    /**
     * Returns the maximum element of the given collection, according to the natural ordering
     of its elements.
     * @param list the collection whose maximum element is to be determined
     * @return the maximum element of the given collection, according to the natural ordering
    of its elements.
     * Throws:
     * NoSuchElementException - if the collection is empty.
     */
    public static <T extends Comparable<T>> T max(IList<T> list){
        return null;
    }
    /**
     *
     * @param list the list to be rotated.
     * @param distance the distance to rotate the list. There are no constraints on this
     * value; it may be zero, negative, or greater than list.size().
     * @param <T>
     */
    public static <T extends Comparable<T>> void rotate(IList<T> list, int distance){

        //while size of array is divisable by the distance, divide it then when done rotate by that number
        for (int i = 0; i < distance; i++) {

            // take out the first element
            T temp = list.get(0);
            for (int j = 0; j < list.size() - 1; j++) {

                // shift array elements towards left by 1 place
                list.set(j,list.get(j+1));
            }
            list.set(list.size()-1, temp);
        }
    }

    public static <T extends Comparable<T>> void rotate2(IList<T> list, int distance){
        list.rotate(distance);
    }
}
