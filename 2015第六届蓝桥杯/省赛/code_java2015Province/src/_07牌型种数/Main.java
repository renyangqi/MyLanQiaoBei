package _07牌型种数;

/**
 * A-K :13
 * A=0      /   A=1 /
 * 2-K:13   2-K:12
 */
public class Main {
    static int answer = 0;

    //3598180
    public static void main(String[] args) {
        int x = 1;
        int cnt = 13;
        // 从A开始 从A-K中抽取13张牌
        dfs(x, cnt);
        System.out.println(answer);
    }

    private static void dfs(int x, int cnt) {
        if (cnt == 0) {
            answer++;
            return;
        }
        if (cnt < 0 || x > 13) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            //点数为x的拍 取i张
            // 则从 x+1 到 K 取 cnt-i张
            dfs(x + 1, cnt - i);
        }

    }
}
