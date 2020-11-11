package tree.binarytree;

/**
 * @author zyh
 * @create 2019-09-19 16:14
 */
public class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        //输出本节点
        System.out.println(this);
        //递归输出左子树
        if (this.left != null){
            this.left.preOrder();
        }
        //递归输出右子树
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        //递归输出左子树
        if (this.left != null){
            this.left.infixOrder();
        }
        //输出本节点
        System.out.println(this);
        //递归输出右子树
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        //递归输出左子树
        if (this.left != null){
            this.left.postOrder();
        }
        //递归输出右子树
        if (this.right != null){
            this.right.postOrder();
        }
        //输出本节点
        System.out.println(this);
    }


    //前序遍历查找
    public Node preOrderSearch(int no){
        Node resNode = null;//结果节点
        //比较当前节点
        if (this.no == no){
            return this;
        }
        //递归查找左子树
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }

        //递归向右子树查找
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }


    //中序遍历查找
    public Node infixOrderSearch(int no){
        Node resNode = null;
        //递归查找左子树
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        //比较当前节点
        if (this.no == no){
            return this;
        }
        //递归向右子树查找
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public Node postOrderSearch(int no){
        Node resNode = null;
        //递归查找左子树
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        //递归向右子树查找
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        //比较当前节点
        if (this.no == no){
            return this;
        }
        return resNode;
    }

    //删除节点，其子树也删除
    public void delNode(int no){
        //判断左节点是否是删除的节点
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //判断右节点是否是删除的节点
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //如果左右节点都不是
        //则递归向左删除
        if (this.left != null){
            this.left.delNode(no);
        }
        //递归向右删除
        if (this.right != null){
            this.right.delNode(no);
        }

    }
}
