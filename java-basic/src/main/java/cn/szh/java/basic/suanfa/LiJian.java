package cn.szh.java.basic.suanfa;

/**
 * 寻找哪种费用组合用于报销
 *
 * @author Zhenhao.Shi
 * @date 2022/8/3 15:10
 */
public class LiJian {
    final static int ZERO = 0;
    final static int TWO = 2;

    public static void main(String[] args) {
        int fee = 2250;
        int[] feeList = {750, 230, 268, 385, 500, 311, 600, 113};
        int sum, higher = 10000;
        int one, two, three, four, five, six, seven, eight, i, j;

        //思路是没一个子项要还是不要，赋 0来计算是否不要
        for (int aa = 0; aa < TWO; aa++) {
            one = ZERO;
            if (aa == 1) {
                one = feeList[0];
            }
            for (int bb = 0; bb < TWO; bb++) {
                two = ZERO;
                if (bb == 1) {
                    two = feeList[1];
                }
                for (int cc = 0; cc < TWO; cc++) {
                    three = ZERO;
                    if (cc == 1) {
                        three = feeList[2];
                    }
                    for (int dd = 0; dd < TWO; dd++) {
                        four = ZERO;
                        if (dd == 1) {
                            four = feeList[3];
                        }
                        for (int ee = 0; ee < TWO; ee++) {
                            five = ZERO;
                            if (ee == 1) {
                                five = feeList[4];
                            }
                            for (int ff = 0; ff < TWO; ff++) {
                                six = ZERO;
                                if (ff == 1) {
                                    six = feeList[5];
                                }
                                for (int gg = 0; gg < TWO; gg++) {
                                    seven = ZERO;
                                    if (gg == 1) {
                                        seven = feeList[6];
                                    }
                                    for (int hh = 0; hh < TWO; hh++) {
                                        eight = ZERO;
                                        if (hh == 1) {
                                            eight = feeList[7];
                                        }

                                        sum = one + two + three + four + five + six + seven + eight;
                                        if (sum >= fee) {
                                            if (sum <= higher) {
                                                higher = sum;
                                                System.out.println(one + "+" + two + "+" + three + "+" + four + "+" + five
                                                        + "+" + six + "+" + seven + "+" + eight + "=" + sum);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
