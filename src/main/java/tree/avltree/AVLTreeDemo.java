package tree.avltree;

import tree.avltree.AVLNode;

/**
 * @author zyh
 * @create 2019-09-22 20:18
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8}; //左旋转测试
//        int[] arr = { 10, 12, 8, 9, 7, 6 }; //右旋转测试
        int[] arr = { 10, 11, 7, 6, 8, 9 }; //双旋转测试

        AVLTree avlTree = new AVLTree();

        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLNode(arr[i]));
        }

        avlTree.infixOrder();
        System.out.println("****************************");
        System.out.println("树的高度 = " + avlTree.getRoot().height());
        System.out.println("左子树的高度 = " + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度 = " + avlTree.getRoot().rightHeight());
        System.out.println("当前根节点 = " + avlTree.getRoot());
    }
}

class AVLTree{
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    public void add(AVLNode node){
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


    public AVLNode search(int value){
        if (root == null){
            return  null;
        }else {
            return root.search(value);
        }
    }

    public AVLNode searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(AVLNode node) {
        AVLNode target = node;
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
            AVLNode targetNode = search(value);

            if (targetNode == null){
                return;
            }

            if (root.left == null && root.right == null){
                root = null;
                return;
            }

            AVLNode parent = searchParent(value);

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