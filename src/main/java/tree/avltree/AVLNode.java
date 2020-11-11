package tree.avltree;

/**
 * @author zyh
 * @create 2019-09-22 20:19
 */
/**
 * @author zyh
 * @create 2019-09-22 15:56
 */
public class AVLNode {
    public int value;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortNode{" +
                "value=" + value +
                '}';
    }

    public void add(AVLNode node){
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

        if (rightHeight() - leftHeight() > 1){
            System.out.println("左旋转");
            if (right != null && right.leftHeight() > right.rightHeight()){
                System.out.println("右子树右旋转");
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1){
            System.out.println("右旋转");
            if (left != null && left.rightHeight() > left.leftHeight()){
                System.out.println("左子树左旋转");
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
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

    public AVLNode search(int value){
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

    public AVLNode searchParent(int value){
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

    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight(){
        if (left == null){
            return 0;
        }else {
            return left.height();
        }
    }

    public int rightHeight(){
        if (right == null){
            return 0;
        }else {
            return right.height();
        }
    }

    //左旋转
    private void leftRotate(){
        AVLNode newNode = new AVLNode(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    //右旋转
    private void rightRotate(){
        AVLNode newNode = new AVLNode(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
}
