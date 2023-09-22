package cn.szh.java.basic.szh;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/3 15:52
 */
public class Null {
    /*
      对于每一个Java程序员来说,null肯定是一个让人头痛的东西,连Java的发明者都承认这是一项巨大的设计失误,今天就来总结一下Java中关于null的知识.
     1.null不属于任何类型,可以被转换成任何类型,但是用instanceof永远返回false.
     2.null永远不能和八大基本数据类型进行赋值运算等,否则不是编译出错,就是运行出错.
     3.null可以和字符串进行运算.
     4.同种类型的null,比较都返回true,null==null也返回true.
     */

    public static void main(String[] args) {
        //2.null永远不能和八大基本数据类型进行赋值运算等,否则不是编译出错,就是运行出错.
        Integer nul = null;
        //下面这行报NullPointerException
        //System.out.println(2 + nul);

        //3.null可以和字符串进行运算.
        System.out.println("12" + nul);

        //null点任何属性都报空指针
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        }

        //null不可以用于if判断，下面这段报空指针
        //boolean bb = null;     这种直接编译不通过
        Boolean b = null;
        //if(b){
        //    System.out.println(2222);
        //}

        //这个null的包装类可以调方法
        Null.hello();
        //这种报空指针
        ((Null) null).hello2();
    }

    private static void hello() {
        System.out.println("HELLO");
    }

    private void hello2() {
        System.out.println("HELLO2");
    }
}
