package cn.szh.java.basic.szh;

import cn.hutool.core.collection.ListUtil;
import cn.szh.java.basic.dto.TestResponse;

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
/*        PkgBoxEventStateEnum stateEnum = Arrays.stream(PkgBoxEventStateEnum.values()).parallel()
                .filter(i -> Objects.equals(i.getOperateState(), request.getType()))
                .findAny().orElse(null);
        PkgBoxEventStateEnum stateEnum = Arrays.stream(PkgBoxEventStateEnum.values())
                .filter(i -> Objects.equals(i.getOperateState(), request.getType()))
                .findAny().orElse(null);*/

        //创建流-三种方式
        create();

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 7, 6, 5);
        List<String> numberss = Arrays.asList("1", "2");
        Set<String> integerSet = numberss.parallelStream().collect(Collectors.toSet());
        integerSet.add("0");
        integerSet.add(null);
        integerSet.add("");
        integerSet.add("");
        System.out.println(integerSet);

        //匹配所有、匹配任意一个、都不匹配
        allMatch(numbers);
        //anyMatch();
        //noneMatch();

        //收集器
        collect(numbers);

        //filter-过滤
        filter(numbers);

        //map-转换流（可用于提取集合的某个属性为新集合）
        map(numbers);

        //flatMap-取集合的子集
        flatMap();

        //Optional优雅判null
        optional();

        //统计-IntSummaryStatistics
        intSummaryStatistics(numbers);

        //求和
    }

    private static void create() {
        //方式1，通过java.util.Collection.stream()方法用集合创建流
        List<String> list = Arrays.asList("a", "b", "c");
        //创建一个顺序流
        Stream<String> stream = list.stream();
        //创建一个并行流
        Stream<String> parallelStream = list.parallelStream();
        //集合流输出
        stream.forEach(System.out::print);
        System.out.println();

        //方式2，使用java.util.Arrays.stream(T[] array)方法用数组创建流
        int[] array = {1, 3, 5, 6, 8};
        IntStream stream2 = Arrays.stream(array);

        //方式3，使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream4.forEach(System.out::println);

        Stream<Double> stream5 = Stream.generate(Math::random).limit(3);
        stream5.forEach(System.out::println);
    }

    private static void allMatch(List<Integer> numbers) {
        boolean allMatch = numbers.parallelStream().allMatch(i -> i > 3);
        System.out.println(allMatch);
    }

    /**
     * 是否有序跟并行流无关系，只跟Collector的特性Characteristics有关；
     * Collectors.toList()返回的收集器是IDENTITY_FINISH枚举类型的，返回有序结果，即与list.parallelStream()的list中的顺序一致
     */
    private static void collect(List<Integer> numbers) {
        //大于3的集合
        List<Integer> collect = numbers.parallelStream()
                .filter(i -> i > 3).collect(Collectors.toList());
        //收集为set
        Set<Integer> collect1 = numbers.parallelStream()
                .filter(i -> i > 3).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println(collect1);

        //list转set
        Set<Integer> set = numbers.parallelStream().collect(Collectors.toSet());
        System.out.println(set);

        //以某个属性分组
        TestResponse response = new TestResponse();
        response.setId(1);
        TestResponse response2 = new TestResponse();
        response2.setId(2);
        ArrayList<TestResponse> responses = ListUtil.toList(response, response2);
        Map<Integer, List<TestResponse>> map = responses.parallelStream().collect(Collectors.groupingBy(TestResponse::getId));
        map.forEach((k, v) -> {
            System.out.println("id:" + k);
            System.out.println("相同id" + k + "对应的集合为：" + v);
        });

        //数组以,号组装返回String；   numbers数组为Integer型报错，需String型
        List<String> strings = numbers.parallelStream().map(Object::toString).collect(Collectors.toList());
        String collect2 = strings.parallelStream().collect(Collectors.joining(","));
        System.out.println(collect2);
    }

    private static void filter(List<Integer> numbers) {
        //满足与3相等的元素集合
        List<Integer> collect = numbers.parallelStream()
                .filter(i -> Objects.equals(i, 3)).collect(Collectors.toList());
        System.out.println(collect);

        //满足与3相等的随机的一个元素
        Integer integer = numbers.parallelStream()
                .filter(i -> Objects.equals(i, 3)).findAny().orElse(null);
        System.out.println(integer);

        //满足两个条件的元素集合;  下述两个过滤条件相同的；
        //第二种可将判断条件 i > 3 && i < 7 提取为方法，方法入参将i传入，返回值类型为boolean即可
        List<Integer> collect1 = numbers.parallelStream()
                .filter(i -> i > 3)
                .filter(i -> i < 7).collect(Collectors.toList());
        List<Integer> collect2 = numbers.parallelStream()
                .filter(i -> i > 3 && i < 7).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println(collect2);
    }

    private static void map(List<Integer> numbers) {
        List<String> strings = numbers.parallelStream().map(Object::toString).collect(Collectors.toList());
        System.out.println(strings);

        TestResponse response = new TestResponse();
        response.setId(1);
        response.setName("张三");
        TestResponse response2 = new TestResponse();
        response2.setId(2);
        response2.setName("李四");
        ArrayList<TestResponse> responses = ListUtil.toList(response, response2);

        //id集合转为对应的以,号分割的names字符串
        String names = Arrays.stream("1,3,2".split(",")).parallel()
                .map(i -> {
                    TestResponse testResponse = responses.parallelStream()
                            .filter(j -> Objects.equals(j.getId().toString(), i)).findAny().orElse(null);
                    return testResponse == null ? null : testResponse.getName();
                })
                //将map中可能返回的null过滤掉，防出现 张三,null,李四
                .filter(Objects::nonNull)
                .collect(Collectors.joining(","));
        System.out.println(names);
    }

    private static void flatMap() {
        //测试flatMap能否取不层级所有的相同属性的子级     结果为只取特定那层归为集合返回
        TestResponse response = new TestResponse();
        response.setId(1);
        TestResponse response2 = new TestResponse();
        response2.setId(2);
        TestResponse response3 = new TestResponse();
        response3.setId(3);
        TestResponse response4 = new TestResponse();
        response4.setId(4);
        response3.setIdList(ListUtil.toList(response4));
        response2.setIdList(ListUtil.toList(response3));
        response.setIdList(ListUtil.toList(response2));
        ArrayList<TestResponse> testResponses = ListUtil.toList(response);

        List<TestResponse> collect = testResponses.parallelStream()
                .flatMap(i -> i.getIdList().parallelStream()).collect(Collectors.toList());
        List<Integer> collect1 = collect.parallelStream().map(TestResponse::getId).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect1);

        List<Integer> collect2 = testResponses.parallelStream()
                .flatMap(i -> i.getIdList().parallelStream().map(TestResponse::getId)).collect(Collectors.toList());
        System.out.println(collect2);
    }

    private static void optional() {
        //这个只判null，若a为空字符串是会打印的；若a是空集合是会打印的
        String str = "test";
        Optional.ofNullable(str).ifPresent(i -> System.out.println("a不是null,我才会执行"));
        String szh = Optional.ofNullable(str).orElse("szh");
        System.out.println(szh);
    }

    private static void intSummaryStatistics(List<Integer> numbers) {
        //一些产生统计结果的结果集也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
        IntSummaryStatistics stats = numbers.parallelStream().mapToInt(i -> i).summaryStatistics();
        System.out.println("列表中最大的数：" + stats.getMax());
        System.out.println("列表中最小的数：" + stats.getMin());
        System.out.println("所有数之和：" + stats.getSum());
        System.out.println("平均数：" + stats.getAverage());
    }

}
