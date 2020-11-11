package queue;

import java.util.Scanner;

/**
 * @author zyh
 * @create 2019-09-09 13:51
 * 队列
 */
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
        this.front = -1;
        this.rear = -1;
    }

    //判断队列是否满了
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void add(int n){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
        System.out.println("已添加" + n);
    }

    //取出数据
    public int take(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //显示所有数据
    public void show(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\n",arr[i]);
        }
    }
}


public class ArrayQueueDemo{
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(5);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop){
            System.out.println("s:显示队列");
            System.out.println("a:添加");
            System.out.println("g:取出");
            System.out.println("e:退出");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入添加的元素：");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    try {
                        int take = queue.take();
                        System.out.println("取出的数据为："+ take);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("未知命令");
            }
        }
        System.out.println("程序退出");
    }
}