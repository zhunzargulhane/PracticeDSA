package datastructuresandalgorithms.searchingAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

class PairMutate implements Comparable<PairMutate> {
    int j;
    int diff;

    public PairMutate(int j, int diff) {
        this.j = j;
        this.diff = diff;
    }

    public int getJ() {
        return j;
    }

    public int getDiff() {
        return diff;
    }

    @Override
    public int compareTo(PairMutate o) {
        if (this.getDiff() - o.getDiff() == 0)
            return this.getJ() - o.getJ();
        return this.getDiff() - o.getDiff();
    }
}

public class SumMutatedArray {

    public int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public int findBestValue(int[] arr, int target) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int j = 0;
        int max = findMax(arr);
        int sum = 0;
        while (j <= max) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= j)
                    sum += j;
                else sum += arr[i];
            }
            if (!linkedList.isEmpty() && Math.abs(sum - target) == linkedList.getLast())
                return j - 1;
            else if (!linkedList.isEmpty() && Math.abs(sum - target) > linkedList.getLast())
                return j - 1;
            linkedList.add(Math.abs(sum - target));
            sum = 0;
            j++;
        }
        return j - 1;
    }

    public int mySqrt(int x) {
        long y = 0;
        while (y * y <= x) y++;
        return (int) (y - 1);
    }

    public int getVal() {
        double d = 10.45;
        Double double1 = d;
        return double1.intValue();
    }

    public int shipWithinDays(int[] weights, int days) {
        int minimumCapacity = findMax(weights);
        int maximumCapacity = 0;
        for (int weight : weights)
            maximumCapacity += weight;
        while (minimumCapacity <= maximumCapacity) {
            int load = 0;
            int requiredDays = 1;
            int mid = minimumCapacity + (maximumCapacity - minimumCapacity) / 2;
            for (int i = 0; i < weights.length; i++) {
                load += weights[i];
                if (load > mid) {
                    requiredDays++;
                    load = weights[i];
                }
            }
            if (requiredDays <= days)
                maximumCapacity = mid - 1;
            else minimumCapacity = mid + 1;
        }
        return minimumCapacity;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SumMutatedArray sumMutatedArray = new SumMutatedArray();
        int[] piles = {3, 6, 7, 11};
        System.out.println(sumMutatedArray.minEatingSpeed(piles, 8));
    }


    public int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
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

}
