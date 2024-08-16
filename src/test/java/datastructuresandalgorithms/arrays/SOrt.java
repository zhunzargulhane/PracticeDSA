package datastructuresandalgorithms.arrays;

public class SOrt {
    public static void main(String[] args) {
        //sortedSquares(new int[]{-4,-1,0,3,10});
        String s ="My name is";
        String[] sArray = s.split("\\b");
        float f=321.24f;
        for(String s1:sArray)
            System.out.println(s1);
        //System.out.println("e");
    }


    public static int[] sortedSquares(int[] nums) {
        int j = nums.length-1;
        int i=0;
        while(j>=0){
            int val1 = nums[i]*nums[i];
            int val2=nums[j]*nums[j];
            if(val2>val1){
                nums[j--]=val2;
            }else{
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                nums[j--]=val1;
            }
        }
        return nums;
    }

    public static int[] sortArray(int[] arr) {
        for(int i=0;i<arr.length;i++){
            boolean flag=false;
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag) break;
        }
        return arr;
    }
}

