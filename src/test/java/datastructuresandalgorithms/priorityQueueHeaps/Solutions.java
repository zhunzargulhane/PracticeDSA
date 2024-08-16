package datastructuresandalgorithms.priorityQueueHeaps;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int sum;
    int diff;

    public Pair(int sum, int diff) {
        this.sum = sum;
        this.diff = diff;
    }

    public int getSum() {
        return sum;
    }

    public int getDiff() {
        return diff;
    }

    public int compareTo(Pair obj) {
        return this.getDiff() - obj.getDiff();
    }
}

class PqPair implements Comparable<PqPair> {
    String number;

    public PqPair(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public int compareTo(PqPair object) {
        int j=this.getNumber().length() - object.getNumber().length();
        if(j==0)
            return this.getNumber().compareTo(object.getNumber());
        return this.getNumber().length() - object.getNumber().length();
    }
}

class Solutions {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        PriorityQueue<Pair> pq = new PriorityQueue();
        int i = 0;
        while (i < nums.length) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                pq.add(new Pair(sum, Math.abs(target - sum)));
                if (sum < target)
                    j++;
                else k--;
            }
            i++;
        }
        return pq.peek().getSum();
    }

    public int threeSumClosestUpdated(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int min = Integer.MAX_VALUE;
        int finalSum = 0;
        if (i == 0 || nums[i] != nums[i - 1]) {
            while (i < nums.length) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int benchJ = Integer.MIN_VALUE;
                    int benchK = Integer.MAX_VALUE;
                    if (Math.abs(target - sum) < min) {
                        min = Math.abs(target - sum);
                        finalSum = sum;
                        benchJ = nums[j++];
                        benchK = nums[k--];
                    }
                    if (sum < target)
                        j++;
                    else k--;
                    while (j < nums.length && benchJ == nums[j])
                        j++;
                    while (k >= 0 && benchK == nums[k])
                        k--;
                }
                i++;
            }
        }
        return finalSum;
    }


    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<PqPair> pq = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            int j=0;
            if(!pq.isEmpty())
                j = nums[i].compareTo(pq.peek().getNumber());
            if (pq.size() < k) {
                pq.add(new PqPair(nums[i]));
            } else if (j>0) {
                pq.poll();
                pq.add(new PqPair(nums[i]));}
            // } else if (nums[i].length() == pq.peek().getNumber().length()) {
            //     String s1 = nums[i];
            //     String s2 = pq.peek().getNumber();
            //     int j = s1.compareTo(s2);
            //     if (j > 0) {
            //         pq.poll();
            //         pq.add(new PqPair(nums[i]));
            //     }
            // }
        }
        return pq.peek().getNumber();
    }

    public String kthLargestNumberUpdated(String[] nums, int k) {
        PriorityQueue<PqPair> pq = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            int j=0;
            if(!pq.isEmpty())
                j = nums[i].compareTo(pq.peek().getNumber());
            if (pq.size() < k) {
                pq.add(new PqPair(nums[i]));
            } else if (j>0) {
                pq.poll();
                pq.add(new PqPair(nums[i]));}
            // } else if (nums[i].length() == pq.peek().getNumber().length()) {
            //     String s1 = nums[i];
            //     String s2 = pq.peek().getNumber();
            //     int j = s1.compareTo(s2);
            //     if (j > 0) {
            //         pq.poll();
            //         pq.add(new PqPair(nums[i]));
            //     }
            // }
        }
        return pq.peek().getNumber();
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        String[] array = {"323","749","2","42"};
        Solutions solutions = new Solutions();
        System.out.println(solutions.kthLargestNumber(array, 1));
    }
}
