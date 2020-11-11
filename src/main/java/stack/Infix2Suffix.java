package stack;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zyh
 * @create 2019-09-12 9:15
 * 中缀表达式转后缀表达式
 */
public class Infix2Suffix {

    public static List<String> string2list(String s){
        Stack<String> operstack = new Stack();
        List<String> tempstack = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do{
            if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
                list.add("" + c);
                i++;
            }else {
                str = "";
                while(i<s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                list.add(str);
            }
        }while (i< s.length());


        for(String item: list){
            if (item.matches("\\d+")){
                tempstack.add(item);
            }else if (item.equals("(")){
                operstack.push(item);
            }else if (item.equals(")")){
                while (!operstack.peek().equals("(")){
                    tempstack.add(operstack.pop());
                }
                operstack.pop();
            }else{
                while (operstack.size() != 0 && getOperation(operstack.peek()) >= getOperation(item)){
                    tempstack.add(operstack.pop());
                }
                operstack.push(item);
            }
        }

        while (operstack.size() != 0){
            tempstack.add(operstack.pop());
        }

        return tempstack;
    }


    public static int getOperation(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = 1;
                break;
            case "-":
                res =  1;
                break;
            case "*":
                res =  2;
                break;
            case "/":
                res =  2;
                break;
            default:
                break;
        }
        return res;
    }
}
