package _03梅森素数;

import java.math.BigInteger;

public class Main {
    BigInteger x = BigInteger.valueOf(2).pow(11213).subtract(BigInteger.ONE);
    public static void main(String[] args) {
        BigInteger res = new BigInteger("1");
        for (int i = 1; i <= 11213; i++) {
            res = res.multiply(new BigInteger("2"));
        }
        String str = res.subtract(new BigInteger("1")).toString();
        String ans = str.substring(str.length() - 100, str.length());
        System.out.println("后" + ans.length() + "位:" + ans);
    }
}
