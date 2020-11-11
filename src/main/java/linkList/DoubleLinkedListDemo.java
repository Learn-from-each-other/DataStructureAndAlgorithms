package linkList;

import java.util.TooManyListenersException;

/**
 * @author zyh
 * @create 2019-09-11 10:22
 * 双向链表
 */
class Node2{
    public int no;
    public String name;
    public Node2 next;
    public Node2 pre;

    public Node2(int no,String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return no + ":" + name;
    }
}

class DoubleLinkedList{
    private Node2 header = new Node2(0,"");

    public Node2 getHeader() {
        return header;
    }

    //遍历
    public void show(){
        if (header.next == null){
            System.out.println("链表为空");
            return;
        }
        Node2 temp = header.next;

        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);

            temp = temp.next;
        }
    }

    //在末尾添加
    public void add(Node2 node2){
        Node2 temp = header;

        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = node2;
        node2.pre = temp;
    }

    //修改节点内容
    public void update(Node2 node2){
        if (header.next == null){
            System.out.println("链表为空");
            return;
        }
        Node2 temp = header.next;
        boolean flag = false;
        while (true){
            if (temp ==null){
                break;
            }
            if (temp.no == node2.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.name = node2.name;
        }else {
            System.out.println("未找到no为" + node2.no + "的节点");
        }
    }

    //删除节点
    public void del(int no){
        if (header.next == null){
            System.out.println("链表为空");
            return;
        }

        Node2 temp = header.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.pre.next = temp.next;
            if (temp.next !=null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("未找到no为" + no +"的节点");
        }
    }

}


public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node2 node1 = new Node2(1, "zs");
        Node2 node2 = new Node2(2, "ls");
        Node2 node3 = new Node2(3, "ww");
        Node2 node4 = new Node2(4, "cnm");
        Node2 node5 = new Node2(5, "nb");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node5);

        doubleLinkedList.show();

        doubleLinkedList.update(new Node2(5,"zyh"));

        System.out.println("====================");
        doubleLinkedList.show();

        doubleLinkedList.del(1);

        System.out.println("====================");
        doubleLinkedList.show();
    }
}
