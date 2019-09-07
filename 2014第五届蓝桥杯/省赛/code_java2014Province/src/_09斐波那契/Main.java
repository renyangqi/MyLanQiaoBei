package _09斐波那契;

import java.math.BigInteger;
//1.由定义fib(n) = fib(n+2)-fib(n+1)
//2.由1得Σf(n) = f(n+2)-1;

//如果 m>=n+2那么f(m)>Σf(n)，结果是(f(n+2)-1)%p
//否则 结果为(f(n+2)-1)%f(m)%p
public class Main {
    static int count = 0;

    public static void main(String[] args) {

       /* Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long p = sc.nextLong();
        if (m >= n + 2) {
            // (f(n+2)-1)%p
            //f(n+2) = 1 1  乘  1 1 的n次幂
            //         0 0     1 0

            BigInteger fibNADD2 = fib(n + 2);
            System.out.println(fibNADD2.subtract(new BigInteger("1")).mod(new BigInteger(p + "")).toString());

        } else {
            //(f(n+2)-1)%f(m)%p
            BigInteger fibNADD2 = fib(n + 2);
            BigInteger fibm = fib(m);
            System.out.println(fibNADD2.subtract(new BigInteger("1")).mod(fibm).mod(new BigInteger(p + "")).toString());
        }*/
        long n =4;
        BigInteger fibm = fib(n);
        System.out.println(fibm.toString());
        System.out.println("\n count = "+count);



    }

    private static BigInteger fib(long n) {
        BigInteger[][] A = GetA();
        BigInteger[][] B = GetB();
        if (n == 1 || n == 2) {
            return new BigInteger("1");
        }
        BigInteger[][] res;
        BigInteger[][] pow = pow(B, n - 2);
        res = mul(A, pow);
        return res[0][0];
    }

    private static BigInteger[][] mul(BigInteger[][] A, BigInteger[][] B) {
        BigInteger[][] ret = GetZero();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    BigInteger multiply = A[i][k].multiply(B[k][j]);
                    ret[i][j] = ret[i][j].add(multiply);
                }
            }
        }
        return ret;
    }

    private static BigInteger[][] pow(BigInteger[][] A, long n) {
        count++;
        if (n == 1) {
            return A;
        }
        BigInteger[][] res;
        BigInteger[][] x = pow(A, n / 2);
        res = mul(x, x);
        if (n % 2 == 1) {
            res = mul(res, A);
        }
        return res;
    }


    private static BigInteger[][] GetA() {
        BigInteger[][] A = new BigInteger[][]{
                {
                        BigInteger.ONE, BigInteger.ONE
                },
                {
                        BigInteger.ZERO, BigInteger.ZERO
                }
        };

        return A;
    }

    private static BigInteger[][] GetB() {
        BigInteger[][] B = new BigInteger[][]{
                {
                        BigInteger.ONE, BigInteger.ONE
                },
                {
                        BigInteger.ONE, BigInteger.ZERO
                }
        };
        return B;
    }

    private static BigInteger[][] GetZero() {
        BigInteger[][] B = new BigInteger[][]{
                {
                        BigInteger.ZERO, BigInteger.ZERO
                },
                {
                        BigInteger.ZERO, BigInteger.ZERO
                }
        };
        return B;
    }
}
/**
 * 1  1      1  1
 * 1  0      1  0
 */