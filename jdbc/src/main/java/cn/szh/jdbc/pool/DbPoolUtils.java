package cn.szh.jdbc.pool;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接池      并发问题伴随着连接池  控制并发数量和连接（线程）重用
 *
 * @author Zhenhao.Shi
 * @date 2022/8/10 10:35
 */
public class DbPoolUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * 连接池
     */
    private static BasicDataSource ds;
    /**
     * 连接池初始化连接数
     */
    private static int initSize;
    /**
     * 连接池最大连接数     各类数据库一般支持 1千多个连接，否则会造成数据库瘫痪
     */
    private static int maxActive;

    static {
        // 多个连接，一个连接池就可以了，不要建多个连接池
        ds = new BasicDataSource();
        try {
            Properties cfg = new Properties();
            InputStream in = DbPoolUtils.class.getClassLoader().getResourceAsStream("db.properties");
            cfg.load(in);

            driver = cfg.getProperty("jdbc.driver");
            url = cfg.getProperty("jdbc.url");
            username = cfg.getProperty("jdbc.username");
            password = cfg.getProperty("jdbc.password");

            initSize = Integer.parseInt(cfg.getProperty("initSize"));
            maxActive = Integer.parseInt(cfg.getProperty("maxActive"));

            // 初始化连接池
            // 设置必须的参数
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);

            // 设置连接池的管理策略参数
            ds.setInitialSize(initSize);
            ds.setMaxActive(maxActive);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            // 从连接池中获取连接，若连接池满了，则 等待/阻塞/Block ,直到有连接归还给连接池
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                // 将用过的连接归还给连接池，而非关闭此次数据库连接，连接池中连接是一直连接着数据库的
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
