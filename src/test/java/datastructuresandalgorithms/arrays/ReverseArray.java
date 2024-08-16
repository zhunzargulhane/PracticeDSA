package datastructuresandalgorithms.arrays;

public class ReverseArray {
    public static int[] reverseArray(int[] originalArray) {
        int[] reversedArray = new int[originalArray.length];
        int index = 0;
        for (int i = originalArray.length - 1; i >= 0; i--) {
            reversedArray[index] = originalArray[i];
            index++;
        }
        return reversedArray;
    }

    public static int[] reverseArray(int[] array, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return array;
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] originalArray = {5, 8, 9, 10};
        // printArray(originalArray);
        printArray(reverseArray(originalArray, 0, originalArray.length - 1));

    }
}
