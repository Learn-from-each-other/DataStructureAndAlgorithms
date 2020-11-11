package tree.threadbinarytree;

/**
 * @author zyh
 * @create 2019-09-19 17:27
 */
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadNode root = new ThreadNode(1, "tom");
        ThreadNode node2 = new ThreadNode(3, "jack");
        ThreadNode node3 = new ThreadNode(6, "smith");
        ThreadNode node4 = new ThreadNode(8, "mary");
        ThreadNode node5 = new ThreadNode(10, "king");
        ThreadNode node6 = new ThreadNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadBinaryTree threadedBinaryTree = new ThreadBinaryTree(root);
        threadedBinaryTree.toThread();

        ThreadNode left = node5.getLeft();
        System.out.println("十号节点的前驱节点：" + left);
        ThreadNode right = node5.getRight();
        System.out.println("十号节点的后驱节点：" + right);

        System.out.println("************************");
        threadedBinaryTree.showThreadTree();
        System.out.println("************************");
    }
}

class ThreadBinaryTree{
    private ThreadNode root;
    private ThreadNode pre = null;//在递归线索化时，总是保留前一个节点

    public ThreadBinaryTree(ThreadNode root) {
        this.root = root;
    }

    //中序线索化二叉树
    public void toThread(){
        toThread(root);
    }

    public void toThread(ThreadNode node){
        //判断节点是否为空，不为空才继续执行
        if (node == null){
            return;
        }
        //递归线索化左子树
        toThread(node.getLeft());

        //线索化当前节点
        //如果当前节点的左子节点为空，则使得当前节点的左节点指向前驱节点，同时将左节点类型置1
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        //如果当前节点的右子节点为空，则使得pre节点的右子节点指向当前节点，同时将右子节点类型置1
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //更新前驱节点
        pre = node;

        //递归线索化右子树
        toThread(node.getRight());
    }

    //遍历线索化二叉树
    public void showThreadTree(){
        //存放root的副本，因为root不能变，node要变
        ThreadNode node = root;
        while (node != null){
            //找出最左节点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            //打印最左节点
            System.out.println(node);

            //向右遍历
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();
        }
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
    public ThreadNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序查找
    public ThreadNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序查找
    public ThreadNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

