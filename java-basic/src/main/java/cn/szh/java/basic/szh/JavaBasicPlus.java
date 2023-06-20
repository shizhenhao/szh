package cn.szh.java.basic.szh;

/**
 * @author Zhenhao.Shi
 * @date 2023/2/24 14:42
 */
public class JavaBasicPlus {

    public static void main(String[] args) {
        //gg方法中不可对ii的值修改，亦可证明java无引用传递
        Integer ii = 3;
        gg(ii);
        System.out.println(ii);
    }

    private static void gg(Integer ii) {
        System.out.println(ii);
        ii = 4;
    }

}
