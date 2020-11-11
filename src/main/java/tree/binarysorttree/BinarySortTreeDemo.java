package tree.binarysorttree;

/**
 * @author zyh
 * @create 2019-09-22 15:55
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};

        BinarySortTree binarySortTree = new BinarySortTree();

        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new BinarySortNode(arr[i]));
        }

        binarySortTree.infixOrder();
        System.out.println("****************************");

        binarySortTree.delNode(10);
        binarySortTree.delNode(1);
        binarySortTree.delNode(9);

        binarySortTree.infixOrder();

    }
}

class BinarySortTree{
    private BinarySortNode root;

    public BinarySortNode getRoot() {
        return root;
    }

    public void add(BinarySortNode node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("树为空");
        }
    }


    public BinarySortNode search(int value){
        if (root == null){
            return  null;
        }else {
            return root.search(value);
        }
    }

    public BinarySortNode searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(BinarySortNode node) {
        BinarySortNode target = node;
        //循环的查找左子节点，就会找到最小值
        while(target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if (root == null){
            return;
        }else {
            BinarySortNode targetNode = search(value);

            if (targetNode == null){
                return;
            }

            if (root.left == null && root.right == null){
                root = null;
                return;
            }

            BinarySortNode parent = searchParent(value);

            if (targetNode.left == null && targetNode.right == null){
                if (parent.left != null && parent.left.value == value){
                    parent.left =null;
                }else if (parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null){
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {
                if (targetNode.left !=null){
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left = targetNode.left;
                        }else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else {
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left = targetNode.right;
                        }else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
}
