package cn.szh.java.basic.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/24 11:29
 */
public class szh {

    public static void main(String[] args) {
        String str = "2";
        Integer ii = 2;
        if(Objects.equals(str,ii)){
            System.out.println(222);
        }

        gg(3);

        boolean empty = StringUtils.isEmpty(" ");
        System.out.println(empty);

        if (!Objects.equals("", "bedNum")) {
            System.out.println("前者空");
        }
        if (!Objects.equals("bedNum", "")) {
            System.out.println("后者空");
        }
    }

    private static <T> void gg(T i) {

        System.out.println(i);
    }


}
