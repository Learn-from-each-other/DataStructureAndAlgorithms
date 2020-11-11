package sort;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-17 9:55
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;//左指针副本
        int r = right;//右指针副本
        int pivot = arr[(left + right) / 2];//中间元素
        int temp = 0;//交换临时变量

        //如果左指针在右指针的左边，则一直循环
        while( l < r){
            //找出左边大于pivot的元素的下标
            while (arr[l] < pivot){
                l += 1;
            }
            //找出右边小于pivot的元素的下标
            while (arr[r] > pivot){
                r -= 1;
            }
            //如果左指针和右指针重合或相交则退出循环
            if (l >= r){
                break;
            }
            //将左边找到的元素与右边找到的元素交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换后，左边交换元素的值等于pivot，则右指针前移
            if (arr[l] == pivot){
                r -= 1;
            }
            //如果交换后，右边交换元素的值等于pivot，则左指针后移
            if (arr[r] == pivot){
                l += 1;
            }
        }

        //如果左指针等于右指针，使得左指针右移，右指针左移，否则会出现栈溢出
        if (l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r){
            quickSort(arr,left,r);
        }
        //向右递归
        if (right > l){
            quickSort(arr,l,right);
        }
    }
}
