package _08包子凑数.Solution2;

import java.util.Arrays;

public class Main {
    static int sum = 0;
    static int[] memo;

    private static int getCommonfactor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getCommonfactor(b, a % b);
    }

    public static void main(String[] args) {
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


        memo[0] = 1;
        for (int i = 0; i < A.length; i++) {
            memo[A[i]] = 1;
            for (int j = 0; j < 10000; j++) {
                if (memo[j] == 1) {
                    if (j + A[i] < 10000) {
                        memo[j + A[i]] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < 10000; i++) {
            if (memo[i] != 1) {
                sum++;
                System.out.print(i + " ");
            }
        }
    }
}
