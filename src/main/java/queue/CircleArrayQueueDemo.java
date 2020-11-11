package queue;

import java.util.Scanner;

/**
 * @author zyh
 * @create 2019-09-09 17:33
 * 环形队列
 */
class CircleArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
        this.front = 0;
        this.rear = 0;
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据
    public void add(int n){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }

        arr[rear] = n;
        rear = ++rear % maxSize;
        System.out.println("添加了" + n);
    }

    //取出数据
    public int take(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = ++front % maxSize;
        return value;
    }

    //查看所有元素
    public void show(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        int size = (rear - front + maxSize) % maxSize;

        for (int i = front; i < front+size; i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

}


public class CircleArrayQueueDemo {
    public static void main(String[] args) {
//创建一个队列
        CircleArrayQueue queue = new CircleArrayQueue(5);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop){
            System.out.println();
            System.out.println("**** s:显示队列 **** a:添加 **** g:取出 **** e:退出 ****");
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
                case 't':
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