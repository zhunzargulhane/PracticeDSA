package datastructuresandalgorithms.graphsPractice;

public class AdjacencyMatrixAgain {
    int e;
    int v;
    int[][] matrix;
    public AdjacencyMatrixAgain(int nodes){
        this.v=nodes;
        e=0;
        matrix = new int[nodes][nodes];
    }

    public void addEdges(int u,int v){
        matrix[u][v]=1;
        matrix[v][u]=1;
        e++;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        System.out.println(v+" vertices "+e+" edges");
        for(int i=0;i<v;i++){
            sb.append(i+" --> ");
            for(int j=0;j<matrix[i].length;j++){
                sb.append(matrix[i][j]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyMatrixAgain adjacencyMatrixAgain = new AdjacencyMatrixAgain(4);
        adjacencyMatrixAgain.addEdges(0,1);
        adjacencyMatrixAgain.addEdges(1,2);
        adjacencyMatrixAgain.addEdges(2,3);
        adjacencyMatrixAgain.addEdges(3,0);
        System.out.println(adjacencyMatrixAgain);
    }
}
