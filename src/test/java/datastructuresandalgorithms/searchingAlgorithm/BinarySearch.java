package datastructuresandalgorithms.searchingAlgorithm;

public class BinarySearch {
    public int search(int[] num,int x){
        int low=0;
        int high=num.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(num[mid]==x) return mid;
            if(x<num[mid])
                high=mid-1;
            else low=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] num={124,45,65,78};
        System.out.println(binarySearch.search(num,651));
    }
}
