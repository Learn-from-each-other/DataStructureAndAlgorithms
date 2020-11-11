package sort;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-16 21:10
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
//        exchangeShellSort(arr);
        moveShellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //交换式
    public static void exchangeShellSort(int[] arr){
        int temp = 0;//交换中间变量

        //按照步长进行分组
        for (int gap = arr.length / 2;gap > 0; gap /= 2){
            //从每组第二个元素开始，遍历之后所有元素
            for (int i = gap;i<arr.length;i++){
                //每遍到一个元素，都要遍历该元素组内之前所有元素做交换排序
                for (int j = i - gap;j >= 0; j -= gap){
                    if (arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //移动式
    public static void moveShellSort(int[] arr){
        //按不同步长分组，步长每次减半
        for (int gap = arr.length /2;gap > 0;gap /= 2){
            //从每组第二个元素开始，遍历之后所有元素
            for (int i = gap;i < arr.length;i++){
                //每遍到一个元素，都要遍历该元素组内之前所有元素做插入排序
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }



}
