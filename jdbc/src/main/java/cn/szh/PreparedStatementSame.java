package cn.szh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 1、可重复使用执行计划
 * 2、可避免SQL注入攻击
 *
 * @author Zhenhao.Shi
 * @date 2022/8/16 20:52
 */
public class PreparedStatementSame {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DbUtils.getConnection();

            //创建带参数的SQL语句
            String sql = "insert into test (id, name) values (?, ?)";
            //String sql = "update test set name = ? where id = ?";

            //将SQL发送到数据库，创建执行计划。 返回值ps 就代表执行计划
            PreparedStatement ps = conn.prepareStatement(sql);

            //替换执行计划中的2个参数
            ps.setInt(1, 8);
            ps.setString(2, "John");

            //执行 "执行计划"
            int n = ps.executeUpdate();
            System.out.println(n);

            //重用执行计划
            ps.setInt(1, 9);
            ps.setString(2, "Jom");
            n = ps.executeUpdate();
            System.out.println(n);

            //SQL注入演示
            //字符串拼接SQL语句就有发生SQL注入的风险
            //SQL注入避免：1、拦截用户输入的SQL关键字   2、固定执行计划，避免输入的内容含有SQL成分更改了执行计划
            login("John", "1' or '1' = '1");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(conn);
        }
    }

    public static boolean login(String name, String pwd) {
        String sql = "select count(*) as c from base_user_info "
                + "where name = \'" + name + "\' "
                + "and pwd = \'" + pwd + "\' ";
        System.out.println(sql);

        Connection conn = null;
        try {
            conn = DbUtils.getConnection();

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int n = rs.getInt("c");

                return n >= 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(conn);
        }

        return false;
    }

}
