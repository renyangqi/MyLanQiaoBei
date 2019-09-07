package _07正则问题.Solution;

import java.util.Scanner;

public class Main {
    static int answer;
    static int length;
    static int pos = 0;
    static String str = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        length = str.length();
        answer = recursion();
        System.out.println(answer);
    }

    /**
     * 求出当前字符串,自当前下标到结束能匹配的字符串长度
     */
    private static int recursion() {
        int max = 0;
        int tmp = 0;
        while (pos < length) {
            if (str.charAt(pos) == '(') {
                pos++;
                tmp += recursion();
            } else if (str.charAt(pos) == 'x') {
                pos++;
                tmp++;
            } else if (str.charAt(pos) == '|') {
                pos++;
                max = Math.max(max, tmp);
                tmp = 0;
            } else if (str.charAt(pos) == ')') {
                pos++;
                max = Math.max(max, tmp);
                return max;
            }

        }

        max = Math.max(max, tmp);
        return max;
    }
}
