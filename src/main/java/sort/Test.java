package sort;

/**
 * @author zyh
 * @create 2020-02-18 18:10
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1,5,8,2,4,7};
        find(arr);
    }


    public static void find(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] + arr[j] == 9){
                    System.out.println("[" + arr[i] + "," + arr[j] + "]");
                }
            }
        }
    }
}
