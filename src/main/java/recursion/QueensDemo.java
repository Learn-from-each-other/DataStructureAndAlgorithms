package recursion;

/**
 * @author zyh
 * @create 2019-09-12 16:40
 * N皇后问题
 */
public class QueensDemo {
    public static void main(String[] args) {
        Queens queens = new Queens(8);
        queens.check();
    }
}

class Queens{
    private int max;
    private int[] array;
    private int count;
    private int jundgeCount;

    public Queens(int max) {
        this.max = max;
        this.array = new int[max];
    }

    public void check(){
        check(0);
    }

    private void check(int n){
        if (n ==max){
            print();
            return;
        }
        for (int i = 0;i < max ;i++){
            array[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        jundgeCount++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        System.out.println(count);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
