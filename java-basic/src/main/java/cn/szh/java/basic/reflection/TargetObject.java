package cn.szh.java.basic.reflection;

/**
 * @author Zhenhao.Shi
 * @date 2023/10/12 14:17
 */
public class TargetObject {

    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
    
}
