package datastructuresandalgorithms.arrays;

public class RemoveEvenIntegersFromArray {

    public static int[] removeEvenInteger(int[] array) {
        int nextArraysize = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0)
                nextArraysize++;
        }
        int[] newArray = new int[nextArraysize];
        int indexs = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                newArray[indexs] = array[i];
                indexs++;
            }
        }
        return newArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 6, 7, 9, 10, 15};
        printArray(array);
        int[] newArray = removeEvenInteger(array);
        printArray(newArray);

    }
}
