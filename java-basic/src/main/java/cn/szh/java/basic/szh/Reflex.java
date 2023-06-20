package cn.szh.java.basic.szh;

import java.util.Scanner;

/**
 * 反射： 是java API，是java提供的现成的类（接受API提供的功能）。
 * 是java提供的动态执行机制，动态加载类，动态创建对象，动态访问属性，动态调用方法。
 * java中动态执行：运行期间才能确定加载哪些类，创建哪些对象，执行哪些方法...
 * 静态：事先约定的规则，执行期间按照固定规则执行
 *
 * @author Zhenhao.Shi
 * @date 2022/8/7 11:04
 */
public class Reflex {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入类名：");// 例如输入szh.java.Null
        String className = scan.nextLine();
        Class cla = null;
        try {
            // 动态加载类（运行期间加载有可能找不到类名，报异常）
            cla = Class.forName(className);
            System.out.println(cla);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 动态创建对象（类需有无参构造器）
        try {
            Object obj = cla.newInstance();// 不知创建的对象是什么类型
            System.out.println(obj);// szh.java.Null@1b6d3586。
            // 1b6d3586为hashcode值，对象的地址java公司没有开放，永远看不到
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
