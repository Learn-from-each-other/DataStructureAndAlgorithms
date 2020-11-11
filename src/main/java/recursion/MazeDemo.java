package recursion;

/**
 * @author zyh
 * @create 20"*"9*09*"*"2 "*"5:56
 * 迷宫
 */
public class MazeDemo {
    public static void main(String[] args) {
        String[][] maze = Maze.createMaze();

        System.out.println("地图：");
        for (int i = 0; i < maze.length; i++) {
            String[] ints = maze[i];
            for (int j = 0; j < ints.length; j++) {
                String anInt = ints[j];
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        Maze.findWay(maze,1,1);

        System.out.println("答案：");
        for (int i = 0; i < maze.length; i++) {
            String[] ints = maze[i];
            for (int j = 0; j < ints.length; j++) {
                String anInt = ints[j];
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

class Maze{


    public static String[][] createMaze(){
        String[][] map = new String[8][7];
        for (int i = 0; i < map.length; i++) {
            String[] strings = map[i];
            for (int j = 0; j < strings.length; j++) {
                strings[j] = " ";
            }
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = "*";
            map[i][6] = "*";
        }
        for (int i = 0; i < 7; i++) {
            map[0][i] = "*";
            map[7][i] = "*";
        }
        map[3][2] = "*";
        map[1][2] = "*";
        map[6][3] = "*";
        map[5][5] = "*";
        map[2][4] = "*";
        map[3][4] = "*";
        map[4][4] = "*";
        map[4][3] = "*";
        map[5][1] = "*";
        return map;
    }

    public static boolean findWay(String[][] map,int i,int j){
        if (map[6][5] == "@"){
            return true;
        }else {
            if (map[i][j] == " "){
                map[i][j] = "@";
                if (findWay(map,i-1,j)){
                    return true;
                }else if (findWay(map,i,j+1)){
                    return true;
                }else if (findWay(map,i+1,j)){
                    return true;
                }else if (findWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = "#";
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
