package search;

/**
 * @author zyh
 * @create 2019-09-19 14:34
 */
public class InsetValueSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int search = insertValueSearch(arr, 1000);
        System.out.println(search);
    }

    public static int insertValueSearch(int[] arr,int findVal){
        return insertValueSearch(arr,0,arr.length - 1,findVal);
    }

    private static int insertValueSearch(int[] arr,int left,int right,int findVal){
        //当左指针大于右指针或者查找的数字越界时返回-1
        if (left >right || findVal < arr[0] || findVal > arr[arr.length -1]){
            return -1;
        }
        //自适应的mid值
        int mid = left + (right + left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        //递归
        if (findVal > midVal){
            return  insertValueSearch(arr,mid + 1,right,findVal);
        }else if (findVal > midVal){
            return insertValueSearch(arr,left,mid - 1 ,findVal);
        }else {
            return mid;
        }
    }
}
