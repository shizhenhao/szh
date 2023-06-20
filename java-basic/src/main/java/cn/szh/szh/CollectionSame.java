package cn.szh.szh;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/7 10:56
 */
public class CollectionSame {

    public static void main(String[] args) {
        // 数组创建两种方式
        int[] arr = {1, 7, 4};// 静态创建，直接赋值 。
        // 和list一致，debug时是[1,4,7],可用增强型for循环，对象（例HashMap）不可循环。
        // int[] arr; arr={ 1, 4, 7 }; 编译错误， 只可声明的同时赋值
        int[] arr2 = new int[3];// 动态创建，先分空间（3个元素），后赋值。 然后数组下标赋值，默认值为0
        int[] arr3 = new int[]{1, 7, 4};
        System.out.println(arr);
        System.out.println(arr2);
        System.out.println(arr3);

        System.out.println(arr[0]);
        System.out.println(arr.length);
        // java.lang.ArrayIndexOutOfBoundsException: 3
        // System.out.println(arr[3]);// 数组下标越界异常。检测到异常下面都不再执行输出

        // java.util.Arrays 类能方便地操作数组，它提供的所有方法都是静态的。
        String string = Arrays.toString(arr); // 输出一个数组, 是String串
        System.out.println(string);
        Arrays.sort(arr); // 数组的快速排序,升序，即从小到大
        System.out.println(Arrays.toString(arr));
        int[] copyOf = Arrays.copyOf(arr, 4); // 数组整个复制（用于数组的扩容）
        System.out.println(Arrays.toString(copyOf));

        // 引用类型数组
        Student[] stu = new Student[]{new Student(), new Student()};

        /*
         * List
         */
        System.out.println("遍历 List：");
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("123" + list);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }

        // 增强型for循环
        for (String str : list) {
            System.out.println(str);
        }

        List<String> addList = new ArrayList<>();
        List<String> addList2 = new ArrayList<>();
        List<String> addList3 = new ArrayList<>();
        addList3.addAll(addList);
        addList3.addAll(addList2);
        System.out.println(addList3);// list还是空list

        // 变为数组相关的内容进行遍历
        Object[] array = list.toArray();// List转数组
        String[] array2 = new String[list.size()];
        String[] array3 = list.toArray(array2);
        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
        for (Object str : array2) {// array2有值，为什么？ 这样就不需array3/array2变量的
            System.out.println(str);
        }
        for (String str : array3) {
            System.out.println(str);
        }

        // 使用迭代器进行相关遍历
        Iterator<String> ite = list.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }

        // 数组转List
        List<Integer> resultList = new ArrayList<>(arr.length);
        for (int a : arr) {
            resultList.add(a);
        }
        System.out.println(resultList);
        // Arrays.asList();具体怎么用暂不知
        List<String> resultList2 = new ArrayList<>(array2.length);
        Collections.addAll(resultList2, array2);// arr不可，报错
        System.out.println(resultList2);
        // resultList = List.of(arr); java9中方法

        System.out.println(list);
        Collections.reverse(list);// List集合反转
        System.out.println(list);

        System.out.println("遍历HashMap相关方法：");
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");
        Map<Integer, String> map2 = new HashMap<Integer, String>();
        if (map.equals(map2)) {

        }
        // 第一种：普遍使用，二次取值。 通过Map.keySet遍历key，然后通过key取value
        for (Integer key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

        // 第二种。 通过Map.entrySet使用iterator遍历key和value。 和第三种相似吧
        Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        // 第三种：推荐，尤其是容量大时。 通过Map.entrySet遍历key和value
        for (Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        // 第四种。 通过Map.values()遍历所有的value，但不能遍历key
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }

}

class Student {
}
