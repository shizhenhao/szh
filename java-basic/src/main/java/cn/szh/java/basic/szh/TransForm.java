package cn.szh.java.basic.szh;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhenhao.Shi
 * @date 2022/2/23 20:25
 */
public class TransForm {

    public static void main(String[] args) {
        // ""和" "直接转为字符串型
        int i = 2;
        Integer j = 3;
        // String str = j; // 不可直接转
        String s = "" + i;
        String s2 = i + "";
        String s3 = i + j + "" + i + j;
        String s4 = i + j + " " + i + j;
        String s5 = j.toString();
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        System.out.println("十进制转其他进制，转为字符串型：");
        String a = Integer.toHexString(11);// 转16进制
        String a2 = Integer.toOctalString(11);// 转8进制
        String a3 = Integer.toBinaryString(11);// 转2进制
        String a4 = Integer.toString(11, 16);
        String a5 = Integer.toString(11, 8);
        String a6 = Integer.toString(11, 2);
        System.out.println(a);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println(a6);

        System.out.println("字符串型数据(十六、八、二进制)转换为十进制型数：");
        int c = Integer.parseInt("FFFF", 16);
        String c2 = Integer.valueOf("FFFF", 16).toString();// valueOf()方法返回Integer类型，调用toString()返回字符串
        String c3 = Integer.toString(0xFFFF);// 可直接传入表示十六进制数字的基本数据类型。012的0，xyz的x。
        int c4 = Integer.parseInt("17", 8);
        String c5 = Integer.valueOf("17", 8).toString();
        String c6 = Integer.toString(017);// 012的0。没有直接表示二进制的数，二进制不能直接用来运算
        int c7 = Integer.parseInt("101", 2);
        String c8 = Integer.valueOf("0101", 2).toString();
        System.out.println(c);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);

        // 对于二进制、八进制和十六进制之间的转换，可先转换为十进制，在用十进制转多进制的相应方法进行转换
        // 对于valueOf方法，可以用于基本数据类型的装箱及多进制到十进制之间的转换
        System.out.println(Integer.toBinaryString(Integer.valueOf("FF", 16))); // 十六进制0xFF转为二进制

        System.out.println("String类提供valueOf方法将基本类型转换为字符串类型，例下述部分基本类型转换：");
        String b = String.valueOf(12);
        String b2 = String.valueOf(12.34);
        System.out.println(b);
        System.out.println(b2);

        // 字符串转换为基本类型
        int n = Integer.parseInt("12"); // 传的参可以转，否则报错，例"A"对应不是10而报错
        // 里调的是Integer.parseInt("12",10)
        float f = Float.parseFloat("12.34");
        System.out.println(n);
        System.out.println(f);

        /*
         * JSONObject相关转换
         */
        System.out.println();
        System.out.println("JSONObject：");
        JSONObject json = new JSONObject();
        json.put("id", 3);
        json.put("name", "szh");
        System.out.println(json);

        String str = json.toString();
        System.out.println(str);
        String str2 = "{\"id\":3,\"name\":\"szh\"}";
        System.out.println(str2);

        Object object = json.get("name");
        String str3 = (String) object;// 要是json.get("id"),编译不报错，运行报错，强转不过去
        System.out.println(str3);
        String name = json.getString("name");
        System.out.println(name);

        // String转JSONObject
        JSONObject json2 = (JSONObject) JSONObject.parse(str2);
        JSONObject json3 = JSONObject.parseObject(str2);
        System.out.println(json2);
        System.out.println(json3);

        List<String> list = new ArrayList<>();
        list.add("szh");
        list.add("hao");
        json.put("which", list);
        Object object2 = json.get("which");
        System.out.println(object2);
        // object2.get(0); 取不到，编译报错，Object型无get方法。这就是JSONObject的意义，可以方便取到
        // Object取不到get(key),但强转为JSONObject可以取到get(key),getString()不为Object型
        JSONArray jsonArray = json.getJSONArray("which");
        System.out.println(jsonArray);
        Object object3 = jsonArray.get(0);
        System.out.println(object3);
        // 一个HashMap用Object型接收，此Object强转为HashMap是可以get(key)的，即可以转过去
        // 此HashMap若toString，Object型接收，再强转为HashMap然后get（key)是会报错的，不能强转。HashMap型事实为String型
    }

}
