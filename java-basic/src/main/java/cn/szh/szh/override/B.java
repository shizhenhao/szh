package cn.szh.szh.override;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/7 11:58
 */
public class B {
    static String gh = "gh";
    String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void hh() {
        System.out.println("HH_BB");
    }

    protected void gg() {
        System.out.println("B的gg");
    }

    //输出对象会调用重写的toString方法，syso中有调用的
    @Override
    public String toString() {
        return "B [s=" + s + "]";
    }

}
