package tree.huffmancode;

/**
 * @author zyh
 * @create 2019-09-22 10:09
 */
public class HuffmanNode implements Comparable<HuffmanNode>  {
    Byte data; // 存放数据
    int weight; //权值
    HuffmanNode left;//
    HuffmanNode right;

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    public String toString() {
        return "HuffmanNode [data = " + data + " weight=" + weight + "]";
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}