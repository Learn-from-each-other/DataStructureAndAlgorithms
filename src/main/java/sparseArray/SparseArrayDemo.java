package sparseArray;

/**
 * @author zyh
 * @create 2019-09-09 13:50
 * 稀疏数组
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        //创建10*10的二维数组
        int Arr[][] = new int[10][10];
        Arr[1][2] = 1;
        Arr[4][5] = 8;
        Arr[9][3] = 2;
        //输出数组并得到非0元素个数sum
        int sum = 0;
        System.out.println("原数组：");
        for (int i = 0; i < Arr.length; i++) {
            int[] ints = Arr[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                System.out.printf("%d\t",anInt);
                if (anInt != 0){
                    sum++;
                }
            }
            System.out.println();
        }

        //创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //添加第一行元素
        sparseArr[0][0] = 10;
        sparseArr[0][1] = 10;
        sparseArr[0][2] = sum;

        //存放非0数组
        int count = 0;
        for (int i = 0; i < Arr.length; i++) {
            int[] ints = Arr[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt  != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = anInt;
                }
            }
        }

        //输出稀疏数组
        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            int[] ints = sparseArr[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        //解析稀疏数组
        int[][] Arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历除第一行的稀疏数组
        for (int i = 1; i < sparseArr.length; i++) {
            Arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出恢复数组
        System.out.println("恢复数组：");
        for (int i = 0; i < Arr2.length; i++) {
            int[] ints = Arr2[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

    }
}
