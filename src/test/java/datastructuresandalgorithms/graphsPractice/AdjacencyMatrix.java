package datastructuresandalgorithms.graphsPractice;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyMatrix {
    private int v;
    private int e;
    int[][] matrix;

    public AdjacencyMatrix(int nodes) {
        this.v = nodes;
        e = 0;
        matrix = new int[nodes][nodes];
    }

    public void addEdges(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
        e++;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        System.out.println(v+" "+"vertices and "+e+" "+"edges");
        for(int i=0;i<v;i++){
            sb.append(i+" -> ");
            for(int j=0;j<matrix[i].length;j++){
                sb.append(matrix[i][j]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(4);
        adjacencyMatrix.addEdges(0,1);
        adjacencyMatrix.addEdges(1,2);
        adjacencyMatrix.addEdges(2,3);
        adjacencyMatrix.addEdges(3,0);
        System.out.println(adjacencyMatrix);
    }


}
