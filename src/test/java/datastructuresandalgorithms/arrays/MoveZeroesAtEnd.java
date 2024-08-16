/*
Notes: need to move nonzeroes at the end and the relative order should be maintained.
Make sure to have j pointer focus on zero elements and i pointer focus on NONZERO.
        */

package datastructuresandalgorithms.arrays;

public class MoveZeroesAtEnd {

    public static int[] zeroesAtEnd(int[] array) {
       /* int endindexPointer = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 0) {
                int temp = array[i];
                array[i] = array[endindexPointer];
                array[endindexPointer] = temp;
                endindexPointer--;
            }
        }*/
        // 0 1 0 4 12 == 1 0 0 4 12== 1 4 0 0 12  =1 14 12 0 0
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[j] == 0) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if (array[j] != 0){
                j++;
            }
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        //int[] array = {1, 0, 0, 2, 3};
        int[] array = {0, 1, 0, 4, 12};
        printArray(array);
        printArray(zeroesAtEnd(array));


    }
}
