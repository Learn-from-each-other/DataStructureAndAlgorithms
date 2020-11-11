package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zyh
 * @create 2019-09-22 9:44
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };

        HuffmanTree huffmanTree = new HuffmanTree(arr);

        huffmanTree.preOrder();
    }
}

class HuffmanTree{

    private HuffmanNode root;
    List<HuffmanNode> nodes;

    public HuffmanTree(int[] arr) {
        this.nodes = new ArrayList<HuffmanNode>();

        for (int value : arr){
            nodes.add(new HuffmanNode(value));
        }

        while (nodes.size() > 1){
            Collections.sort(nodes);

            HuffmanNode leftNode = nodes.get(0);
            HuffmanNode rightNode = nodes.get(1);

            HuffmanNode parent = new HuffmanNode(leftNode.value + rightNode.value);

            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }

        this.root = nodes.get(0);

    }


    public void preOrder(){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("树为空");
        }
    }
}
