package cn.szh.jdbc.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 测试并发下获取连接池的连接，测试 等待/阻塞/Block 效果
 *
 * @author Zhenhao.Shi
 * @date 2022/8/10 11:08
 */
public class DbPoolThread extends Thread {

    int wait;

    public DbPoolThread(int wait) {
        this.wait = wait;
    }

    public static void main(String[] args) {
        Thread t1 = new DbPoolThread(5000);
        Thread t2 = new DbPoolThread(6000);
        Thread t3 = new DbPoolThread(1000);

        //此三个线程无先后顺序，5000这个可能是最后才执行
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        Connection conn = null;
        try {
            conn = DbPoolUtils.getConnection();
            System.out.println("获取了连接池中的连接：" + conn);

            Thread.sleep(wait);

            String sql = "select 'Hello' as a FROM dual";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("a"));
            }

            System.out.println(wait + "结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbPoolUtils.close(conn);
        }
    }

}
