package _07剪邮票;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main2 {
    //右下左上的偏移
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //染色的格子数
    static int num = 1;
    //多少种情况
    static LinkedHashSet set = new LinkedHashSet();

    public static void main(String[] args) {
        int[][] visited = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    num = 1;
                    dfs(i, j, visited);
                    visited[i][j] = 0;

                }
            }
        }

        for (Object o : set) {
            String x = (String) o;
            System.out.println(x);
        }
        System.out.println(set.size());
    }

    private static void dfs(int x, int y, int[][] visited) {
        if (num == 3) {

            fillOne(visited);
            return;
        }

        for (int k = 0; k < dir.length; k++) {
            int newx = dir[k][0] + x;
            int newy = dir[k][1] + y;
            if (inArea(newx, newy) && visited[newx][newy] == 0) {
                num++;
                visited[newx][newy] = 1;
                dfs(newx, newy, visited);
                visited[newx][newy] = 0;
                num--;
            }
        }

    }

    private static void fillOne(int[][] visited) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    fillTwo(visited);
                    visited[i][j] = 0;
                }
            }
        }
    }

    private static void fillTwo(int[][] visited) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    if (check(visited) == true) {
                        set.add(toString(visited));
                    }
                    visited[i][j] = 0;
                }
            }
        }
    }

    private static boolean check(int[][] visited) {
        int cnt = 0;
        int[][] clone = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                clone[i][j] = visited[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (clone[i][j] == 1) {
                    calculateBlock(clone, i, j);
                    cnt++;
                }
            }
        }
        return cnt == 1;
    }

    private static void calculateBlock(int[][] clone, int i, int j) {
        clone[i][j] = 0;
        if (i - 1 >= 0 && clone[i - 1][j] == 1) {
            calculateBlock(clone, i - 1, j);
        }
        if (i + 1 <= 2 && clone[i + 1][j] == 1) {
            calculateBlock(clone, i + 1, j);
        }
        if (j - 1 >= 0 && clone[i][j - 1] == 1) {
            calculateBlock(clone, i, j - 1);
        }
        if (j + 1 <= 3 && clone[i][j + 1] == 1) {
            calculateBlock(clone, i, j + 1);
        }
    }

    private static String toString(int[][] visited) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                str = str + visited[i][j];
            }
            str = str + "\n";
        }
        return str;
    }

    private static boolean inArea(int x, int y) {
        return (x >= 0 && x < 3) && (y >= 0 && y < 4);
    }
}