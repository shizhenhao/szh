package cn.szh.szh.T;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/7 11:44
 */
public class Method {

    public static void main(String[] args) {
        String s = "null";
        int i = Integer.parseInt(s);
        System.out.println(i);

        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n", 3, 4, 5, maximum(3, 4, 5));
        Integer maximum = maximum(3, 4, 5);
        System.out.println(maximum);

        Double maximum2 = maximum(6.6, 8.8, 7.7);
        System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n", 6.6, 8.8, 7.7, maximum2);
        maximum(6.6, 8.8, 7.7);

        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));

        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        name.add("icon");
        age.add(18);
        number.add(314);
        getData(name);
        getData(age);
        getData(number);
    }

    public static <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static <E extends Comparable<E>, T> E maximum(E x, E y, E z) {
        E max = x; // 假设x是初始最大值
        if (y.compareTo(max) > 0) {
            max = y; // y 更大
        }
        if (z.compareTo(max) > 0) {
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    public static <E> void getData(List<E> data) {
        System.out.println("data :" + data.get(0));
    }

}
