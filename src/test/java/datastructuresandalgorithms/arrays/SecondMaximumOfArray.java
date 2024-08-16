package datastructuresandalgorithms.arrays;

public class SecondMaximumOfArray {

    public static int secondMaximum(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            } else if (array[i] > secondMax && array[i] != max) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    public static int thirdMaximum(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = array[i];
            } else if (array[i] > secondMax && array[i] != max) {
                thirdMax = secondMax;
                secondMax = array[i];
            } else if (array[i] > thirdMax && array[i] != secondMax && array[i] != max) {
                thirdMax = array[i];
            }
        }
        return thirdMax;
    }


    public static void main(String[] args) {
        int[] array = {5, 13, 24, 2, 86, 25, 86};
        System.out.println(secondMaximum(array));
        System.out.println(thirdMaximum(array));
    }
}
