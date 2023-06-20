package cn.szh.java.basic.szh.override;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/7 11:57
 */
public class A extends B{
    public static void main(String[] args) {
        Integer aaa = 2;
        Integer bb=0;
        if(aaa<3){
            bb=3;
        }else if(aaa<5){
            bb=5;
        }
        System.out.println(bb);
        A a = new A();
        a.hh();
        a.gg();
        B b = new B();
        b.gg();
        System.out.println(b);
        B b2 = new B();
        System.out.println(b.hashCode());
        System.out.println(b2.hashCode());
        if (b.equals(b2)) {
            System.out.println("TRUE");
        }
    }

    @Override
    public void hh() {
        System.out.println("A的hh");
    }

}
