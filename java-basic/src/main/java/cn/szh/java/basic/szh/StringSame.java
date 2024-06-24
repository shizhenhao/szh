package cn.szh.java.basic.szh;

import java.util.Arrays;
import java.util.Objects;

/**
 * 避免用String这个类名，否则该包下其他类默认引用的就是这个类中
 *
 * @author Zhenhao.Shi
 * @date 2022/2/23 20:21
 */
public class StringSame {

    public static void main(String[] args) {
        String ss = "女 ";
        if(Objects.equals(ss,"女 ")){
            System.out.println(ss);
        }

        String strLength = "C02050700400004036330000026";
        String strLength1 = "{\"panels\":[{\"index\":0,\"name\":1,\"height\":30,\"width\":80,\"paperHeader\":0,\"paperFooter\":85.03937007874016,\"printElements\":[{\"options\":{\"left\":172,\"top\":0,\"height\":52,\"width\":52,\"coordinateSync\":false,\"widthHeightSync\":false},\"printElementType\":{\"title\":\"矩形\",\"type\":\"rect\"}},{\"options\":{\"left\":2,\"top\":0,\"height\":26,\"width\":170,\"title\":\"这是更新后的元素\",\"field\":\"productName\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"borderLeft\":\"solid\",\"borderTop\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"right\":51.9921875,\"bottom\":26.990767045454547,\"vCenter\":26.9921875,\"hCenter\":13.990767045454545,\"hideTitle\":true,\"textContentWrap\":\"clip\"},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":175,\"top\":2.5,\"height\":47,\"width\":47,\"title\":\"二维码\\n\",\"qrcodeType\":\"qrcode\",\"field\":\"barcode\",\"qrCodeLevel\":0,\"coordinateSync\":false,\"widthHeightSync\":false,\"hideTitle\":true,\"testData\":\"qrcode\"},\"printElementType\":{\"title\":\"二维码\",\"type\":\"qrcode\"}},{\"options\":{\"left\":52,\"top\":26,\"height\":13,\"width\":120,\"title\":\"这是更新后的元素\",\"field\":\"sourceGoodsCode\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textContentVerticalAlign\":\"middle\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"hideTitle\":true,\"textAlign\":\"center\"},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":2,\"top\":26,\"height\":13,\"width\":50,\"title\":\"物资编码\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"borderLeft\":\"solid\",\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"right\":122.72727272727273,\"bottom\":41.79544934359464,\"vCenter\":62.727272727272734,\"hCenter\":36.92044934359464},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":52,\"top\":39,\"height\":13,\"width\":120,\"title\":\"这是更新后的元素\",\"field\":\"specName\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"right\":172.5,\"bottom\":52.99289772727273,\"vCenter\":112.5,\"hCenter\":46.49289772727273,\"hideTitle\":true,\"textContentWrap\":\"ellipsis\"},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":2,\"top\":39,\"height\":13,\"width\":50,\"title\":\"规格型号\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"borderLeft\":\"solid\",\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"right\":51.9921875,\"bottom\":51.991477272727266,\"vCenter\":26.9921875,\"hCenter\":45.491477272727266},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":52,\"top\":52,\"height\":13,\"width\":70,\"title\":\"这是更新后的元素\",\"field\":\"batchCode\",\"coordinateSync\":false,\"widthHeightSync\":false,\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"right\":124.99291853471235,\"bottom\":64.74289772727272,\"vCenter\":89.99291853471235,\"hCenter\":59.86789772727272,\"hideTitle\":true,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"textContentWrap\":\"clip\"},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":122,\"top\":52,\"height\":13,\"width\":30,\"title\":\"效期\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":152,\"top\":52,\"height\":13,\"width\":72,\"title\":\"这是更新后的元素\",\"right\":225.99220830743963,\"bottom\":64.99928977272727,\"vCenter\":188.99220830743963,\"hCenter\":58.499289772727266,\"field\":\"expirationDate\",\"coordinateSync\":false,\"widthHeightSync\":false,\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"hideTitle\":true,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\"},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":2,\"top\":52,\"height\":13,\"width\":50,\"title\":\"批号\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"borderLeft\":\"solid\",\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"right\":77.24288940429688,\"bottom\":44.4999942779541,\"vCenter\":52.242889404296875,\"hCenter\":37.9999942779541},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":52,\"top\":65,\"height\":13,\"width\":120,\"title\":\"这是更新后的元素\",\"coordinateSync\":false,\"widthHeightSync\":false,\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"field\":\"barcode\",\"hideTitle\":true,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\"},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":172,\"top\":65,\"height\":13,\"width\":52,\"title\":\"这是更新后的元素\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"field\":\"package\",\"right\":224.50002080743963,\"bottom\":77.99644886363636,\"vCenter\":198.50002080743963,\"hCenter\":71.49644886363636,\"hideTitle\":true,\"textContentWrap\":\"ellipsis\"},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}},{\"options\":{\"left\":2,\"top\":65,\"height\":13,\"width\":50,\"title\":\"标签\",\"coordinateSync\":false,\"widthHeightSync\":false,\"textAlign\":\"center\",\"textContentVerticalAlign\":\"middle\",\"borderLeft\":\"solid\",\"borderRight\":\"solid\",\"borderBottom\":\"solid\",\"qrCodeLevel\":0,\"right\":52.49289772727273,\"bottom\":77.99644886363636,\"vCenter\":27.492897727272727,\"hCenter\":71.49644886363636},\"printElementType\":{\"title\":\"这是更新后的元素\",\"type\":\"text\"}}],\"paperNumberLeft\":55,\"paperNumberTop\":63,\"paperNumberDisabled\":true,\"paperNumberContinue\":true,\"topOffset\":2,\"watermarkOptions\":{\"content\":\"\",\"fillStyle\":\"rgba(184, 184, 184, 0.3)\",\"fontSize\":\"14px\",\"rotate\":25,\"width\":200,\"height\":200,\"timestamp\":false,\"format\":\"YYYY-MM-DD HH:mm\"},\"panelLayoutOptions\":{\"layoutType\":\"column\",\"layoutRowGap\":0,\"layoutColumnGap\":0}}]}";
        System.out.println(strLength.length());


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

            String str16 = str15.replace("测血压", "测血压tid");
            System.out.println(str16);
        }
        System.out.println(str15);


        //整理浏览器 - 博客下的文章
        /*// 在堆中创建字符串对象”Java“
// 将字符串对象”Java“的引用保存在字符串常量池中
        String s1 = "Java";
// 直接返回字符串常量池中字符串对象”Java“对应的引用
        String s2 = s1.intern();
// 会在堆中在单独创建一个字符串对象
        String s3 = new String("Java");
// 直接返回字符串常量池中字符串对象”Java“对应的引用
        String s4 = s3.intern();
// s1 和 s2 指向的是堆中的同一个对象
        System.out.println(s1 == s2); // true
// s3 和 s4 指向的是堆中不同的对象
        System.out.println(s3 == s4); // false
// s1 和 s4 指向的是堆中的同一个对象
        System.out.println(s1 == s4); //true
        System.out.println(s1 == s3); //false

        String s5 = new String("Hello,Java");
        String s6 = new String("Hello,Java");
        String s7 = "Hello,Java";
        String s8 = "Hello,Java";
        System.out.println(s5 == s6);//false
        System.out.println(s7 == s5);//false
        System.out.println(s7 == s6);//false
        System.out.println(s8 == s7);//true*/


        //整理浏览器 - 博客下的文章
        /*字符串动态拼接时，例如String s = “a” + new String(“b”)，String s = new String(“a”) + new String(“b”)，String s = x + y，本质上是调用了StringBuilder中的append方法，
        最后使用toString()转换为String类型，这样创建出来的对象在堆中，并且不会像new String(“abc”)一样去常量池中创建一个字符串。*/
        //结合javaGuide中的 String str4 = str1 + str2; 进行合并整理

        String s1 = new String("a") + new String("b"); // 堆
// 此时常量池中有["a","b"]，注意并没有"ab"，因为动态拼接并不会在常量池中创建对象。

        String s2 = s1.intern(); // s2为常量池中的“ab”，由于常量池中没有"ab"，创建一个"ab"，并且这个"ab"的引用与s1相同。
// 此时常量池中有["a","b","ab"]，其中"ab"的引用为s1的引用
        System.out.println(s1 == "ab"); // 是同一个引用
        System.out.println(s2 == "ab"); // s2就是常量池中的"ab"，显然为true


    }

}
