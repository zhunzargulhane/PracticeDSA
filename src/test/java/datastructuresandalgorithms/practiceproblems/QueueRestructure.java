package datastructuresandalgorithms.practiceproblems;

import java.util.*;

class PairStrings implements Comparable<PairStrings> {

    char character;
    int count;

    public PairStrings(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public char getCharacter() {
        return character;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(PairStrings o) {
        return o.getCount() - this.getCount();
    }
}

class HeightPair implements Comparable<HeightPair> {
    int num;
    int index;

    public HeightPair(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getNum() {
        return num;
    }


    @Override
    public int compareTo(HeightPair o) {
        int j = o.getNum() - this.getNum();
        if (j == 0)
            return this.getIndex() - o.getIndex();
        return o.getNum() - this.getNum();
    }
}

public class QueueRestructure {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] - o1[0] == 0)
                    return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        LinkedList<int[]> linkedList = new LinkedList<int[]>();
        for (int[] p : people)
            linkedList.add(p[1], p);
        return linkedList.toArray(new int[people.length][1]);
    }

    public Integer[] sortArray(Integer[] array) {
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i : array)
            linkedList.add(i);
        return linkedList.toArray(new Integer[linkedList.size()]);
    }

    public String[] ss(String[] ss) {
        LinkedList<String> linkedList = new LinkedList<String>();
        for (String s : ss)
            linkedList.add(s);
        return linkedList.toArray(new String[linkedList.size()]);
    }

    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (list.size() == 0 || list.get(0) != nums[i]) {
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == nums[i]) count++;
                }
                if (count > nums.length / 3) {
                    list.add(nums[i]);
                    if (list.size() == 2)
                        break;
                }
            }
        }
        return list;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        List<Integer> list = new ArrayList();
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap.containsKey(nums1[i]))
                hashMap.put(nums1[i], hashMap.get(nums1[i]) + 1);
            else
                hashMap.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i]) && hashMap.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                int value = hashMap.get(nums2[i]);
                hashMap.put(nums2[i], value - 1);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[count++] = list.get(i);
        }
        return ans;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int candidateElement = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                counter = 1;
                candidateElement = nums[i];
            } else if (nums[i] == candidateElement) counter++;
            else counter--;
        }
        return candidateElement;
    }


    public int maximumProduct(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = Math.abs(nums[i]);
        }
        Arrays.sort(temp);
        int max = temp[temp.length - 1];
        int smax = temp[temp.length - 2];
        Arrays.sort(nums);
        int tmax = nums[nums.length - 1];
        return max * smax * tmax;
    }


    public int maximumProduct1(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = Math.abs(nums[i]);
        }
        Arrays.sort(temp);
        int max = temp[temp.length - 1];
        int smax = temp[temp.length - 2];
        int tmax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max && nums[i] != smax && nums[i] > tmax)
                tmax = nums[i];
        }
        if (tmax == Integer.MIN_VALUE)
            tmax = smax;
        return max * smax * tmax;
    }

    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue(nums.length, Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0)
                nums[i] = pq.poll();
            else nums[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE)
                nums[i] = pq.poll();
        }
    }

    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int c = 0;
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0)
                linkedList.addLast(nums[i]);
            else linkedList.addFirst(nums[i]);
        }
        for (int i = 0; i < linkedList.size(); i++) {
            ans[c++] = linkedList.get(i);
        }
        return ans;
    }

    public String reorganizeString(String s) {
        StringBuffer sb = new StringBuffer();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        PriorityQueue<PairStrings> priorityQueue = new PriorityQueue<PairStrings>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i)))
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            else hashMap.put(s.charAt(i), 1);
        }
        Set<Map.Entry<Character, Integer>> set = hashMap.entrySet();
        for (Map.Entry<Character, Integer> mp : set) {
            priorityQueue.add(new PairStrings(mp.getKey(), mp.getValue()));
        }
        PairStrings hold = priorityQueue.poll();
        hold.setCount(hold.getCount() - 1);
        sb.append(hold.getCharacter());
        while (!priorityQueue.isEmpty()) {
            PairStrings temp = priorityQueue.poll();
            temp.setCount(temp.getCount() - 1);
            sb.append(temp.getCharacter());
            if (hold.getCount() != 0)
                priorityQueue.add(new PairStrings(hold.getCharacter(), hold.getCount()));
            hold = temp;
        }
        if (hold.getCount() > 0)
            return "";
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] array = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        QueueRestructure queueRestructure = new QueueRestructure();
        //  queueRestructure.reconstructQueue(array);
        Integer[] arr = {10, 20, 30, 40, 50};
        //   queueRestructure.sortArray(arr);
        int[] array1 = {-1000, -1000, 1000};
        String ss = "aab";
        System.out.println(queueRestructure.maximumProduct1(array1));
    }
}
