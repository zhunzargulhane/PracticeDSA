package datastructuresandalgorithms.graphsPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {
    int e;
    int v;
    LinkedList[] linkedList;

    public AdjacencyList(int nodes) {
        this.linkedList = new LinkedList[nodes];
        e = 0;
        v = nodes;
        for (int i = 0; i < v; i++) {
            linkedList[i] = new LinkedList();
        }
    }

    public void addEdges(int u, int v) {
        this.linkedList[u].add(v);
        this.linkedList[v].add(u);
        e++;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        System.out.println(v + " vertices and " + e + " edges");
        for (int i = 0; i < linkedList.length; i++) {
            sb.append(i + " -> ");
            for (int j = 0; j < linkedList[i].size(); j++) {
                sb.append(linkedList[i].get(j) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(4);
        adjacencyList.addEdges(0, 1);
        adjacencyList.addEdges(1, 2);
        adjacencyList.addEdges(2, 3);
        adjacencyList.addEdges(3, 0);
        System.out.println(adjacencyList);
    }

    public boolean isBipartite(int[][] graph) {
        int v= graph.length;
        int[] visited = new int[v];
        for(int i=0;i<v;i++)
            visited[i]=-1;
        for (int i = 0; i < v; i++) {
            if (visited[i] == -1) {
                if (bipartite(i,graph,visited,0) == false) return false;
            }
        }
        return true;
    }

    public boolean bipartite(int u,int[][] graph,int[] visited,int val){
        for(int v:graph[u]){
            if(visited[v]==-1){
                if(visited[u]==0)
                    visited[v]=1;
                else visited[v]=0;
                if(bipartite(v,graph,visited,visited[v])==false) return false;
            }else{
                if(visited[u]==visited[v])
                    return false;
            }
        }
        return true;
    }

}

