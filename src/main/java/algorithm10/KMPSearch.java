package algorithm10;

/**
 * @author zyh
 * @create 2019-09-23 20:42
 */
public class KMPSearch {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int i = kmpSearch(str1, str2);
        System.out.println(i);
    }

    public static int kmpSearch(String str1,String str2){
        int[] next = kmpNext(str2);

        for (int i = 0,j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

    //得到字符串的部分匹配表
    private static int[] kmpNext(String dest){
        //创建一个存放每个字符的匹配表的值
        int[] next = new int[dest.length()];
        //第一个字符的匹配值为0
        next[0] = 0;
        for (int i = 1,j = 0; i < dest.length(); i++) {
            //核心算法
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            //如果
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
