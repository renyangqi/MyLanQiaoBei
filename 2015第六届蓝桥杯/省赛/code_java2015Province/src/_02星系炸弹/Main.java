package _02星系炸弹;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 10, 9);
        calendar.add(Calendar.DATE, 1000);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String yearStr = year + "";
        String monthStr = month + 1 + "";
        String dayStr = day + "";

        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }
        if (dayStr.length() == 1) {
            dayStr = "0" + dayStr;
        }


        System.out.println(yearStr + "-" + monthStr + "-" + dayStr);
    }
}
