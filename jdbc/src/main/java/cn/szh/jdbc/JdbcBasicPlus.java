package cn.szh.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/9 14:28
 */
public class JdbcBasicPlus {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DbUtils.getConnection();

            Statement st = conn.createStatement();

            String sql = "select * from PRINT_PACKAGE";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("PACKID");
                String name = rs.getString("PACKNAME");
                System.out.println(id + "," + name);
            }

            //结果集元数据（结果集的相关信息）
            ResultSetMetaData metaData = rs.getMetaData();
            //结果集的列数量
            int columnCount = metaData.getColumnCount();

            //结果集的每个列名
            for (int i = 1; i < columnCount; i++) {
                String name = metaData.getColumnName(i);
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 无bug的关闭数据库操作
            // 如果只是在Basic程序的第6步中关闭，之前步骤可能出异常，程序不执行第6步关闭了     所以涉及到连接数据库需要这样写，一定保证关闭
            DbUtils.close(conn);
        }
    }

}
