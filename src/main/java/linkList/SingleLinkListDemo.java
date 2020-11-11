package linkList;

import java.util.concurrent.BrokenBarrierException;

/**
 * @author zyh
 * @create 2019-09-09 17:35
 * 单项链表
 */
class Node{
    public int no;
    public String value;
    public Node next;

    public Node(int no, String value) {
        this.no = no;
        this.value = value;
    }

    @Override
    public String toString() {
        return no + ":" + value;
    }
}

class SingleLinkList{
    Node head = new Node(0,"");

    //返回头结点
    public Node getHead(){
        return head;
    }

    //添加元素
    public void add(Node node){
        Node temp = head;
        //遍历所有节点找到尾节点
        boolean flag = false;
        while (true){
            if (temp.no == node.no){
                flag = true;
            }
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("已存在no为："+ node.no + "的元素");
        }else {
            temp.next = node;
            System.out.println("已添加");
        }
    }

    //按照no顺序插入
    public void insertOrderByNo(Node node){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > node.no){
                break;
            }else if (temp.next.no == node.no){
                flag =true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("已存在no为："+ node.no + "的元素");
        }else {
            node.next = temp.next;
            temp.next = node;
            System.out.println("已插入");
        }
    }

    //更新节点数据
    public void update(Node node){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while(true){
            if (temp ==null){
                break;
            }
            if (temp.no == node.no){
                flag =true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.value = node.value;
        }else {
            System.out.println("未找到no为：" + node.no + "的节点");
        }
    }

    //删除节点
    public void del(int no){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("未找到no为：" + no + "的节点");
        }
    }

    //遍历链表
    public void show(){
        if (head.next ==null){
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true){
            if (temp ==null){
                break;
            }
            System.out.println(temp);

            temp = temp.next;
        }
    }
}


public class SingleLinkListDemo {
    public static void main(String[] args) {
        Node n1 = new Node(1,"zyh");
        Node n2 = new Node(2,"zs");
        Node n3 = new Node(3,"ls");
        Node n4 = new Node(4,"cnm");

        SingleLinkList linkList = new SingleLinkList();

//        linkList.add(n1);
//        linkList.add(n2);
//        linkList.add(n3);
//        linkList.add(n4);

        linkList.insertOrderByNo(n1);
        linkList.insertOrderByNo(n4);
        linkList.insertOrderByNo(n3);
        linkList.insertOrderByNo(n2);

        Node dsg = new Node(1, "dsg");
        linkList.update(dsg);
        linkList.del(3);
        linkList.show();
    }
}
