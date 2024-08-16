package datastructuresandalgorithms.graphs;

public class adMatrix {

    private int[][] matrix;
    private int v;
    private int e;

    public adMatrix(int nodes) {
        matrix = new int[nodes][nodes];
        this.v = nodes;
    }

    public void addEdges(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
        e++;
    }

    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Vertices "+v+" edges "+e);
        for(int i=0;i<v;i++){
            sb.append(i+ " : ");
            for(int j=0;j<matrix[i].length;j++){
                sb.append(matrix[i][j]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        adMatrix adMatrix = new adMatrix(4);
        adMatrix.addEdges(0, 1);
        adMatrix.addEdges(1, 2);
        adMatrix.addEdges(2, 3);
        adMatrix.addEdges(3, 0);
        System.out.println(adMatrix);
    }
}
