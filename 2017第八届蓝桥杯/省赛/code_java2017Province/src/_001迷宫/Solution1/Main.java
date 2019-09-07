package _001迷宫.Solution1;

public class Main {
    //注意 我代码的结果也是正确的 但是我少考虑了环的问题 因为更正确的方法应该是深度优先遍历加标记
    public static void main(String[] args) {
        char[][] maze = {
                {'U', 'D', 'D', 'L', 'U', 'U', 'L', 'R', 'U', 'L'},
                {'U', 'U', 'R', 'L', 'L', 'L', 'R', 'R', 'R', 'U'},
                {'R', 'R', 'U', 'U', 'R', 'L', 'D', 'L', 'R', 'D'},
                {'R', 'U', 'D', 'D', 'D', 'D', 'U', 'U', 'U', 'U'},
                {'U', 'R', 'U', 'D', 'L', 'L', 'R', 'R', 'U', 'U'},
                {'D', 'U', 'R', 'L', 'R', 'L', 'D', 'L', 'R', 'L'},
                {'U', 'L', 'L', 'U', 'R', 'L', 'L', 'R', 'D', 'U'},
                {'R', 'D', 'L', 'U', 'L', 'L', 'R', 'D', 'D', 'D'},
                {'U', 'U', 'D', 'D', 'U', 'D', 'U', 'D', 'L', 'L'},
                {'U', 'L', 'R', 'D', 'L', 'U', 'U', 'R', 'R', 'R'}
        };
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int localX = i;
                int localY = j;
                boolean endwhile = false;

                while (((0 <= localX && localX <=9) || (0 <= localY && localY <= 9)) && endwhile != true) {
                    char c1 = maze[localX][localY];
                    switch (c1) {
                        case 'U':
                            if (localX - 1 == -1) {
                                sum++;
                                endwhile = true;
                                break;
                            } else if (maze[localX - 1][localY] == 'D') {
                                endwhile = true;
                                break;
                            } else {
                                localX = localX - 1;
                            }
                            break;
                        case 'D':
                            if (localX + 1 == 10) {
                                endwhile = true;
                                sum++;
                                break;
                            } else if (maze[localX + 1][localY] == 'U') {
                                endwhile = true;
                                break;
                            } else {
                                localX = localX + 1;
                            }
                            break;
                        case 'L':
                            if (j - 1 == -1) {
                                endwhile = true;
                                sum++;
                                break;
                            } else if (maze[localX][localY -1] == 'R') {
                                endwhile = true;
                                break;
                            } else {
                                localY = localY - 1;
                            }
                            break;
                        case 'R':
                            if (localY + 1 == 10) {
                                endwhile = true;
                                sum++;
                                break;
                            } else if (maze[localX][localY + 1] == 'L') {
                                endwhile = true;
                                break;
                            } else {
                                localY = localY + 1;
                            }
                            break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
