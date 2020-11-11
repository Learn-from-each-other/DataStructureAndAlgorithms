package tree.heapsort;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-19 19:36
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序
    public static void heapSort(int arr[]){
        //交换中间元素
        int temp = 0;

        //将无序序列构建为一个大顶堆
        for (int i = arr.length / 2 - 1;i >= 0; i--){
            adjustHeap(arr,i,arr.length);
        }

        //将堆顶元素与末尾元素交换
        for (int j = arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    //构建大顶堆
    public static void adjustHeap(int arr[],int i,int lenght){
        int temp =arr[i];

        for (int k = i * 2 + 1;k <lenght;k=k * 2 +1){
            if (k + 1 < lenght && arr[k] < arr[k + 1]){
                k++;
            }

            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }

        arr[i] = temp;
    }
}
