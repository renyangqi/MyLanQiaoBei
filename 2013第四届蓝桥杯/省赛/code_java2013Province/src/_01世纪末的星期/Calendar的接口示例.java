package _01世纪末的星期;

import java.util.Calendar;

public class Calendar的接口示例 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        //设置1999:12:31方式一
        calendar.set(1999, 11, 31);
        //设置1999:12:31方式二
        calendar.set(Calendar.YEAR, 1999);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        //weekday = 1星期天 weekday = 2 星期一 一词类推
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        weekday = init(weekday);
        //注意1999:12:31 是星期5
        System.out.println(year + ":" + month + ":" + day + "星期" + weekday);
        for (int i = 0; i < 100; i++) {
            calendar.add(Calendar.DATE, 1);
            int year2 = calendar.get(Calendar.YEAR);
            int month2 = calendar.get(Calendar.MONTH) + 1;
            int day2 = calendar.get(Calendar.DATE);
            int weekday2 = calendar.get(Calendar.DAY_OF_WEEK);
            weekday2 = init(weekday2);
            System.out.println(year2 + ":" + month2 + ":" + day2 + "星期" + weekday2);
        }
    }

    private static int init(int weekday) {
        weekday = weekday - 1;
        if (weekday == 0) {
            weekday = 7;
        }
        return weekday;
    }
}
