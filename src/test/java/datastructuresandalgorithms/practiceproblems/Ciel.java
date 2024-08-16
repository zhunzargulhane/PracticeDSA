package datastructuresandalgorithms.practiceproblems;

public class Ciel {

    public int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }


    public int minEatingSpeed(int[] piles, int h) {
        long minimumCapacity = 1;
        long maximumCapacity = max(piles);
        while (minimumCapacity <= maximumCapacity) {
            long mid = minimumCapacity + (maximumCapacity - minimumCapacity) / 2;
            double requiredHours = 0;
            int index = piles.length - 1;
            while (index >= 0) {
                double val = piles[index];
                requiredHours += Math.ceil(val / minimumCapacity);
                index--;
            }
            if (requiredHours <= h)
                maximumCapacity = mid - 1;
            else
                minimumCapacity = mid + 1;
        }
        return (int) minimumCapacity;
    }

    public static void main(String[] args) {
        int[] piles = {1,10,3,10,2};
        Ciel ciel = new Ciel();
        System.out.println("sdf "+ciel.minDays(piles, 3,1));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long m1 = m;
        long k1 = k;
        if (bloomDay.length < m1 * k1)
            return -1;
        int minD = min(bloomDay);
        int maxD = max(bloomDay);
        while (minD <= maxD) {
            int midD = minD + (maxD - minD) / 2;
            int count = 0, bouquePrepared = 0;
            boolean[] flag = new boolean[bloomDay.length];
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= midD)
                    flag[i] = true;
            }
            for (int i = 0; i < flag.length; i++) {
                if (flag[i] == true) {
                    count++;
                    if (count >= k) {
                        bouquePrepared += count / k;
                        count = 0;
                    }
                } else {
                    bouquePrepared += count / k;
                    count = 0;
                }
            }
            if (bouquePrepared >= m)
                maxD = midD - 1;
            else minD = midD + 1;
        }
        return minD;
    }

    public boolean isPerfectSquare(int num) {
        long low=1;
        long high=num;
        while(low<=high){
            long mid=low+(high-low)/2;
            long val=mid*mid;
            if(val==num)
                return true;
            if(val<num)
                low=mid+1;
            else high=mid-1;
        }
        return false;
    }
    public int minEatingSpeed1(int[] piles, int h) {

        int minimumCapacity=1;
        int maximumCapacity=max(piles);
        while(minimumCapacity<=maximumCapacity){
            int mid=minimumCapacity+(maximumCapacity-minimumCapacity)/2;
            int eaten=piles[piles.length-1];
            int index=piles.length-1;
            int requiredHours=0;
            while(index>=0){
                if(eaten<=mid){
                    index--;
                }else {
                    eaten=eaten-mid;
                }
                requiredHours++;
            }
            if(requiredHours<=h)
                minimumCapacity=mid+1;
            else maximumCapacity=mid-1;
        }
        return minimumCapacity;
    }
}
