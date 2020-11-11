package algorithm10;

/**
 * @author zyh
 * @create 2019-09-23 17:21
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }


    public static void hanoiTower(int num,char a,char b,char c){
        if (num == 1){
            System.out.println(a+ " -> " + c);
        }else {
            hanoiTower(num-1,a,c,b);
            System.out.println(a + " -> " + c);
            hanoiTower(num-1,b,a,c);
        }
    }
}
