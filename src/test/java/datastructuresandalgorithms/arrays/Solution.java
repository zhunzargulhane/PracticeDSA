package datastructuresandalgorithms.arrays;

import java.util.*;

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Pair> list = new ArrayList();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }
        for (Pair pair : list) {
            int indexI = pair.getI();
            int indexJ = pair.getJ();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[indexI][j] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][indexJ] = 0;
            }
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        int[] ans = new int[matrix.length * matrix[0].length];
        int var = 0;
        ArrayList<Integer> list;
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (hashMap.containsKey(i + j)) {
                    list = hashMap.get(i + j);
                    list.add(matrix[i][j]);
                } else {
                    list = new ArrayList<>();
                    list.add(matrix[i][j]);
                    hashMap.put(i + j, list);
                }
            }
        }
        Set<Integer> set = hashMap.keySet();
        for (int index : set) {
            if (index % 2 != 0) {
                list = hashMap.get(index);
                Collections.reverse(list);
            }
        }
        Set<Map.Entry<Integer,ArrayList<Integer>>> entrySets = hashMap.entrySet();
        for(Map.Entry<Integer,ArrayList<Integer>> entry : entrySets){
            ArrayList<Integer> arrayList = entry.getValue();
            for(int num:arrayList) ans[var++]=num;
        }
        return ans;
    }
}
