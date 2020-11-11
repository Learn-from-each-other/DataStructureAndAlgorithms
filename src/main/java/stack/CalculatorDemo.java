package stack;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author zyh
 * @create 2019-09-11 16:53
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int res = calculator.cal("7*2*2-5+1-5+3-4");
        System.out.println(res);
    }
}

class Calculator{
    private MyStack numStack;
    private MyStack operStack;

    public Calculator() {
        numStack = new MyStack(20);
        operStack = new MyStack(20);
    }


    //优先级
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是否为运算符
    public  boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算
    public int cal (int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    public int cal(String expr){
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true){
            ch = expr.substring(index,index+1).charAt(0);

            if (isOper(ch)){
                if (operStack.isEmpty()){
                    operStack.push(ch);
                }else {
                    if (priority(ch) <= priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }
            }else {
                keepNum += ch;
                if (index == expr.length() -1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (isOper(expr.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expr.length()){
                break;
            }
        }

        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = cal(num1,num2,oper);
            numStack.push(res);
        }

        return numStack.pop();
    }
}


class MyStack{
    private int maxSize; // 栈的大小
    private int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;// top表示栈顶，初始化为-1

    //构造器
    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //增加一个方法，可以返回当前栈顶的值, 但是不是真正的pop
    public int peek() {
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈-push
    public void push(int value) {
        //先判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈-pop, 将栈顶的数据返回
    public int pop() {
        //先判断栈是否空
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
