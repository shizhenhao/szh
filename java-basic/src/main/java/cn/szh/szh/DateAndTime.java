package cn.szh.szh;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/20 10:52
 */
public class DateAndTime {

    public static void main(String[] args) {
        //当天开始时间
        LocalDateTime localDateTime1 = LocalDate.now().atStartOfDay();
        System.out.println(localDateTime1);
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));


        System.out.println("now:");
        System.out.println(new Date());
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());

        System.out.println("\nString型转换:");
        System.out.println(LocalDateTime.parse(LocalDate.now() + "T08:00"));
        //与上面输出结果相同
        System.out.println(LocalDateTime.parse(LocalDate.now() + "T08:00:00"));

        LocalTime parse = LocalTime.parse("10:30");
        System.out.println(parse);

        LocalTime now = LocalTime.now();
        LocalTime localTime = LocalTime.of(now.getHour(), 10);
        System.out.println(localTime);


        double t = 61 / 60.0;
        System.out.println(t);
        System.out.println((int) Math.ceil(t));

        LocalDateTime now2 = LocalDateTime.now();
        LocalDateTime localDateTime = now2.minusMinutes(10);
        System.out.println(now2);
        System.out.println(localDateTime);
        if (now2.compareTo(now2) == 0) {
            System.out.println(3333);
        }


        //相差时分
        LocalDateTime now3 = LocalDateTime.now();
        LocalDateTime now4 = LocalDateTime.now().plusMinutes(52);
        Duration between = Duration.between(now3, now4);
        System.out.println(between.toHours());
        System.out.println(between.toMinutes());
    }

}
