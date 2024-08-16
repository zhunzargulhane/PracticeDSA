package datastructuresandalgorithms.arrays;

public class ArraysDataStructures {
    public void printArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++)
            System.out.print(array[i] + " ");
        System.out.print(array[array.length - 1]);
    }

    public void createArray() {
        int[] arrayName = new int[5];
        arrayName[0] = 1;
        arrayName[1] = 4;
        arrayName[2] = 10;
        arrayName[3] = 11;
        arrayName[4] = 15;
        arrayName[2] = 44;
        //try{
        // arrayName[7] = 24;
        /*catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }*/
        //  printArray(arrayName);
        int[] arr = {10, 20, 30};
        printArray(new int[]{10, 20, 30, 40});
    }

    public static void main(String[] args) {
        ArraysDataStructures arraysDataStructures = new ArraysDataStructures();
        arraysDataStructures.createArray();
    }
}
