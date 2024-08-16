package datastructuresandalgorithms.graphs;


import java.util.LinkedList;
import java.util.Queue;

class PairParent{

    int i;
    int parent;
    public PairParent(int i,int parent){
        this.i=i;
        this.parent=parent;
    }

    public int getI() {
        return i;
    }
    public int getParent() {
        return parent;
    }
}
public class FindRedundantConnection {

    static LinkedList<Integer>[] linkedLists;
    int[] ans = new int[2];
    int[] num = new int[100];
    int i = 0;


    public static void main(String[] args) {
        FindRedundantConnection rd = new FindRedundantConnection();
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        //int[][] edges ={{1,2},{2,3},{1,5},{3,4},{1,4}};
        linkedLists = new LinkedList[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            linkedLists[i] = new LinkedList();
        }
        for (int i = 0; i < edges.length; i++) {
            rd.addEdges(edges[i][0], edges[i][1], linkedLists);
        }
        System.out.println(rd);
        rd.findRedundantConnection(edges);
    }

    public void addEdges(int u, int v, LinkedList[] list) {
        list[u].add(v);
        list[v].add(u);
    }


    public int[] findRedundantConnection(int[][] edges) {
        boolean[] visited = new boolean[edges.length + 1];
        dfsCycle(1, -1, visited, edges);
        for (int i1 = edges.length-1; i1 >= 0;
             i1--) {
                if(edges[i1][0]==num[0] || edges[i1][1]==num[0]){
                    ans[0] = edges[i1][0];
                    ans[1] = edges[i1][1];
                    break;
                }
        }
        return ans;
    }

    public void dfsCycle(int v, int parent, boolean[] visited, int[][] edges) {
        visited[v] = true;
        for (int w : linkedLists[v]) {
            if (visited[w] && w != parent) {
                num[i++] = v;
            }
            if (!visited[w] ) {
                dfsCycle(w, v, visited, edges);
            }
        }
    }



    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < linkedLists.length; i++) {
            sb.append(i + " : " + linkedLists[i] + "\n");
        }
        return sb.toString();
    }
}
