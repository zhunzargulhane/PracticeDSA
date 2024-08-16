package datastructuresandalgorithms.graphs;

import java.util.*;

public class EventualSafeStates {
    LinkedList<Integer> list = new LinkedList<Integer>();
    List<List<Integer>> lists = new LinkedList<List<Integer>>();

    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashSet<Integer> terminalNodes = new HashSet<Integer>();
        ArrayList<Integer> safeNodes = new ArrayList<Integer>();
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0)
                terminalNodes.add(i);
        }
        for (int i = 0; i < graph.length; i++) {
            dfsPathsDAG(i, graph, visited);
            int count = 0;
            for (List<Integer> linkedList : lists) {
                int val = linkedList.get(linkedList.size() - 1);
                if (terminalNodes.contains(val))
                    count++;
            }
            if (lists.size() == count)
                safeNodes.add(i);
            lists = new LinkedList<List<Integer>>();
        }
        return safeNodes;
    }

    public void dfsPathsDAG(int v, int[][] graph, boolean[] visited) {
        list.add(v);
        visited[v] = true;
        int a = 0;
        for (int w : graph[v]) {
            a=w;
            if (!visited[w])
                dfsPathsDAG(w, graph, visited);
        }
        if (graph[v].length == 0 || visited[a]) {
            lists.add(list);
            list = new LinkedList<Integer>(list);
        }
        visited[v] = false;
        list.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        EventualSafeStates ev = new EventualSafeStates();
        System.out.println(ev.eventualSafeNodes(graph));
    }
}
