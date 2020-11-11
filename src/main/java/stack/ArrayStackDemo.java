package stack;

import java.util.Scanner;

/**
 * @author zyh
 * @create 2019-09-11 16:19
 * 栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("********push/pop/show/exit*********");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.show();
                    break;
                case "pop":
                    try {
                        stack.pop();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    System.out.println("请输入数字：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "exit":
                    loop = false;
                    break;
                default:
                    System.out.println("无法解析命令");
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int re = stack[top];
        top--;
        return re;
    }

    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(i + ":" + stack[i]);
        }
    }
}
