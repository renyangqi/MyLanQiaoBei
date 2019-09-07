package _05抽签;

public class Main {
    // 国家有0号-5号国家 ABCDEF
    // a[k]...a[5]的这几个国家派出剩下为n个名额的人 组成一个安排组合s
    public static void f(int[] a, int k, int n, String s) {
        //如果所有国家都考虑完了并且 人满了（剩余0个名额） 那就打印这种组合 比如 DEFFF
        if (k == a.length) {
            if (n == 0) System.out.println(s);
            return;
        }

        String s2 = s;
        for (int i = 0; i <= a[k]; i++) {
            // 前k个国家已经派出了人，则剩下的第k+1到第5国派出剩余的人数
            f(a, k + 1, n - i, s2);
            s2 += (char) (k + 'A');
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 1, 1, 3};

        f(a, 0, 5, "");
    }
}

