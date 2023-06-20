package cn.szh.jdbc;

import java.sql.*;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/8 16:34
 */
public class JdbcBasic {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         JDBC是Java应用程序和数据库之间的通信桥梁，是Java应用程序访问数据库的通道。  底层是socket
         JDBC定义一套标准接口，即访问数据库的通用API。
         JDBC标准主要有一组接口组成，其好处是统一了各种数据库访问方式
         JDBC接口的实现类称为数据库驱动，由各个数据库厂商提供（厂商根据各自数据库的特点去实现这些接口），使用数据库必须导入这个驱动

         JDBC工作过程：1、加载驱动，建立连接	 2、创建语句对象   3、执行SQL语句	4、处理结果集     5、关闭连接
         */

        /**
         驱动管理       DriverManager
         连接接口       Connection      DatabaseMetaData
         语句对象接口    Statement       PreparedStatement    CallableStatement
         结果集接口      ResultSet       ResultSetMetaData
         */

        // JDBC使用步骤：
        // 1、导入相应数据库的JDBC驱动jar包。  这就是具体的实现类，实现了JDBC的接口标准
        // 2、加载驱动   即注册驱动
        // 驱动程序类名（下述的类在com.oracle:ojdbc相关jar包里）。 若加载不成功，抛出异常。下一句是不会执行的，程序到此被中断了
        Class.forName("oracle.jdbc.OracleDriver");
        System.out.println("OK!");

        // 3、获得Connection对象 即连接到数据库
        String url = "jdbc:oracle:thin:@192.168.1.96:1521:scp";
        String username = "scp";
        String password = "scp";
        Connection conn = DriverManager.getConnection(url, username, password);
        //输出conn的引用对象的实际类型 可证明驱动程序提供了Connection接口的实现类
        System.out.println(conn.getClass());

        // 4、创建“Statement语句”对象 用于执行SQL语句
        // boolean flag = execute(ddl)      执行任何SQL，常用于DDL，DCL              如果没有异常则成功 返回Boolean true有结果集，false没
        // int flag = executeUpdate(dml)    执行DML语句，如：insert update delete   返回数字，表示更新“行”数量，抛出异常则失败
        // ResultSet rs = executeQuery(dql) 执行DQL语句，如：select      返回ResultSet（结果集）对象，代表2维查询结果，使用for遍历处理，查询失败则抛出异常。
        Statement st = conn.createStatement();

        String dml = "update PRINT_PACKAGE set IS_STOP = 0 where PACKID = 21";
        int b = st.executeUpdate(dml);
        System.out.println("更新表数据：" + b);

        // 5、处理SQL执行结果：
        String sql = "select PACKID,PACKNAME from PRINT_PACKAGE";
        ResultSet rs = st.executeQuery(sql);

        // 例如数据：ResultSet
        // PACKID   PACKNAME
        // 21       活动内容
        // nest()移动游标(一开始在第一行数据之前)到下一行位置，并且检查是否有数据，如果有返回true
        while (rs.next()) {
            //获取当前行 指定列的值      rs.getInt(1)也可以代表获取第一列的值（入参列的序号），但不常用
            int id = rs.getInt("PACKID");
            String name = rs.getString("PACKNAME");
            System.out.println(id + "," + name);
        }

        // 6、关闭数据库连接（*若遗忘，会造成数据库瘫痪）
        conn.close();
    }

}
