package stack;

import java.util.List;
import java.util.Stack;

/**
 * @author zyh
 * @create 2019-09-12 9:12
 * 逆波兰计算器
 */
public class PolandNotationDemo {
    public static void main(String[] args) {
        String exper = "(3+4)*5-8/2";
        int re = PolandNotation.calculate(exper);
        System.out.println(exper + " = " + re);
    }
}

class PolandNotation{

    public static int calculate(String exper){
        List<String> list = Infix2Suffix.string2list(exper);
        Stack<String> stack = new Stack<>();
        int res = 0;
        for (String item:list){
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                if (item.equals("+")){
                    res = num2 + num1;
                }else if (item.equals("-")){
                    res = num2 - num1;
                }else if (item.equals("*")){
                    res = num2 * num1;
                }else if (item.equals("/")){
                    res = num2 / num1;
                }else {
                    throw new RuntimeException("未识别的运算符");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

