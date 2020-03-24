package NickZelada;

/*  File: ArrayRecursion.java
 *
 *  Programmer: Nick Zelada
 *
 */

import java.util.Random;

public class ArrayRecursion {
    // instance var's

    private int[] list;		// array of ints
    private int count = 0;	// number of elements used

    /**
     * Create an ArrayRecursion object. Create an array with between 10 and 15
     * elements, and fill it with random positive 2-digit ints
     */
    public ArrayRecursion() {
        Random r = new Random();
        count = r.nextInt(6) + 10;
        list = new int[count];

        for (int i = 0; i < count; i++) {
            list[i] = r.nextInt(90) + 10;
        }
    }

    /*
    * Return the list as a string
    * @return a string containing all ints stored in list
     */
    public String toString() {
        String out = "";
        for (int i = 0; i < count; i++) {
            out += list[i] + "  ";
        }
        return out + "\n";
    }

    /**
     * Reverse the order of the values stored in the list. (called by client to
     * reverse list using first algorithm)
     */
    public void reverse() {
        reverseRecurse(list, 0, count);
    }

    /**
     * recursive "helper" method to reverse the values stored in the list
     * (called by public method reverse1())
     *
     * @param list the array of int
     * @param start the first element of the array
     * @param count the size of the array
     */
    private void reverseRecurse(int[] list, int start, int count) {

        if (start < count - 1) {

            int tmp = list[start];

            list[start] = list[count - 1];

            list[count - 1] = tmp;

            reverseRecurse(list, ++start, --count);

        }
    }

    /*
    * Returns the index of the largest value in the array.
    * @return the index of the largest value in the array
     */
    public int getIndexOfLargest() {
        return recursiveGetIndexOfLargest(list, count);
    }

    /**
     * recursive "helper" method to return index of largest value (called by
     * public method getLargest())
     *
     * @param list an array of int
     * @param count the size of the array
     * @return the largest index value of the array
     */
    private int recursiveGetIndexOfLargest(int[] list, int count) {
        int i;

        int curr = count - 1;

        if (curr == 0) {
            return curr;
        } else {

            i = recursiveGetIndexOfLargest(list, curr);

            return list[curr] > list[i] ? curr : i;

        }
    }

    /*
    * Sort the array in ascending order using the selection sort
     */
    public void sort() {
        recursiveSort(list, count);
    }

    /**
     * recursive "helper" method to sort the array (called by public method
     * sort())
     *
     * @param list the numbers of the array
     * @param count the size of the array
     */
    private void recursiveSort(int[] list, int count) {

        int largest = recursiveGetIndexOfLargest(list, count);

        if (count > 1) {

            int temp = list[count - 1];

            list[count - 1] = list[largest];

            list[largest] = temp;
            recursiveSort(list, count - 1);
        }

    }

    public static void main(String[] args) {
        ArrayRecursion list = new ArrayRecursion();

        System.out.println("\nOriginal:  " + list);
        list.reverse();
        System.out.println("\nReversed:    " + list);
        System.out.println("Largest value is at index: "
                + list.getIndexOfLargest());
        list.sort();
        System.out.println("\nSorted:    " + list);
    }
}
