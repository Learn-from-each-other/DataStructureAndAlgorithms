package recursion;

/**
 * @author zyh
 * @create 2019-09-12 15:51
 * 递归
 */
public class RecursionDemo {
    public static void main(String[] args) {
//        RecursionDemo.test(5);
        System.out.println(factorial(5));
    }

    public static void test(int n){
        if (n >2){
            test(n-1);
        }
        System.out.println("n=" + n);
    }

    //阶乘
    public static int factorial(int n){
        if (n == 1){
            return 1;
        }else {
            return factorial(n-1) * n;
        }
    }
}
