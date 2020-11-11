package algorithm10;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-25 17:01
 */
public class Prim {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        MyGraph myGraph = new MyGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(myGraph,verxs,data,weight);
        minTree.showGraph(myGraph);
        minTree.prim(myGraph,1);
    }
}


//最小生成树对象
class MinTree{

    //创建图的方法
    public void createGraph(MyGraph graph,int verxs,char[] data,int[][] weight){
        int i,j;
        for (i = 0;i < verxs;i++){
            graph.data[i] = data[i];
            for (j = 0;j < verxs; j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //输出图的方法
    public void showGraph(MyGraph graph){
        for (int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    //普利姆算法
    public void prim(MyGraph graph,int v){
        //标记被访问过的节点
        int visited[] = new int[graph.verxs];
        //把当前节点标记为已经访问过
        visited[v] = 1;
        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //记录每次遍历后的最小权重边
        int minWeight = Integer.MAX_VALUE;
        //遍历节点个数-1次
        for (int k = 1; k < graph.verxs ; k++){

            //遍历行
            for (int i = 0; i < graph.verxs; i++) {
                //遍历列
                for (int j = 0;j < graph.verxs; j++){
                    //如果遍历到第i个节点被访问过且该节点连接的第j个节点未被访问过，且它们之间的边的权重小于上一次的权重，则更新minWeight和h1、h2
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight){
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //输出该边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值:" + minWeight);
            //标记h2(i的第j)节点为被访问过
            visited[h2] = 1;
            //将最小权重边置为最大值
            minWeight = Integer.MAX_VALUE;

        }
    }


}

//创建图对象
class MyGraph{
    int verxs;//节点个数
    char[] data;//节点名称
    int[][] weight;//边的权重，无边则为Integer.maxVal

    public MyGraph(int verxs) {
        this.verxs = verxs;
        this.data = new char[verxs];
        this.weight = new int[verxs][verxs];
    }
}
