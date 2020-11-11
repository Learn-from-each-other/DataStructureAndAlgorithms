package tree.binarytree;

/**
 * @author zyh
 * @create 2019-09-19 16:13
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建需要的结点
        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree(root);

        //测试遍历
        binaryTree.preOrder();
        System.out.println("*****************************");
        binaryTree.infixOrder();
        System.out.println("*****************************");
        binaryTree.postOrder();
        System.out.println("*****************************");

        //测试查找
        Node search = binaryTree.preOrderSearch(1);
        System.out.println(search);
        System.out.println("*****************************");
        Node search1 = binaryTree.infixOrderSearch(2);
        System.out.println(search1);
        System.out.println("*****************************");
        Node search2 = binaryTree.postOrderSearch(3);
        System.out.println(search2);
        System.out.println("*****************************");

        //测试删除节点
        binaryTree.delNode(5);
        binaryTree.preOrder();
    }
}

class BinaryTree{
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
                System.out.println("删除了根节点");
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("该树为空");
        }
    }
    
    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("该树为空");
        }
    }
     //中序遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("该树为空");
        }
    }
     //后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("该树为空");
        }
    }
    //前序查找
    public Node preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序查找
    public Node infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序查找
    public Node postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
    
}
