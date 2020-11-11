package tree.huffmantree;

/**
 * @author zyh
 * @create 2019-09-22 9:46
 */
public class HuffmanNode implements Comparable<HuffmanNode>{
    int value;
    HuffmanNode left;
    HuffmanNode right;

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public HuffmanNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " [value=" + this.value + "] ";
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.value - o.value;
    }
}
