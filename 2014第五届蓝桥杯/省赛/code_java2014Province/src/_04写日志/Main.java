package _04写日志;

import sun.font.FontRunIterator;

/**
 * 标题：写日志
 * <p>
 * 写日志是程序的常见任务。现在要求在 t1.log, t2.log, t3.log 三个文件间轮流写入日志。
 * 也就是说第一次写入t1.log，第二次写入t2.log，... 第四次仍然写入t1.log，如此反复。
 * <p>
 * 下面的代码模拟了这种轮流写入不同日志文件的逻辑
 */
public class Main {

    private static int n = 1;

    public static void write(String msg) {
        String filename = "t" + n + ".log";
        n = n % 3 != 0 ? n + 1 : 1;
        System.out.println("write to file: " + filename + " " + msg);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            write("");
        }
    }

}
