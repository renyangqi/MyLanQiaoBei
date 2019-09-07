package _01世纪末的星期;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        for (int i = 19; i <= 99; i++) {
            int yearSet = i * 100 + 99;
            calendar.set(yearSet, 11, 31);
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            if (weekday == Calendar.SUNDAY) {
                System.out.println(yearSet);
                break;
            }
        }

    }
}
