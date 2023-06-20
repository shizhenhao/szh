package cn.szh.szh;

import cn.hutool.core.collection.ListUtil;
import cn.szh.dto.VitalSignsViewResponse;
import cn.szh.util.CommonUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/3 15:14
 */
public class StreamSame {

    public static void main(String[] args) {
        //创建
        //方式1，通过java.util.Collection.stream()方法用集合创建流
        List list1 = Arrays.asList("a", "b", "c");
        //创建一个顺序流
        Stream stream = list1.stream();
        //创建一个并行流
        Stream parallelStream = list1.parallelStream();
        //集合流输出
        list1.stream().forEach(System.out::print);

        //方式2，使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int[] array = {1, 3, 5, 6, 8};
        IntStream stream2 = Arrays.stream(array);

        //方式3，使用Stream的静态方法：of()、iterate()、generate()
        Stream stream3 = Stream.of(1, 2, 3, 4, 5, 6);

        Stream stream4 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream4.forEach(System.out::println);

        Stream stream5 = Stream.generate(Math::random).limit(3);
        stream5.forEach(System.out::println);

        //Optional优雅判null
        //这个只判null，若a为空字符串是会打印的；若a是空集合是会打印的
        String a = "test";
        Optional.ofNullable(a).ifPresent(i -> System.out.println("a不是null,我才会执行"));
        String szh = Optional.ofNullable(a).orElse("szh");
        System.out.println(szh);


        List<String> list = new ArrayList<>();
        list.add("12-01-01-12");
        list.add("13-01-01-22");

        List<Integer> outChooseAgvIds = new ArrayList<>();
        if (list.stream().filter((detailList) -> {
            return (Integer.parseInt(detailList.substring(9, 11)) > 22)
                    && (CommonUtil.equals(Integer.parseInt(detailList.substring(0, 2)), 12, 13));
        }).count() > 0) {
            outChooseAgvIds.add(1);
        }

        System.out.println(outChooseAgvIds);


        //测试flatMap能否取不层级所有的相同属性的子级     结果为只取特定那层归为集合返回
        VitalSignsViewResponse response = new VitalSignsViewResponse();
        response.setId(1);
        VitalSignsViewResponse response2 = new VitalSignsViewResponse();
        response2.setId(2);
        VitalSignsViewResponse response3 = new VitalSignsViewResponse();
        response3.setId(3);
        VitalSignsViewResponse response4 = new VitalSignsViewResponse();
        response4.setId(4);
        response3.setIdList(ListUtil.toList(response4));
        response2.setIdList(ListUtil.toList(response3));
        response.setIdList(ListUtil.toList(response2));
        ArrayList<VitalSignsViewResponse> vitalSignsViewResponses = ListUtil.toList(response);

        List<VitalSignsViewResponse> collect = vitalSignsViewResponses.parallelStream().flatMap(i -> i.getIdList().parallelStream()).collect(Collectors.toList());
        List<Integer> collect1 = collect.parallelStream().map(VitalSignsViewResponse::getId).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect1);

        //求和

        //统计
        //一些产生统计结果的结果集也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt(i -> i).summaryStatistics();
        System.out.println("列表中最大的数：" + stats.getMax());
        System.out.println("列表中最小的数：" + stats.getMin());
        System.out.println("所有数之和：" + stats.getSum());
        System.out.println("平均数：" + stats.getAverage());
    }

}
