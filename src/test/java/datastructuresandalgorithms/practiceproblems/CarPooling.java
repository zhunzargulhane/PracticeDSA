package datastructuresandalgorithms.practiceproblems;

import java.util.*;

class Pair implements Comparable<Pair> {
    int location;
    int pax;

    public Pair(int location, int pax) {
        this.location = location;
        this.pax = pax;
    }

    public int getLocation() {
        return location;
    }

    public int getPax() {
        return pax;
    }

    public int compareTo(Pair obj) {
        int j = this.location - obj.location;
        if (j == 0)
            return obj.getPax() - this.getPax();
        return this.location - obj.location;
    }
}

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int cap = capacity;
        PriorityQueue<Pair> pq = new PriorityQueue();
        for (int i = 0; i < trips.length; i++) {
            pq.add(new Pair(trips[i][1], -1 * trips[i][0]));
            pq.add(new Pair(trips[i][2], trips[i][0]));
        }
        while (!pq.isEmpty()) {
            cap += pq.poll().getPax();
            if (cap < 0)
                return false;
        }
        return true;
    }

    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        for (int i = 0; i < t1.length; i++) {
            if (s1[i] != t1[i])
                return t1[i];
        }
        return 'a';
    }

    public char findTheDifference1(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        char sum1 = 0;
        char sum2 = 0;
        for (int i = 0; i < s1.length; i++) {
            sum1 += s1[i];
        }
        for (int i = 0; i < t1.length; i++) {
            sum2 += t1[i];
        }
        return (char) (sum2 - sum1);
    }

    public String customSortString(String order, String s) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i)))
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            else hashMap.put(s.charAt(i), 1);
        }
        for (int i = 0; i < order.length(); i++) {
            if (hashMap.containsKey(order.charAt(i))) {
                int count = hashMap.get(order.charAt(i));
                while (count != 0) {
                    sb.append(order.charAt(i));
                    count--;
                }
                hashMap.remove(order.charAt(i));
            }
        }
        Set<Map.Entry<Character, Integer>> set = hashMap.entrySet();
        for (Map.Entry<Character, Integer> mp : set) {
            int count = mp.getValue();
            while (count != 0) {
                sb.append(mp.getKey());
                count--;
            }
        }
        return sb.toString();
    }

    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> hashSet = new HashSet();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int finalSum = 0;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            boolean flag = hashSet.add(nums[i]);
            if (flag == false)
                ans[0] = nums[i];
            else sum += nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        for (int i = 1; i <= max; i++)
            finalSum += i;
        ans[1] = finalSum - sum;
        return ans;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> pq = new LinkedList();
        int[] ans = new int[deck.length];
        for (int i = 0; i < deck.length; i++)
            pq.add(i);
        int i = 0;
        while (!pq.isEmpty() && pq.peek() != null) {
            ans[pq.poll()] = deck[i++];
            pq.add(pq.poll());
        }
        return ans;
    }

    public String reverseWords(String s) {
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<String> linkedList = new LinkedList();
        while (stringTokenizer.hasMoreElements()) {
            linkedList.add(stringTokenizer.nextElement().toString().trim());
        }
        while (!linkedList.isEmpty()) {
            stringBuilder.append(linkedList.getLast() + " ");
            linkedList.removeLast();
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public String reverseWords1(String s) {
        String[] array = s.trim().replaceAll(" +"," ").split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
                sb.append(array[i]+" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }


    public int longestConsecutive(int[] nums) {
        int c=0;
        int[] ans = new int[nums.length];
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int num:nums)
              treeSet.add(num);
        while(!treeSet.isEmpty())
            ans[c++]=treeSet.pollFirst();
        int max=0;
        int count=0;
        if(nums.length==0) return 0;
        for(int i=1;i<ans.length;i++){
            if(ans[i]-ans[i-1]==1)
                 count++;
            else{
                max=Math.max(max,count);
                count=0;
            }
        }
        return Math.max(max,count)+1;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 5, 7}};
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        CarPooling carPooling = new CarPooling();
        int[] arr = {1, 1};
        String s = "a good   example";
        int[] nums={1,2,0,1};
        System.out.println(carPooling.longestConsecutive(nums));
       // System.out.println(carPooling.reverseWords1(s));
        //System.out.println(carPooling.carPooling(trips,3));
        // System.out.println(carPooling.findTheDifference1("abcd","abcde"));
        // System.out.println(carPooling.customSortString("hucw", "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh"));
        //  carPooling.findErrorNums(arr);
    }
}
