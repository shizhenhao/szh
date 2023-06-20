package cn.szh.java.basic.interview;

import java.util.HashSet;

/**
 * 2021/4月 去的合肥佳通轮胎现场笔试题
 *
 * @author Zhenhao.Shi
 * @date 2022/8/3 17:13
 */
public class JiaTongLunTai {
    String str = "good";
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < 100; i++) {
            hashSet.add(i);
            hashSet.remove(i - 1);
        }
        System.out.println(hashSet.size());

        JiaTongLunTai lunTai = new JiaTongLunTai();
        lunTai.gg(lunTai.str, lunTai.ch);
        System.out.print(lunTai.str + " and ");
        System.out.print(lunTai.ch);
    }

    private void gg(String str, char[] cha) {
        str = "Test";
        cha[0] = 'g';
    }

}
