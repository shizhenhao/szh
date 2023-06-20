package cn.szh.szh;

import java.util.Arrays;

/**
 * 避免用String这个类名，否则该包下其他类默认引用的就是这个类中
 *
 * @author Zhenhao.Shi
 * @date 2022/2/23 20:21
 */
public class StringSame {

    public static void main(String[] args) {
        //StringBuffer线程安全的，性能慢些，基本不需要；
        //StringBuilder非线程安全的，jdk1.5出来的。

        //多个参数，参数CharSequence，返回第一个参数拼接 后一个可变/list集合参数每个项中后的字符串。
        //String.join();

        char[] c = {'a', 'b', 'c'};
        //这个类型数组可直接输出，其余类型数组输出一串字符串
        System.out.println(c);

        //相当于String str = new String("abc");
        String str = new String(c);
        System.out.println(str);

        //将字符串转为字符数组
        str = "hello";
        c = str.toCharArray();
        System.out.println(c);

        //返回字符串中指定位置的字符
        char ch = str.charAt(0);
        System.out.println(ch);

        //将指定字符串连接到此字符串的结尾
        String str2 = str.concat("Java");
        System.out.println(str2);

        //是否包含。 参数CharSequence，入参'e'不行
        boolean b = str.contains("e");
        System.out.println(b);
        //是true
        System.out.println("Ⅱ级护理".contains(""));

        //是否以指定字符串结尾
        System.out.println(str.endsWith("o"));

        //与另一指定的对象比较
        b = str.equals("Hello");
        System.out.println(b);
        //与另一字符串比较，不区分大小写
        b = str.equalsIgnoreCase("Hello");
        System.out.println(b);

        String str3 = "hello,this  is a test";
        String str4 = "is";
        //返回指定字符（串）在字符串中第一次出现的索引，如果此字符串中没有这样的字符，则返回 -1。
        System.out.println(str3.indexOf('i'));//8 。 参数可为char/此字符串对应的ASCII码
        System.out.println(str3.indexOf(str4));//8
        System.out.println(str3.indexOf(str4, 7));//8。从fromIndex位置开始查找/从指定的索引查找
        System.out.println(str3.indexOf("is", 9)); //11。 两个空格也占两个位置
        System.out.println(str3.indexOf("is", 13)); //-1

        int strlength = str.length();//字符串的长度         两个空格占两个长度
        System.out.println(strlength);
        String str5 = str3.replace("is", "AA");//newChar 替换此字符串中所有 oldChar 得到的
        //参数CharSequence，明明是第一个方法，但调用第二个方法
        System.out.println(str5);
        System.out.println(str3.replace('h', 'g'));//可传字符串或字符，但不可既有又有
        //使用给定的 replacement替换此字符串所有匹配给定的正则表达式的子字符串。
        String str6 = str3.replaceAll("is", "as");
        System.out.println(str6);
        String str7 = "hello,szh\\s\\zh\\\\s\\\\zh";
        System.out.println(str7);
        System.out.println(str7.replaceAll("\\\\", "\\\\"));//一个反斜杠替换一个反斜杠
        System.out.println(str7.replaceAll("\\\\", "\\\\\\\\"));//两个反斜杠替换一个反斜杠，好像是方法里又转换了一次
        System.out.println(str7.replaceAll("\\\\\\\\", "\\\\"));//一个反斜杠替换两个反斜杠

        System.out.println("123123");
        System.out.println(str);
        String str8 = str.substring(2);//从指定位置开始截取为子串
        String str9 = str.substring(0, 2);
        System.out.println(str8);
        System.out.println(str9);
        String str10 = "boo:a.nd:foo";
        String[] split = str10.split(":");//根据给定正则表达式的匹配拆分此字符串
        System.out.println(Arrays.toString(split));
        split = str10.split("o");//有个空的,具体原因?
        System.out.println(Arrays.toString(split));
        split = str10.split(":", 4);//分割的份数
        System.out.println(Arrays.toString(split));
        split = str10.split("\\.");//分割小数点，不是直接一个点字符串
        System.out.println(Arrays.toString(split));

        Boolean b2 = str.startsWith("helo");//是否以指定字符串开头
        System.out.println(b2);
        String str11 = str.toUpperCase();
        String str12 = str11.toLowerCase();
        System.out.println(str11);
        System.out.println(str12);
        String str13 = "131a-1";
        String str14 = "131A-1";
        System.out.println(str13.toUpperCase().equals(str14));
        System.out.println(str13.equalsIgnoreCase(str14));

        String str15 = "测血压、脉搏";
        if (str15.contains("测血压")) {
            String[] s = str15.split("测血压");
            str15 = s[0].concat("测血压").concat("tid").concat(s[1]);
        }
        System.out.println(str15);
    }

}
