package cn.szh;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Zhenhao.Shi
 * @date 2022/8/9 11:23
 */
public class DbUtils {

    // 静态常量 比放在方法里可避免多次调用方法时多次创建方法内变量
    static String driver;
    static String url;
    static String username;
    static String password;

    // 读取文件中的数据库连接参数 以初始化静态属性    应用文件可让用户不需知道java 而是修改文件内容而后重启即可
    static {
        try {
            Properties cfg = new Properties();
            InputStream in = DbUtils.class.getClassLoader().getResourceAsStream("db.properties");
            cfg.load(in);

            driver = cfg.getProperty("jdbc.driver");
            url = cfg.getProperty("jdbc.url");
            username = cfg.getProperty("jdbc.username");
            password = cfg.getProperty("jdbc.password");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        // Java中行业内文件名以 .properties 为后缀名
        // Properties是Java中专门用于读取配置文件的API。 其底层就是文本文件IO   本身实现Map接口，内部是散列表，限定Key和value都是String类型

        Properties cfg = new Properties();
        System.out.println(cfg);
        System.out.println(cfg.size());
        System.out.println(cfg.isEmpty());

        // resources中文件一般用这种流读取     文件名避免中文和空格  视频中说文件内容中等号两边不可加空格，但现在实际应用是可以有空格的
        InputStream in = DbUtils.class.getClassLoader().getResourceAsStream("db.properties");
        // 文件内容读取到散列表中
        cfg.load(in);
        System.out.println(cfg);
        System.out.println(cfg.size());

        // 查找文件内容，就是读取文件内容
        String s = cfg.getProperty("jdbc.driver");
        System.out.println(s);
    }

    /**
     * 封装创建数据库的过程，简化数据库连接，简化主程序中代码，可复用即简化代码
     *
     * @return java.sql.Connection
     * @author Zhenhao.Shi
     * @date 2022/9/17 14:42
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);

            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            // throw 可防止发生异常没有返回值。 可以看成是种return
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
