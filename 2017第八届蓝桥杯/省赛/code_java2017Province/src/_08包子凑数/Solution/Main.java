package _08包子凑数.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int sum = 0;
    static int[] memo;

    public static void main(String[] args) {
  /*      Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        memo = new int[101];
        Arrays.fill(memo, -1);
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }*/

        memo = new int[10000];
        Arrays.fill(memo, -1);
        int N = 2;
        int[] A = new int[]{4, 5};
        int Commonfactor = -1;
        if (A.length >= 1) {
            Commonfactor = A[0];
        }
        for (int i = 1; i < A.length; i++) {
            Commonfactor = getCommonfactor(Commonfactor, A[i]);
        }
        if (Commonfactor != 1) {
            System.out.println("INF");
            return;
        }



        for (int i = 1; i <= 100; i++) {
            solution(N, A, i);
        }
        for (int i = 1; i <= 100; i++) {
            if (memo[i] != 1) {
                sum++;
                System.out.print(i + " ");
            }
        }

        System.out.println("\n" + sum);
    }

    private static int getCommonfactor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getCommonfactor(b, a % b);
    }

    //求 A[0,N-1] 的元素中能否拼凑出 x
    private static boolean solution(int N, int[] A, int x) {
        if (x == 0) {
            memo[x] = 1;
            return true;
        }
        if (x < 0) {
            return false;
        }

        if (memo[x] != -1) {
            return memo[x] == 1;
        }

        boolean ret = false;
        for (int i = 0; i < N; i++) {
            ret = ret || solution(N, A, x - A[i]);
            if (ret == true) {
                break;
            }
        }
        memo[x] = ret == true ? 1 : 0;
        return ret;
    }
}
