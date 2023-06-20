package cn.szh.java.basic.szh;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/3 16:01
 */
public class JavaBasic {

    public static void main(String[] args) {
        System.out.println("HelloWorld!");
        System.out.println();
        // 先输出括号里内容，再判断输出之后是否转行
        System.out.print(111);
        System.out.println("222");
        // 加双引号输出，即是输出字符串形式，双引号里面是什么就输出什么
        System.out.println("sum");

        System.out.println(args);
        System.out.println(Arrays.toString(args));

        // 1970.1.1毫秒数，即时间戳
        long time = System.currentTimeMillis();
        System.out.println("时间戳：" + time);

        // 0.0到0.999...间随机数
        double random = Math.random();
        System.out.println("随机数：" + random);

        // ASCII码
        char x = 'A';
        char y = 65;
        System.out.println(x);
        System.out.println(y);
        // 130,而非130对应的ASCII码的那个数
        System.out.println('A' + 'A');

        // 运算符
        int a = 5, b = 5;
        // a先赋值给c,然后a为a+1
        int c = a++;
        // b先为b+1，然后赋值给d
        int d = ++b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(a++);
        System.out.println(a);
        a = a + 2;
        System.out.println(a);
        // 和 a = a + 2 一致,前者扩展赋值运算可自动强转，后者不会自动强转。 short a = a+5;是错的
        a += 2;
        System.out.println(a);

        // 控制台输入函数
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一行数据，换行键结束：");
        // 解析一行数据 前面不可有scan输入，否则这个不生效：程序跳过这个输入
        // scan.next() 遇到空格时，直接结束 ，而将空格之后的内容交给下一个scan输入，下一个若是scan.nextInt()接收，当转换不为int时下行报错
        String str = scan.nextLine();
        System.out.println("输入行数据：" + str);
        System.out.println("请输入年龄和价格，换行键结束一个：");
        int age = scan.nextInt();
        double price = scan.nextDouble();
        System.out.println("年龄为：" + age);
        System.out.println("价格为：" + price);
    }

}
