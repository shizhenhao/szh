package cn.szh.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Zhenhao.Shi
 * @date 2022/10/23 21:54
 */
public class Transactional {
    //隔离性举例：oracle 有一边未commit（数据库会锁住）；    另一边（打开第二个数据库工具）执行SQL语句会一直处于等待中，java程序也在等待中 编译器的控制台无任何输出

    public static void main(String[] args) {
        pay(1, 2, 1000.0);
        System.out.println("ok");
    }

    private static void pay(int from, int to, double money) {
        String sql1 = "update r_account set balance = balance + ? where id=?";
        String sql2 = "select balance from r_account where id=?";
        Connection conn = null;
        try {
            conn = DbUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql1);

            //减钱    money用- 复用sql执行计划
            ps.setDouble(1, -money);
            ps.setInt(2, from);
            int n = ps.executeUpdate();
            if (n != 1) {
                throw new Exception("扣错了");
            }

            //增加
            ps.setDouble(1, money);
            ps.setInt(2, to);
            n = ps.executeUpdate();
            if (n != 1) {
                throw new Exception("加错了");
            }

            // 检查
            ps = conn.prepareStatement(sql2);
            ps.setInt(1, from);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double bal = rs.getDouble(1);
                if (bal < 0) {
                    throw new Exception("透支");
                }
            }

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();

            //事务中有内容抛异常，回滚 保证事务原子性
            DbUtils.rollback(conn);
        } finally {
            DbUtils.close(conn);
        }
    }

}
