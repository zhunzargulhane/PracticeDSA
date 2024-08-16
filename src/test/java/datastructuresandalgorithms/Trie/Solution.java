package datastructuresandalgorithms.Trie;

import java.util.LinkedList;
import java.util.PriorityQueue;

class PairWeight {
    int node;
    long weight;

    public PairWeight(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }

    public long getWeight() {
        return weight;
    }

    public int getNode() {
        return node;
    }
}

class PairWeightPQ implements Comparable<PairWeightPQ> {
    int node;
    long weight;

    public PairWeightPQ(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }

    public long getWeight() {
        return weight;
    }

    public int getNode() {
        return node;
    }

    //@Override
    public int compareTo(PairWeightPQ o) {
        int j = (int) (this.getWeight() - o.getWeight());
        if (j == 0)
            return this.getNode() - o.getNode();
        return (int) (this.getWeight() - o.getWeight());
    }
}


class Solution {
    private LinkedList<PairWeight>[] linkedLists;

    public int countPaths(int n, int[][] roads) {

        this.linkedLists = new LinkedList[n];
        for (int i = 0; i < n; i++) this.linkedLists[i] = new LinkedList();
        for (int i = 0; i < roads.length; i++) {
            this.linkedLists[roads[i][0]].add(new PairWeight(roads[i][1], roads[i][2]));
            this.linkedLists[roads[i][1]].add(new PairWeight(roads[i][0], roads[i][2]));
        }
        long[] distance = new long[n];
        for (int i = 0; i < n; i++) distance[i] = Long.MAX_VALUE;
        long[] ways = new long[n];
        PriorityQueue<PairWeightPQ> priorityQueue = new PriorityQueue<PairWeightPQ>();
        distance[0] = 0;
        ways[0] = 1;
        priorityQueue.add(new PairWeightPQ(0, 0));
        while (!priorityQueue.isEmpty()) {
            PairWeightPQ pairWeightPQ = priorityQueue.poll();
            int node = pairWeightPQ.getNode();
            long nodeDistance = pairWeightPQ.getWeight();
            for (PairWeight pairWeight : linkedLists[node]) {
                long adjDistance = pairWeight.getWeight();
                int adjNode = pairWeight.getNode();
                if (nodeDistance + adjDistance < distance[adjNode]) {
                    distance[adjNode] = nodeDistance + adjDistance;
                    priorityQueue.add(new PairWeightPQ(adjNode, distance[adjNode]));
                    ways[adjNode] = ways[node] + ways[adjNode];
                } else if (nodeDistance + adjDistance == distance[adjNode]) {
                    ways[adjNode] = ways[node] + ways[adjNode];
                }
            }
        }
        return (int) ways[n - 1];
    }
}
