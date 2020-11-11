package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyh
 * @create 2019-09-23 12:33
 */
public class GraphDemo {
    public static void main(String[] args) {

//        String Vertexs[] = {"A", "B", "C", "D", "E"};
//        Graph graph = new Graph(Vertexs);
//        graph.insertEdge(0,1,1);
//        graph.insertEdge(0,2,1);
//        graph.insertEdge(1,2,1);
//        graph.insertEdge(1,3,1);
//        graph.insertEdge(1,4,1);

        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(Vertexs);
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();
        System.out.println("***********");
        System.out.println("节点个数 = " + graph.getNumOfVertex());
        System.out.println("边个数 = " + graph.getNumOfEdges());
        System.out.println("1 - 3 边的权重 = " + graph.getWeight(1,3));
        System.out.println("节点3的值 = " + graph.getValueByIndex(3));
        System.out.println("***********");
        System.out.println("深度优先遍历：");
        graph.dfs();
        System.out.println("广度优先遍历：");
        graph.bfs();
    }
}

class Graph{
    //节点列表
    private List<String> vertexList;
    //邻接矩阵
    private int[][] edges;
    //边的个数
    private int numOfEdges;
    //是否被访问标记
    private boolean[] isVisited;

    //构造方法
    public Graph(String[] n) {
        edges = new int[n.length][n.length];
        vertexList = new ArrayList<>(n.length);
        numOfEdges = 0;
        for (int i = 0; i < n.length; i++) {
            insertVertex(n[i]);
        }
    }

    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //打印邻接矩阵
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //返回边的个数
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //查找指定位置的值
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //得到边的权重
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //添加节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //得到第一个节点的邻接节点的下标，如果存在就返回对应的下标，不存在就返回-1
    public int getFirstNeughbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标获取下一个节点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历
    private void dfs(boolean[] isVisited,int i ){
        //先输出初始节点
        System.out.print(getValueByIndex(i) + "->");
        //将初始节点在访问标记数组中置为true
        isVisited[i] = true;
        //得到初始节点的邻接节点
        int w = getFirstNeughbor(i);
        //判断邻接节点是否存在
        while (w != -1){
            //判断邻接节点是否被访问过
            if (!isVisited[w]){
                //递归深度遍历邻接节点
                dfs(isVisited,w);
            }
            //得到下一个节点
            w = getNextNeighbor(i,w);
        }
    }

    //重载深度优先遍历
    public void dfs(){
        //重置访问标记数组
        isVisited = new boolean[vertexList.size()];
        //深度遍历所有未被访问过的节点
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //广度优先遍历
    private void bfs(boolean[] isVisited,int i ){
        int u;
        int w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            u = (Integer)queue.removeFirst();
            w = getFirstNeughbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    //重载广度优先遍历
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
}
