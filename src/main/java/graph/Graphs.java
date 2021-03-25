package graph;

/**
 * 有向带权图的集合类
 * 权值的取值范围为非0的整数,0表示边不存在
 */
final public class Graphs {
    private final int vertices; //顶点的数量
    private int edges = 0;  //边的数量
    private int[][] matrix; //图的邻接矩阵表示

    public Graphs(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    /*-------- get vertices and edges size --------*/

    public int V() {
        return this.vertices;
    }

    public int E() {
        return this.edges;
    }

    /*----------- add|remove -------------*/

    public void addEdge(int start, int end) {
        addEdge(start, end, 1);
    }

    public void addEdge(int start, int end, int weight) {
        checkEdgeParameter(start, end);
        if (matrix[start][end] == 0) {
            matrix[start][end] = weight;
            edges++;
        } else {
            System.err.println("This edge is already exist!");
        }
    }

    public void removeEdge(int start, int end) {
        checkEdgeParameter(start, end);
        if (matrix[start][end] != 0) {
            matrix[start][end] = 0;
            edges--;
        } else {
            System.err.println("This edge isn't exist!");
        }
    }

    /*------ get -------*/

    //获取边的权值
    public double getEdge(int from, int to) {
        checkEdgeParameter(from ,to);
        if (matrix[from][to] != 0) {
            return matrix[from][to];
        } else {
            System.err.println("This edge isn't exist!");
            return 0;
        }
    }

    //获取图的邻接矩阵
    public int[][] getMatrix() {
        return matrix;
    }

    //判断边数是否为空
    public boolean isEmpty() {
        return edges == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res.append(matrix[i][j]).append("\t");
            }
            res.append("\n");
        }
        return res.toString();
    }


    /*---- utils ----*/
    public void checkEdgeParameter(int from, int to) {
        if (from < 0 || to < 0 || from > vertices - 1 || to > vertices - 1)
            throw new IndexOutOfBoundsException("点的范围在 0 - " + (vertices - 1));
    }
}