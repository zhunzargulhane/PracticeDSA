package datastructuresandalgorithms.graphsPractice;

import java.util.*;

class Pair implements Comparable<Pair>{
    int node;
    int weight;
    public Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
    public int getNode(){return node;}
    public int getWeight(){return weight;}
    public int compareTo(Pair pair){
        int j=this.getWeight()-pair.getWeight();
        if(j==0)
            return this.getNode()-pair.getNode();
        return j;
    }
}
class sol {
    public static List<Integer> shortestPath(int n, int m, int edges[][]){
        LinkedList<Pair>[] linkedList = new LinkedList[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue();
        int[] distance = new int[n+1];
        int[] parent = new int[n+1];
        int k=n;
        List<Integer> list = new ArrayList();
        for(int i=1;i<=n;i++) parent[i]=i;
        for(int i=0;i<=n;i++)
            linkedList[i] = new LinkedList();
        for(int i=1;i<=n;i++) distance[i]=Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++){
            linkedList[edges[i][0]].add(new Pair(edges[i][1],edges[i][2]));
            linkedList[edges[i][1]].add(new Pair(edges[i][0],edges[i][2]));
        }
        pq.offer(new Pair(1,0));
        distance[1]=0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.getNode();
            int currentDistance = distance[node];
            for(Pair pairs:linkedList[node]){
                int adjNode = pairs.getNode();
                int adjNodeWeight = pairs.getWeight();
                int totalDistance = currentDistance+adjNodeWeight;
                if(totalDistance<distance[adjNode]){
                    distance[adjNode]=totalDistance;
                    parent[adjNode]=node;
                    pq.offer(new Pair(adjNode,totalDistance));
                }
            }
        }
        System.out.println(distance[n]+" hello");
        if(distance[n]==Integer.MAX_VALUE){
            list.add(-1);
            return list;
        }
        while(parent[k]!=k){
            list.add(k);
            k=parent[k];
        }
        list.add(1);
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
        System.out.println(shortestPath(5,6,edges));
    }
}
