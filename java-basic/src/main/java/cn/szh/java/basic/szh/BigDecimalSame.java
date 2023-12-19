package cn.szh.java.basic.szh;

import java.math.BigDecimal;

/**
 * @author Zhenhao.Shi
 * @date 2023/10/25 16:13
 */
public class BigDecimalSame {

    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("10");
        BigDecimal bd2 = new BigDecimal("4");
        BigDecimal[] dividedAndRemainder = bd1.divideAndRemainder(bd2);
        System.out.println(dividedAndRemainder[0]);
        System.out.println(dividedAndRemainder[1]);
    }

}
