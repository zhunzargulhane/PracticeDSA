package datastructuresandalgorithms.priorityQueueHeaps;

import java.util.*;

public class DesignTwitter {

    LinkedList<Integer> list = new LinkedList();
    HashMap<Integer, LinkedList<Integer>> hm = new HashMap();

    public DesignTwitter() {

    }

    public void postTweet(int userId, int tweetId) {
        list = new LinkedList();
        list.add(tweetId);
        hm.put(userId, list);
    }

    public List<Integer> getNewsFeed(int userId) {
        //   LinkedList list=hm.get(userId);
        LinkedList list1 = hm.get(userId);
        Collections.reverse(list1);
        return list1;
    }

    public void follow(int followerId, int followeeId) {
        LinkedList list = hm.get(followerId);
        list.add(hm.get(followeeId));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<IndexPair> priorityQueue = new PriorityQueue<IndexPair>();
        boolean[] array = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(new IndexPair(nums[i], i));
        }
        int j = k;
        while (j > 0) {
            IndexPair pair = priorityQueue.poll();
            array[pair.getValue()] = true;
            j--;
        }
        int count = 0;
        int[] ans = new int[k];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == true)
                ans[count++] = nums[i];
        }
        return ans;
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i)))
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            else
                hashMap.put(s.charAt(i), 1);
        }
        PriorityQueue<CharPair> priorityQueue = new PriorityQueue<CharPair>();
        Set<Map.Entry<Character, Integer>> set = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : set) {
            priorityQueue.add(new CharPair(entry.getKey(), entry.getValue()));
        }
        StringBuilder s1 = new StringBuilder();
        CharPair block = priorityQueue.poll();
        s1.append(block.getKey());
        block = new CharPair(block.getKey(), block.getValue() - 1);
        while (!priorityQueue.isEmpty()) {
            CharPair temp = priorityQueue.poll();
            s1.append(temp.getKey());
            temp=new CharPair(temp.getKey(), temp.getValue() - 1);
            if(block.getValue()>0)
                priorityQueue.add(new CharPair(block.getKey(), block.getValue()));
            block=temp;
        }
        if (block.getValue() > 0)
            return "";
        return s1.toString();
    }


    public int findKthPositive(int[] arr, int k) {
        int count=1;
        LinkedList<Integer> list = new LinkedList();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=count){
                for(int j=count;j<arr[i];j++){
                    list.add(j);
                    if(list.size()==k)
                        return list.getLast();
                }
                count=arr[i];
            }
            count++;
        }
        return arr[arr.length-1]+k;
    }

    public void unfollow(int followerId, int followeeId) {
        LinkedList list = hm.get(followerId);
        //list.add()


        list.remove(hm.get(followeeId));
    }

    public static void main(String[] args) {
        DesignTwitter designTwitter = new DesignTwitter();
        int[] nums = {5,6,7,8,9};
        //   designTwitter.maxSubsequence(nums, 2);
        System.out.println(designTwitter.findKthPositive(nums,9));

    }
}
