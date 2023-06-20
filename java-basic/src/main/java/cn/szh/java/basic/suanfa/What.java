package cn.szh.java.basic.suanfa;

import java.util.Arrays;

/**
 * 啥功能，整理下
 *
 * @author Zhenhao.Shi
 * @date 2022/8/3 15:10
 */
public class What {

    public static void main(String[] args) {
        int[] num = {1, 3, 4, 5, 6, 8, 9, 14, 20, 23, 31, 55, 99};
        int[] nearly = {100, 100, 100};
        int base = 15;
        int swap;
        for (int i = 0; i < num.length; i++) {
            int s = check(num[i], base);
            for (int j = 0; j < nearly.length; j++) {
                if (s < check(nearly[j], base)) {
                    swap = num[i];
                    num[i] = nearly[j];
                    nearly[j] = swap;
                }
            }
            System.out.println(Arrays.toString(nearly));
        }
    }

    static int check(int i, int j) {
        if (i > j) {
            return i - j;
        } else {
            return j - i;
        }
    }

}
