package sort;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-16 20:09
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,20};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;//标识每轮是否发生交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0;j < arr.length - 1 - i;j++){
                //如果前数比后数大，则交换
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if(!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}
