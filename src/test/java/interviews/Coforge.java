package interviews;

public class Coforge {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int[] temp = new int[arr.length];
        temp[0]=arr[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            temp[i+1]=arr[i];
        }
        for(int num:temp)
            System.out.print(num+" ");
        //o/p = {5,1,2,3,4};
    }

}
