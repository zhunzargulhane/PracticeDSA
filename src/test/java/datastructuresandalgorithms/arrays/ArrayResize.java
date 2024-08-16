package datastructuresandalgorithms.arrays;

public class ArrayResize {
    public static int[] resizeArray(int[] array, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
     //  array=temp;
      //  return array;
        return temp;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
        System.out.println(array.length);
        array=resizeArray(array,array.length*2);
        System.out.println(array.length);
       /* ArraysDataStructures arraysDataStructures = new ArraysDataStructures();
        arraysDataStructures.printArray(resizeArray(array,array.length*2));*/
       // arraysDataStructures.printArray(resizeArray(array, array.length * 2));
    }
}
