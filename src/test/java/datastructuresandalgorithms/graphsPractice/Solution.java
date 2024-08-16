package datastructuresandalgorithms.graphsPractice;

import java.util.LinkedList;
import java.util.Queue;

class PairWeight{
    int node;
    int weight;
    public PairWeight(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
    public int getNode(){return node;}
    public int getWeight(){return weight;}

}
class Solution {

    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        LinkedList<PairWeight>[] linkedList = new LinkedList[n];
        int[] distance = new int[n];
        Queue<Integer> queue = new LinkedList();
        queue.offer(src);
        for(int i=0;i<n;i++){
            linkedList[i]=new LinkedList();
        }
        for(int i=0;i<n;i++){
            distance[i]=(int)(1e9);
        }
        for(int i=0;i<edges.length;i++){
            linkedList[edges[i][0]].add(new PairWeight(edges[i][1],1));
            linkedList[edges[i][1]].add(new PairWeight(edges[i][0],1));
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            int currentWeight = distance[node];
            for(PairWeight pairWeight:linkedList[node]){
                int adjNode = pairWeight.getNode();
                int adjWeight = pairWeight.getWeight();
                int totalDistance = currentWeight+adjWeight;
                if(totalDistance<distance[adjNode]){
                    distance[adjNode]=totalDistance;
                    queue.offer(adjNode);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(distance[i]==(int)(1e9))
                distance[i]=-1;
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        shortestPath(edges,9,10,0);
    }
}