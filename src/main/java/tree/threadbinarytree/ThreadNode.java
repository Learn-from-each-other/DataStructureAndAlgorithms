package tree.threadbinarytree;

/**
 * @author zyh
 * @create 2019-09-19 16:14
 */
public class ThreadNode {
    private int no;
    private String name;
    private ThreadNode left;
    private ThreadNode right;
    private int leftType;
    private int rightType;

    public ThreadNode(int no, String name) {
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

    public ThreadNode getLeft() {
        return left;
    }

    public void setLeft(ThreadNode left) {
        this.left = left;
    }

    public ThreadNode getRight() {
        return right;
    }

    public void setRight(ThreadNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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
    public ThreadNode preOrderSearch(int no){
        ThreadNode resNode = null;//结果节点
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
    public ThreadNode infixOrderSearch(int no){
        ThreadNode resNode = null;
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

    public ThreadNode postOrderSearch(int no){
        ThreadNode resNode = null;
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
