package datastructuresandalgorithms.graphsPractice;

import java.util.LinkedList;
import java.util.Stack;

/*
class WeightedPair{
    int node;
    int weight;
    public WeightedPair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
    public int getNode(){return node;}
    public int getWeight(){return weight;}
}
*/
public class Solutions {

/*    public int[] shortestPath(int N,int M, int[][] edges) {
        int[] visited = new int[N];
        int[] distance = new int[N];
        Stack<Integer> stack = new Stack();
        LinkedList<WeightedPair>[] linkedLists = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            linkedLists[i] = new LinkedList();
        }
        for(int i=0;i<edges.length;i++){
            linkedLists[edges[i][0]].add(new WeightedPair(edges[i][1],edges[i][2]));
        }
        distance[0] = 0;
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                dfsTOPO(i, visited, stack,linkedLists);
            }
        }
        while (!stack.isEmpty()) {
            int num = stack.pop();
            int currentWeight = distance[num];
            for (WeightedPair weightedPair : linkedLists[num]) {
                int adjNode = weightedPair.getNode();
                int adjNodeWeight = weightedPair.getWeight();
                int adjTotalWeight = currentWeight+adjNodeWeight;
                if(adjTotalWeight<distance[adjNode]){
                    distance[adjNode] = adjTotalWeight;
                }
            }
        }
        return distance;
    }

    public void dfsTOPO(int node, int[] visited, Stack<Integer> stack,LinkedList<WeightedPair>[] linkedLists) {
        visited[node] = 1;
        for (WeightedPair weightedPair : linkedLists[node]) {
            int adjNode = weightedPair.getNode();
            if (visited[adjNode] == 0)
                dfsTOPO(adjNode, visited, stack);
        }
        stack.push(node);
    }*/
}
