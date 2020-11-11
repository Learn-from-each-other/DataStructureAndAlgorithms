package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyh
 * @create 2019-09-17 17:12
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int i = binarySearch(arr, 0, arr.length - 1, 1000);
        List<Integer> list = binarySearchAll(arr, 0, arr.length - 1, 1000);
        System.out.println(i);
        System.out.println(list);
    }

    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left >right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal){
            return binarySearch(arr,mid + 1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid - 1,findVal);
        }else {
            return mid;
        }
    }

    public static List<Integer> binarySearchAll(int[] arr,int left,int right,int findVal){
        if (left > right){
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal){
            return binarySearchAll(arr,mid + 1,right,findVal);
        }else if (findVal < midVal){
            return binarySearchAll(arr,left,mid - 1,findVal);
        }else {
            List<Integer> res = new ArrayList<>();

            int temp = mid - 1;

            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                res.add(temp);
                temp -= 1;
            }
            res.add(mid);


            temp = mid + 1;

            while (true){
                if (temp > arr.length -1 || arr[temp] != findVal){
                    break;
                }
                res.add(temp);
                temp += 1;
            }
            return res;
        }
    }
}
