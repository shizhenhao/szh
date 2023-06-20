package cn.szh.szh.override;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/7 11:59
 */
public interface C {
    public default void gg() {
        System.out.println("IB");
    }

    void hh();

}
