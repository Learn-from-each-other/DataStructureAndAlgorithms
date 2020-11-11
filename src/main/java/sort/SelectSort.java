package sort;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-16 20:29
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int arr[]){

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//存放每轮最小值的索引
            int min = arr[i];//存放每轮最小值的副本
            //定位本轮最小值
            for (int j = i + 1;j < arr.length ;j++){
                //如果目前最小值大于遍历到的值，将遍历到的值赋给最小值
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            //将最小值放在i处，此时的minIndex为本轮的的最小值的索引，min为最小值的副本
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
