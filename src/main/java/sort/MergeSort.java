package sort;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-17 9:55
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            //找到中值
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(arr,left,mid,temp);
            //向右递归
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并方法
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左边有序索引
        int j = mid + 1;//右边有序索引
        int t = 0;//temp的索引

        //左边和右边都未达到末端时
        while (i <= mid && j <= right){
            //如果左边指针指向的元素小于右边指针指向的元素，将左边元素移动到temp中
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {//右边指针指向的元素小于左边，将右边元素移动到temp中
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //当左边指针移动到最末端，将右边剩余元素移动到temp
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        //当右边指针移动到最末端，将左边剩余元素移动到temp
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //将temp数组的指针移动到最前，并将该有序部分复制回arr原数组
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
