package linkList;

/**
 * @author zyh
 * @create 2019-09-11 16:02
 */
public class Josepfu {
    public static void main(String[] args) {
        BoyCircleSingleLinkList boyCircleSingleLinkList = new BoyCircleSingleLinkList();

        boyCircleSingleLinkList.addBoy(30);

        boyCircleSingleLinkList.countBoy(4,8,30);
    }
}


class BoyCircleSingleLinkList{
    private Boy first = null;

    public void addBoy(int num){
        if (num < 1){
            System.out.println("输入有误！");
            return;
        }
        Boy helper = null;

        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i==1){
                first = boy;
                first.setNext(first);
                helper =first;
            }else {
                helper.setNext(boy);
                boy.setNext(first);
                helper = boy;
            }
        }
    }

    public void showBoy(){
        if (first == null){
            System.out.println("没有小孩");
            return;
        }

        Boy helper = first;
        while (true){
            System.out.println("小孩：" + helper.getNo());
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
    }

    public void countBoy(int startNo,int countNum,int num){
        if (first == null || startNo < 1 || startNo >num){
            System.out.println("输入有误");
            return;
        }

        Boy helper = first;

        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if (helper == first){
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("小孩" + first.getNo() + "出列");
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.println("最后一个小孩" + first.getNo() + "出列");
    }
}

// 创建一个Boy类，表示一个节点
class Boy {
    private int no;// 编号
    private Boy next; // 指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}