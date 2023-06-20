package cn.szh.java.basic.suanfa;

/**
 * 利息计算
 *
 * @author Zhenhao.Shi
 * @date 2023/2/6 16:30
 */
public class Loan {

    public static void main(String[] args) {
        //年利率
        yearRate(1.0, 3.0, 1);
        //年利率-每月等额本息还款
        monthRate(1.0, 3.0, 1);
    }

    private static void yearRate(Double principal, Double rate, Integer year) {
        System.out.println("本金（w）：" + principal);
        System.out.println("年利率：" + rate);
        System.out.println("年限：" + year);

        double interest = principal * rate / 100 * year;
        double sum = interest + principal;
        System.out.println("总额（w）：" + sum);
        System.out.println("利息：" + interest);
        System.out.println("等额本息月供：" + sum / 12);
    }

    private static void monthRate(Double principal, Double rate, Integer year) {
        System.out.println();
        System.out.println("本金（w）：" + principal);
        System.out.println("年利率：" + rate);
        System.out.println("年限：" + year);
        rate = rate / 100;

        double month = 0;
        //第一个月利息
        double first = principal * rate / 12;

        //第二个月利息
        double second = (principal + first - month) * rate / 12;

        //第三个月利息
        double third = (principal + first + second - 2 * month) * rate / 12;

        //第四个月利息
        double four = (principal + first + second + third - 3 * month) * rate / 12;

        month = (principal + first + second + third + four) / 4;

        double interest = 1.0;
        double sum = interest + principal;
        System.out.println("总额（w）：" + sum);
        System.out.println("利息：" + interest);
        System.out.println("等额本息月供：" + sum / 12);
    }

}
