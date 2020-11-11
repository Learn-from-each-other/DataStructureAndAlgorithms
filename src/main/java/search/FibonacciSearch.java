package search;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-19 14:35
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int [] arr = {1,8, 10, 56,89,153,530,931,1000,1156, 1234};
        int i = fibSearch(arr, 153);
        System.out.println(i);
    }

    public static int maxSize = 20;

    //构造斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    //斐波那契查找
    public static int fibSearch(int[] arr,int key){
        //左指针
        int low = 0;
        //右指针
        int high = arr.length - 1;
        //
        int k = 0;
        //中值索引
        int mid = 0;
        //斐波那契数列
        int f[] = fib();
        //使得k指向斐波那契数列中刚好大于arr数组长度的值的位置
        while (high > f[k] -1){
            k++;
        }

        //使得arr数组长度与斐波那契数列中k指向的值相等,不够的用0补全
        int[] temp = Arrays.copyOf(arr,f[k]);

        //用arr数组的最后一个元素填充temp数组补全的元素值
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high){
            //
            mid = low + f[k - 1] -1;
            if (key < temp[mid]){
                high = mid - 1;
                k--;
            }else if (key >temp[mid]){
                low = mid + 1;
                k -= 2;
            }else{
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

}
