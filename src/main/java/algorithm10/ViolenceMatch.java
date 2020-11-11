package algorithm10;

/**
 * @author zyh
 * @create 2019-09-23 20:38
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int i = violenceMatch(str1, str2);
        System.out.println(i);
    }

    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1len = s1.length;
        int s2len = s2.length;

        int i = 0;
        int j = 0;
        while (i < s1len && j < s2len){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i = i - (j -1);
                j = 0;
            }
        }

        if (j == s2len){
            return i - j;
        }else {
            return -1;
        }
    }
}
