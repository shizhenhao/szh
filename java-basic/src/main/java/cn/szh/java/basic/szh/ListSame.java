package cn.szh.java.basic.szh;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/7 9:32
 */
public class ListSame {
    public static void main(String[] args) {
        //创建
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = Arrays.asList("a", "b", "c");
        List<String> list3 = ListUtil.toList();
        List<String> list4 = ListUtil.toList("1", "2");
        List<Integer> list6 = CollectionUtil.newArrayList(1, 2);


        //排序
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        ListA l1 = new ListA();
//        l1.setA(1);
        l1.setB("B1");

        if (l1.getA() == null) {
            System.out.println("ListA对象为null:" + l1.getA());
        }

        ListA l2 = new ListA();
        l2.setA(2);
        l2.setB("B2");

        List<ListA> aa = new ArrayList<>();
        aa.add(l1);
        aa.add(l2);
//		gg(aa);


        //检查数组是否包含某个值的方法
        //显然，使用一个简单的循环方法比使用任何集合都更加高效。许多开发人员为了方便，都使用第一种方法，但是他的效率也相对较低。
        //因为将数组压入Collection类型中，首先要将数组元素遍历一遍，然后再使用集合类做其他操作。
        String[] frequency_0 = {"guanchang", "qingjieguanchang", "huiyinchongxi"};
        String[] frequency_1 = {"qingmeisu(+)", "yaowuyangxing(+)"};
        if (Arrays.asList(frequency_0).contains("guanchan") || Arrays.asList(frequency_1).contains("guanchang")) {
            System.out.println(22222);
        }

        String[] arr = new String[]{"CD", "BC", "EF", "DE", "AB", "JK"};
        // use list
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useList(arr, "A");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("useList:" + duration / 1000000);
        // use set
        long startTime2 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useSet(arr, "A");
        }
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        System.out.println("useSet:" + duration / 1000000);
        // use loop
        long startTime3 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useLoop(arr, "A");
        }
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;
        System.out.println("useLoop:" + duration / 1000000);
        // use Arrays.binarySearch()
        long startTime4 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useArraysBinarySearch(arr, "A");
        }
        long endTime4 = System.nanoTime();
        long duration4 = endTime4 - startTime4;
        System.out.println("useArraysBinarySearch:" + duration / 1000000);
    }

    private static void gg(List<ListA> aa) {
        List<Object> l2 = new ArrayList<>();
        l2.add(aa.parallelStream().filter(item -> item.getA().equals(1)).collect(Collectors.toList()));
        List<Object> l3 = new ArrayList<>();
        l3.add(aa.parallelStream().filter(item -> item.getA().equals(1)).collect(Collectors.toList()));
        System.out.println(l2);

        Object ss = "3";
        ((ListA) l3.get(0)).setB("3");
        System.out.println(l2.toString());
        System.out.println(l3.toString());
    }

    /**
     * 使用List
     */
    private static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    /**
     * 使用Set
     */
    private static boolean useSet(String[] arr, String targetValue) {
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    /**
     * 使用循环判断
     */
    private static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找有序数组中是否包含某个值的用法
     */
    public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
        int a = Arrays.binarySearch(arr, targetValue);
        if (a > 0) {
            return true;
        }
        return false;
    }

    /**
     * 使用ArrayUtils
     */
    public static boolean useArrayUtils(String[] arr, String targetValue) {
        return ArrayUtils.contains(arr, targetValue);
    }

//	public static void main(String[] args) {
//		List<Integer> l1 = new ArrayList<>();
//		l1.add(1);
//		l1.add(2);
//		l1.add(3);
//		gg(l1);
//	}
//
//	private static void gg(List<Integer> l1) {
//		List<Integer> l2 = l1.parallelStream().filter(item -> item.equals(1)).collect(Collectors.toList());
//		List<Integer> l3 = l1.parallelStream().filter(item -> item.equals(1)).collect(Collectors.toList());
//		System.out.println(l2);
//		
//
//		l3.add(4);
//		System.out.println(l2);
//		
//		
//		System.out.println(l3);
//		
//		System.out.println(l2.hashCode());
//		System.out.println(l3.hashCode());
//		System.out.println(l1.hashCode());
//		
////		System.out.println("fengefu");
//
////		l3 = l1;
////		l2.add("3");
////
////		System.out.println(l3);
////		System.out.println(l3.hashCode());
////		System.out.println(l2);
////		System.out.println(l2.hashCode());
//	}

}
