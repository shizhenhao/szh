package cn.szh.java.basic.szh;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/20 10:52
 */
public class DateAndTime {

    public static void main(String[] args) {
        LocalDateTime localDateTime2 = LocalDateTime.now();
        LocalDateTime localDateTime3 = LocalDateTime.now();
        if (Objects.equals(localDateTime2, localDateTime3)) {
            System.out.println("localDateTime相等");
        }

        //当天开始时间
        LocalDateTime localDateTime1 = LocalDate.now().atStartOfDay();
        System.out.println(localDateTime1);
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
        System.out.println(LocalDateTime.now().withHour(23).withMinute(59).withSecond(59));
        System.out.println(localDateTime1.plusDays(1).minusSeconds(1));


        System.out.println("now:");
        System.out.println(new Date());
        System.out.println(LocalDate.now());
        System.out.println(localDateTime2);
        System.out.println(LocalTime.now());

        System.out.println("\nString型转换:");
        System.out.println(LocalDateTime.parse(LocalDate.now() + "T08:00"));
        //与上面输出结果相同
        System.out.println(LocalDateTime.parse(LocalDate.now() + "T08:00:00"));

        LocalDate localDate = LocalDate.parse("2023/10/18", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(localDate);

        LocalTime parse = LocalTime.parse("10:30");
        System.out.println(parse);

        LocalTime now = LocalTime.now();
        LocalTime localTime = LocalTime.of(now.getHour(), 10);
        System.out.println(localTime);


        double t = 61 / 60.0;
        System.out.println(t);
        System.out.println((int) Math.ceil(t));

        LocalDateTime now2 = localDateTime2;
        LocalDateTime localDateTime = now2.minusMinutes(10);
        System.out.println(now2);
        System.out.println(localDateTime);
        if (now2.compareTo(now2) == 0) {
            System.out.println(3333);
        }


        //相差时分
        LocalDateTime now3 = localDateTime2;
        LocalDateTime now4 = localDateTime2.plusMinutes(52);
        Duration between = Duration.between(now3, now4);
        System.out.println(between.toHours());
        System.out.println(between.toMinutes());
    }

}
