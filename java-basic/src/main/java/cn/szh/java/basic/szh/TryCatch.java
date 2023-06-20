package cn.szh.java.basic.szh;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/3 17:20
 */
public class TryCatch {

    public static void main(String[] args) {
        int test1 = test1();
        // 当try中带有return时，会先执行return前的代码，然后暂时保存需要return的信息，再执行finally中的代码，最后再通过return返回之前保存的信息
        // 若try中没有return，返回finally中操作后的结果
        System.out.println(test1);

        List<Integer> test2 = test2();
        // list里存的不是变量本身，而是变量的地址，所以当finally通过地址改变了变量，还是会影响方法返回值的
        System.out.println(test2);

        int test3 = test3();
        System.out.println(test3);
    }

    private static int test1() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }

    private static List<Integer> test2() {
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            list.add(2);
            System.out.println("catch:" + list);
        } finally {
            list.add(3);
            System.out.println("finally:" + list);
        }
        return list;
    }

    private static int test3() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i / 0;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
    }

}
