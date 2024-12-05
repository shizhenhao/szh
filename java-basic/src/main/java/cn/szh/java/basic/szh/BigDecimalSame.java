package cn.szh.java.basic.szh;

import cn.hutool.core.collection.ListUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Zhenhao.Shi
 * @date 2023/10/25 16:13
 */
public class BigDecimalSame {

    public static void main(String[] args) {
        BigDecimal bigDec = new BigDecimal("0.0000");
        if(bigDec.compareTo(BigDecimal.ZERO) != 0){
            System.out.println("不等于");
        }


        BigDecimal bigDecimal = new BigDecimal("3000.00");
        System.out.println(bigDecimal);


        //保留小数
        BigDecimal bd12 = new BigDecimal("3");
        BigDecimal bd13 = new BigDecimal("3.0");
        BigDecimal add = bd12.add(bd13);
        System.out.println(add);
        System.out.println(bd12);
        List<BigDecimal> list2 = ListUtil.toList();
        list2.add(bd13);
        BigDecimal sumValueTotal = BigDecimal.ZERO;
        BigDecimal add1 = BigDecimal.ZERO;

        System.out.println(sumValueTotal);

        if (bd12.compareTo(bd13) == 0) {
            System.out.println("1212:" + bd12.negate());
        }

        System.out.println("12:" + bd12.negate());

        //保留小数
        BigDecimal bd11 = new BigDecimal("11.00");
        System.out.println(bd11);
        System.out.println(bd11.setScale(4, BigDecimal.ROUND_HALF_UP));


        BigDecimal bd10 = new BigDecimal("10");
        BigDecimal bd4 = new BigDecimal("4");
        BigDecimal[] dividedAndRemainder = bd10.divideAndRemainder(bd4);
        System.out.println(dividedAndRemainder[0]);
        System.out.println(dividedAndRemainder[1]);

        //乘
        BigDecimal multiply = bd10.multiply(bd4);
        System.out.println(multiply);
        //负数
        BigDecimal negate = multiply.negate();
        System.out.println(negate);
        //加负数
        System.out.println(multiply.add(negate));

        List<BigDecimal> list = ListUtil.toList();
        BigDecimal reduce = list.parallelStream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);


/*        BigDecimal bdc10 = new BigDecimal("2.0000");
        BigDecimal bdc6 = new BigDecimal("6.0000");*/
        //这里的2和2.0000，结果是不同的，一个是1，一个是0.3334，莫要因为试的是2以为向上取整了
        BigDecimal bdc10 = new BigDecimal("2");
        BigDecimal bdc6 = new BigDecimal("6");
        BigDecimal divide = bdc10.divide(bdc6, RoundingMode.UP);
        BigDecimal divide2 = bdc10.divideToIntegralValue(bdc6);
        System.out.println("divide:" + divide);
        System.out.println("divide2:" + divide2);
        System.out.println("divide.intValue:" + divide.intValue());


        BigDecimal divide4 = new BigDecimal("1280021.90000000").divide(new BigDecimal("5666531.05960000"), BigDecimal.ROUND_HALF_UP);
        System.out.println("divide4:" + divide4);

        BigDecimal bdc11 = new BigDecimal("2.4");
        System.out.println("divide11:" + bdc11.setScale(0, BigDecimal.ROUND_HALF_UP));
    }

}
