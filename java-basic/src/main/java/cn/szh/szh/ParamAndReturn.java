package cn.szh.szh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/7 11:14
 */
public class ParamAndReturn {

    public static void main(String[] args) {
        int i = 3;
        List<Integer> list = new ArrayList();
        String s = "hello";
        Map<Integer, String> map = new HashMap<>();
        Integer ii = 4;
        map.put(1, "111");
        list.add(2);
        System.out.println(i);
        System.out.println(list);
        System.out.println(s);
        System.out.println(map);
        System.out.println(ii);
        System.out.println(ii.getClass());
        gg(i);
        hh(list);
        jj(s);
        kk(map);
        ii(ii);
        System.out.println(i);
        System.out.println(list);
        System.out.println(s);
        System.out.println(map);
        System.out.println(ii);
    }

    private static void ii(Integer ii) {
        ii = 5;
        System.out.println(ii.getClass());
    }

    private static void kk(Map<Integer, String> map) {
        map.put(2, "22222");
    }

    private static void jj(String s) {
        s = "helloll";
    }

    private static void hh(List<Integer> list) {
        list.add(4);
    }

    private static void gg(int i) {
        i = 7;
    }

}
