package datastructuresandalgorithms.matrix;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class SearchInSortedRowColumnMatrix {

    public boolean search(int[][] matrix, int n, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            if (target > matrix[i][j])
                i++;
            else
                j--;
        }
        return false;
    }

    public void spiralMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int k = 0, l = 0;
        while (k < r && l < c) {
            for (int i = l; i < c; i++) {
                System.out.print(matrix[k][i]);
            }
            k++;
            System.out.println();
            for (int i = k; i < r; i++) {
                System.out.print(matrix[i][c - 1]);
            }
            c--;
            System.out.println();
            if (k < r) {
                for (int i = c - 1; i >= l; i--) {
                    System.out.print(matrix[r - 1][i]);
                }
                r--;
            }
            System.out.println();
            if (l < c) {
                for (int i = r - 1; i >= k; i--) {
                    System.out.print(matrix[i][l]);
                }
                l++;
            }
        }
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int colsize = colsum.length;
        int[] upperList = new int[colsize];
        int[] lowerList = new int[colsize];
        List<Integer> upperList1 = new ArrayList<Integer>();
        List<Integer> lowerList1 = new ArrayList<Integer>();
        List finalList = new ArrayList();
        int sum = 0;
        for (int i = 0; i < colsize; i++) {
            if (colsum[i] > 1) {
                sum = sum + 1;
                if (sum <= upper)
                    upperList[i] = 1;
            }
        }
        for (int i = 0; i < colsize; i++) {
            if (colsum[i] == 1) {
                sum = sum + 1;
                if (sum <= upper)
                    upperList[i] = 1;
            }
        }
        sum = 0;
        for (int i = 0; i < colsize; i++) {
            int value = Math.abs(colsum[i] - upperList[i]);
            if (value == 0 || value == 1) {
                lowerList[i] = value;
                sum = sum + value;
            }
        }

        for (int i = 0; i < upperList.length; i++) {
            upperList1.add(upperList[i]);
        }
        for (int i = 0; i < lowerList.length; i++) {
            lowerList1.add(lowerList[i]);
        }

        finalList.add(Arrays.asList(lower));
        finalList.add(Arrays.asList(upper));
        return finalList;
    }


    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if (grid[0][0] != 0 || grid[r - 1][c - 1] != 0)
            return -1;
        int i = 0, j = 0, count = 0;
        while (i < r && j < c) {
            if (j == c - 1) {
                count++;
                i++;
            } else if (i == r - 1) {
                count++;
                i++;
            } else if (grid[i][j + 1] == 0 && grid[i + 1][j + 1] == 0) {
                count++;
                i++;
                j++;
            } else if (grid[i][j + 1] == 0 && grid[i + 1][j + 1] == 1) {
                count++;
                j++;
            } else if (grid[i][j + 1] == 1 && grid[i + 1][j + 1] == 0) {
                count++;
                i++;
                j++;
            } else if (grid[i][j + 1] == 1 && grid[i + 1][j + 1] == 1 && grid[i + 1][j] == 1) {
                count++;
                return count;
            } else if (grid[i][j + 1] == 1 && grid[i + 1][j + 1] == 1 && grid[i + 1][j] == 0) {
                count++;
                i++;
            }
        }
        return count;
    }

    public int countNegatives1(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int l = 0, k = 0, sum = 0;
        ArrayList<Integer> list = new ArrayList();
        while (k < r) {
            for (int i = l; i < c; i++) {
                if (matrix[k][i] < 0) {
                    list.add(i);
                    break;
                }
            }
            k++;
        }
        for (int i = 0; i < list.size(); i++) {
            sum += (c - list.get(i));
        }
        return sum;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] array = new int[r][c];
        if ((m * n) != (r * c))
            return mat;
        else {
            int k = 0, l = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    array[k][l] = mat[i][j];
                    l++;
                }
                if (l > c) {
                    l = 0;
                    k++;
                }
            }
        }
        return array;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (i == r - 1)
                break;
            for (int j = 0; j < c; j++) {
                if (j == c - 1)
                    break;
                System.out.println(matrix[i][j] + " " + matrix[i + 1][j + 1]);
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = r;
        int j = 0;
        ArrayList<Integer> list = new ArrayList();
        for (int i = r - 1; i >= 0; i--) {
            list.add(matrix[i][j]);
            if (i == 0) {
                i = r;
                j++;
                if (j == c)
                    break;
            }
        }
        int k = 0, l = 0;
        for (int i = 0; i < list.size(); i++) {
            matrix[k][l] = list.get(i);
            l++;
            if (l >= c) {
                l = 0;
                k++;
            }
        }
    }

    public void rotate1(int[][] matrix) {
        int r = matrix.length;
        int c = r;
        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < r; i++) {
            int start = 0, end = c - 1;
            while (start < end) {
                int temp = matrix[i][end];
                matrix[i][end] = matrix[i][start];
                matrix[i][start] = temp;
                start++;
                end--;
            }
        }

    }


    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstColumn = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (firstRow) {
            for (int i = 0; i < c; i++)
                matrix[0][i] = 0;
        }
        if (firstColumn) {
            for (int i = 0; i < r; i++)
                matrix[i][0] = 0;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int count = 0, result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                if (j != 0) {
                    if (matrix[i][j] < matrix[i][j - 1]) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[i][j - 1];
                        matrix[i][j - 1] = temp;
                        //count--;
                    }
                } else if (j == 0 && i != 0) {
                    if (matrix[i][j] < matrix[i - 1][r - 1]) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[i - 1][r - 1];
                        matrix[i - 1][r - 1] = temp;
                        //count--;
                    }
                } else count++;

                if (count == k) {
                    result = matrix[i][j];
                    break;
                }
            }
        }
        return result;
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        List<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        int[] array = new int[matrix.length * matrix[0].length];
        int i, j = 0;
        int count = 0, key = 0;
        if (matrix.length == 1) {
            return matrix[0];
        }
        if (matrix[0].length == 1) {
            for (int a = 0; a < matrix.length; a++) {
                for (int b = 0; b < matrix[0].length; b++) {
                    array[count++] = matrix[a][b];
                }
            }
            return array;
        }
        for (i = 0; i < matrix.length; i++) {
            int k = i;
            while (i >= 0 && j <= matrix[0].length - 1) {
                list.add(matrix[i][j]);
                i--;
                j++;
            }
            if (i < 0 || j >= matrix[0].length) {
                j = 0;
                i = k;
            }
            if (key % 2 != 0) {
                Collections.reverse(list);
                lists.add(list);
            } else
                lists.add(list);
            key++;
            list = new ArrayList<Integer>();
        }
        i = matrix.length - 1;
        for (j = 1; j < matrix[0].length; j++) {
            int k = j;
            while (j <= matrix[0].length - 1) {
                list.add(matrix[i][j]);
                i--;
                j++;
            }
            if (i < 0 || j >= matrix[0].length) {
                j = k;
                i = matrix[0].length - 1;
            }
            if (key % 2 != 0) {
                Collections.reverse(list);
                lists.add(list);
            } else
                lists.add(list);
            key++;
            list = new ArrayList<Integer>();
        }
        for (ArrayList<Integer> list1 : lists) {
            for (int data : list1)
                array[count++] = data;
        }
        return array;
    }

    public static void main(String[] args) {
        SearchInSortedRowColumnMatrix search = new SearchInSortedRowColumnMatrix();
        /*int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 51}};
        System.out.println(search.search(matrix, matrix.length, 82));*/
      /*  int[] colsum = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
        System.out.println(search.reconstructMatrix(5, 5, colsum));*/
       /* int[][] matrix = {{0, 1, 1, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0}};
        System.out.println(search.shortestPathBinaryMatrix(matrix));*/
       /* int[][] mat = {{1, 2}, {3, 4}};
        search.matrixReshape(mat, 1, 4);*/
        int[][] matrix = {{2, 5}, {8, 4}, {0, -1}};
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list3.add(7);
        list3.add(8);
        list3.add(9);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);


        // System.out.println(search.kthSmallest(matrix, 2));
        search.findDiagonalOrder(lists);
    }


    public int[] findDiagonalOrder(List<List<Integer>> lists) {
        int count = 0;
        ArrayList<Integer> list;
        LinkedHashMap<Integer, ArrayList<Integer>> hashMap = new LinkedHashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                count++;
                if (hashMap.containsKey(i + j)) {
                    list = hashMap.get(i + j);
                    list.add(lists.get(i).get(j));
                } else {
                    list = new ArrayList<Integer>();
                    list.add(lists.get(i).get(j));
                    hashMap.put(i + j, list);
                }
            }
        }
        int[] array = new int[count];
        int key = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> set : hashMap.entrySet()){
            Collections.reverse(set.getValue());
            for(int value:set.getValue()){
                array[key++]=value;
            }
        }
        return array;
    }
}
