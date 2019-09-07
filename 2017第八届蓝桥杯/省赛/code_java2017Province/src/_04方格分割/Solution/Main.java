package _04方格分割.Solution;

//答案509
public class Main {
    //上右下左偏移量
    static int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] visited = new int[7][7];
    static int answer = 0;

    public static void main(String[] args) {
        init(visited);
        dfs(3, 3);
        System.out.println(answer / 4);
    }

    private static void dfs(int x, int y) {
        if (x == 0 || y == 0 || x == 6 || y == 6) {
            answer++;
            return;
        }
        visited[x][y] = 1;
        visited[6 - x][6 - y] = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (x < 0 || x > 6 || y < 0 || y > 6) {
                continue;
            }
            if (visited[nextX][nextY] == 0) {
                dfs(nextX, nextY);
            }

        }
        //在一个点的上右下左四个方向都访问过后 再回溯
        visited[x][y] = 0;
        visited[6 - x][6 - y] = 0;
    }

    public static void init(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                x[i][j] = 0;
            }
        }
    }
}
