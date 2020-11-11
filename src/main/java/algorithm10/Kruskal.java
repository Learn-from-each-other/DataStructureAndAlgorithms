package algorithm10;

/**
 * @author zyh
 * @create 2019-09-25 17:43
 */
public class Kruskal {
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};

        //创建KruskalCase 对象实例
        Kruskal kruskalCase = new Kruskal(vertexs, matrix);
        //输出构建的
        kruskalCase.show();
        kruskalCase.kruskal();
    }


    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;

    private static final int INF =Integer.MAX_VALUE;

    public Kruskal(char[] vertexs, int[][] matrix) {
        this.vertexs = new char[vertexs.length];
        this.matrix = new int[vertexs.length][vertexs.length];

        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边的条数
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++){
                if (this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    private int getEnd(int[] ends,int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++){
                if (matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    private void sortEdges(EData[] edges){
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1;j++){
                if (edges[j].weight > edges[j + 1].weight){
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    public void show(){
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void kruskal(){
        int index = 0;
        int[] ends = new int[edgeNum];

        EData[] rets = new EData[edgeNum];

        EData[] edges = getEdges();

        sortEdges(edges);

        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);

            if (m != n){
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }

        System.out.println("最小生成树为");

        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }
}

class EData{
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[<"+ start+","+ end +">:"+ weight+"] ";
    }
}

