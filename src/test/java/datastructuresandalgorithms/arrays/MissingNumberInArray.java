package datastructuresandalgorithms.arrays;

public class MissingNumberInArray {
    public static int missingNumber(int[] array, int rangeValue) {
        int sum = 0;   // 1 operations
        int total = rangeValue * (rangeValue + 1) / 2;  //6 operations
        for (int i = 0; i < array.length; i++) //1+3(n+1)+3 = 1+3n+3+3=3n+7
            sum = array[i] + sum;  // 4 units
        return total - sum;  // 3 units
    } // 3n+21 == O(n)

    public static int missingNumberSecondApproach(int[] array, int range) {
        int missingNumber = range * (range + 1) / 2;  //6 units
        for (int i = 0; i < array.length; i++)               //3n+7;
            missingNumber = missingNumber - array[i];   //4 units
        return missingNumber;   // 2 units
    } // total is 3n+19 == O(n)

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 4, 8, 6};
        System.out.println(missingNumber(array, 8));
        System.out.println(missingNumberSecondApproach(array, 8));


    }
}
