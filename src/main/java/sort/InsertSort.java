package sort;

import java.util.Arrays;

/**
 * @author zyh
 * @create 2019-09-16 20:38
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        int insertVal = 0;//待插入的元素的副本
        int insertIndex = 0;//插入位置索引，刚开始是有序部分最后一个元素的索引
        //遍历无序部分
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1;
            insertVal = arr[i];

            //      1、从有序部分的最后一个开始比较
            //      2、当待插入元素小于有序元素时，继续向前查找，并把该有序元素向后移动一位，以便腾出一位空间，
            //有序部分的最后一个元素（最大值）向后移占用的是待插入元素的原本位置。
            //      3、当待插入元素大于有序元素时，说明待插入元素应该插在该有序元素的后面
            //      4、当待插入元素小于所有有序元素时，insertIndex会减小至-1，也会推出循环，
            //即应该在下标为-1的元素后面插入，也就是下标为0的位置
            //      5、当待插入元素大于所有有序元素时，不会进入循环，insertIndex仍然指向有序部分最后一个元素，
            //即应该在有序部分最后一个元素之后插入，因为待插入元素原本就在这个位置所以不
            //用做任何操作，直接开始下一轮
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //判断是否条件5，如果不满足，才执行插入
            if (insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }


    }
}
