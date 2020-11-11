package sort;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-17 9:55
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //找出最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        //得到最大值的位数
        int maxLength = (max + "").length();

        //创建一个二维数组模拟十个桶
        int[][] bucket = new int[10][arr.length];

        //创建一个一维数组记录桶中元素的个数
        int[] bucketElementCounts = new int[10];

        //对每一位进行操作
        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            //装桶操作，将每个元素按照位上的值装进不同桶中，并在一位数组中做记录
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //原数组下标
            int index = 0;
            //取桶操作，遍历所有的桶，如果记录数组中该桶的元素数量不为0，则遍历该桶
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    //遍历元素数量不为0的桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //记录数组置0，即清空该桶
                bucketElementCounts[k] = 0;
            }
        }
    }
}
