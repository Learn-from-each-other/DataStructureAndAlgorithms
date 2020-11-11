package tree.binarysorttree;

import java.io.InputStream;

/**
 * @author zyh
 * @create 2019-09-22 15:56
 */
public class BinarySortNode {
    int value;
    BinarySortNode left;
    BinarySortNode right;

    public BinarySortNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortNode{" +
                "value=" + value +
                '}';
    }

    public void add(BinarySortNode node){
        if (node == null){
            return;
        }

        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    public BinarySortNode search(int value){
        if (value == this.value){
            return this;
        }else if (value < this.value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    public BinarySortNode searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if (value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }

    }

}
