package linkList;

import java.net.CacheRequest;
import java.util.TooManyListenersException;
import java.util.zip.CRC32;

/**
 * @author zyh
 * @create 2019-09-11 10:59
 */
class Node3{
    private int no;
    private String name;
    private Node3 next;
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node3 getNext() {
        return next;
    }

    public void setNext(Node3 next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node3(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return  no + ":" + name;
    }
}

class CircleSingleLinkList{
    private Node3 first =null;

    public void add(Node3 node3){
         if (first == null){
             first = node3;
             node3.setNext(node3);
         }else {
             Node3 temp = first;
             while (true){
                 if (temp.getNext() == first){
                     temp.setNext(node3);
                     node3.setNext(first);
                     break;
                 }
                 temp = temp.getNext();
             }
         }
    }

    public void update(Node3 node3){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Node3 temp = first;
        boolean flag = false;
        while (true){
            if (temp.getNo() == node3.getNo()){
                flag = true;
                break;
            }
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }

        if (flag){
            temp.setName(node3.getName());
        }else {
            System.out.println("未找到no为" + node3.getNo() + "的节点");
        }
    }

    public void show(){
        if (first ==null){
            System.out.println("链表为空");
            return;
        }
        Node3 temp = first;
        while (true){
            System.out.println(temp);
            if (temp.getNext() == first){
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * TODO
     */
    public void del(int no){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Node3 temp = first;
        boolean flag = false;
        while (true){
            if (temp.getNext().getNo() == no){
                flag =true;
                break;
            }
            if (temp.getNext() == first){
                break;
            }
            temp =temp.getNext();
        }

        if (flag){
            if(temp.getNext() == first){
                first = null;
            }else {
                temp.setNext(temp.getNext().getNext());
            }
        }else {
            System.out.println("未找到no为：" + no + "的节点");
        }
    }
}

public class CircleSingleLinkListDemo {
    public static void main(String[] args) {
        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();

        Node3 node1 = new Node3(1,"zs");
        Node3 node2 = new Node3(2,"ls");
        Node3 node3 = new Node3(3,"ww");
        Node3 node4 = new Node3(4,"cnm");

        circleSingleLinkList.add(node1);
        circleSingleLinkList.add(node2);
        circleSingleLinkList.add(node3);
        circleSingleLinkList.add(node4);

        circleSingleLinkList.show();

        circleSingleLinkList.update(new Node3(4,"nmb"));

        System.out.println("============================");

        circleSingleLinkList.show();


        circleSingleLinkList.del(1);
        circleSingleLinkList.del(2);
        circleSingleLinkList.del(3);
        circleSingleLinkList.del(4);

        System.out.println("=========================");

        circleSingleLinkList.show();
    }
}
