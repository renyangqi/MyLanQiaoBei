package _08取球博弈;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 注意memo这样开空间 不满足空间复杂度要求
 * 改良版代码参见Main2
 */
public class Main {

    /**
     * 如果对方存在能输的情况 那就我就赢了 +
     * 如果对方不会输这种情况下如果能逼平 那就是平局 0
     * 如果对方不会输也无法逼平 那就是我输了 -
     */
    static int[] arr = new int[3];
    static int[] num = new int[5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 每次可以取n1,n2,n3

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }
        for (int i = 0; i < num.length; i++) {
            // 得到在我先取球的情况下 能否在局面为：球的数量为num 我目前手上有0个球 对手手上有0个球 的局面下赢得胜利
            //返回最终结果的字符
            Character c = recursion(num[i], 0, 0);
            System.out.print(c + " ");
        }
    }

    // 递归树 me 和 you 要交换 you返回输 则你就应该返回赢了
    //递归函数的语义:能否在局面为：球的数量为num 我目前手上有me个球 对手手上有you个球 的局面下赢得胜利
    private static Character recursion(int num, int me, int you) {
        //递归终止条件 因为对arr排过序了 所以如果剩下的球的数量少于arr[0]
        //则递归终止
        if (num < arr[0]) {
            //如果我是奇数对方是偶数那就是我赢了
            if ((me & 1) == 1 && (you & 1) == 0) {
                return '+';
            } else if ((me & 1) == 0 && (you & 1) == 1) {
                return '-';
            } else {
                return '0';
            }
        }
        //平局判断
        boolean ping = false;
        for (int i = 0; i < arr.length; i++) {
            if (num >= arr[i]) {
                // 此时 me 拿到了me+arr[i]个球 因此下次递归的时候 应该是总数为num-arr[i]
                // 而下次递归考虑的是对手是如何去取球，对手此时是0个球 而我已经拿到了arr[i]个球
                // 因此 下一层的递归应该是 我拿了0个球对手拿了arr[i]个球的情况下我能否在这种局面下获胜
                char c = recursion(num - arr[i], you, me + arr
                        [i]);
                //如果对方有一种情况输了 那我就能赢
                if (c == '-') {
                    return '+';
                }
                //如果对方在这一次存在平局 那么就先记录下来 只要其他方法对方是输的。我这一层(46-48行代码)依然返回'+'
                if (c == '0') {
                    ping = true;
                }
            }
        }
        // 如果来到这一行代码说明对方不会输,因此我们看看能不能把对方逼平
        if (ping) {
            return '0';
        } else {
            //否则 对方不会输也无法逼平那就是我输了
            return '-';
        }

    }
}
