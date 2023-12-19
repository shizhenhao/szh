package cn.szh.java.basic.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/7 11:40
 */
public class Test {
    static Integer ii;
    static String ff;
    static String gg;

    public static void main(String[] args) {
        String strr = null;
        if (strr == null) {
            System.out.println("str为null");
        }

        int b = 3;
        int a = b;
        b = 5;
        System.out.println(a);// 测试a的值
        System.out.println(b);

        System.out.println(ii);
        // Integer iii= 0*null;
        // Integer iiii= ii+0;
        Integer i = 123;
        gg(i);
        if (i.equals(123)) {
            System.out.println(1111);
        }
        if (i == 123) {
            System.out.println(2222);
        }
        if (123 == i) {
            System.out.println(333);
        }
        Integer j = null;
        // if (123 == j)
        // System.out.println(4444);
        String s = "123";
        ss(s);
        if (s.equals(i)) {
            System.out.println(555); // String与Integer是false的
        }
        String str = "131A-1";
        String str2 = "131a-1";
        if (str.equals(str2)) {
            System.out.println(6666);
        }
        int jj = 1000000000;
        System.out.println(jj);

        // String s = "1";
        // Integer i = 1;
        // boolean a = s.equals(i);
        // System.out.println(a);
        // String msg = "0000000000057A03020001";
        // boolean b = msg.charAt(msg.length() - 1) == '1';
        // System.out.println(b);
        // Integer detailSeq = null;
        // Integer combinedDetailSeq = 3;
        // // if (detailSeq > combinedDetailSeq) {
        // // System.out.println(111);
        // // }
        //
        // List<String> list = new ArrayList<>();
        // list.add("1");
        // list.add("2");
        // list.add("3");

        // 结合这个 null "" 还有一个 什么来 //CsyTaskexeDealModule 中的if
        // (AppTool.isNull(flag) || !flag) {
        // 和new的关系。

    }

    private static void ss(Object s) {
        String ss = s.toString();
        System.out.println(ss);
    }

    private static void gg(Object i) {
        Object ss = i;
        Object sss = i.toString();
        Object ssss = "" + i;
        System.out.println(ss);
        System.out.println(sss);
        if (ss.equals(sss)) {
            System.out.println("我爱");
        }
        if (sss.equals(ssss)) {
            System.out.println("java");
        }

        List<String> list = new ArrayList<>();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("shizhenhao改动 ");
        System.out.println(ff);
        if (null == ii) {
            System.out.println("asfag");
        }
    }

}
