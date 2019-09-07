package _04循环节长度;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        int x = f(11, 13);
        //int x = f(7, 18);
        System.out.println(x);
    }

    public static int f(int n, int m) {
        n = n % m;
        Vector v = new Vector();

        for (; ; ) {
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) return 0;
            if (v.indexOf(n) >= 0)
                return v.size() - v.indexOf(n);  //填空
        }
    }
}
