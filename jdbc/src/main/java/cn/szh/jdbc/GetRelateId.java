package cn.szh.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 获取主表ID，供从表关联
 *
 * @author Zhenhao.Shi
 * @date 2022/11/12 20:18
 */
public class GetRelateId {

    //create table r_keywords(id number(8), word varchar2(8));
    //create sequence k_seq;    供上表使用的主键序列

    public static void main(String[] args) {
        Connection conn = null;
        String sql = "insert into r_keywords (id, word) values "
                + "(k_seq.nextval,?)";
        //自动生成序号的的列名
        String[] cols = {"id"};
        try {
            conn = DbUtils.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement ps = conn.prepareStatement(sql, cols);

            ps.setString(1, "雾霾");
            int n = ps.executeUpdate();
            if (n != 1) {
                throw new Exception("话题添加失败");
            }

            //获取自动生成（序列生成）的ID
            ResultSet rs = ps.getGeneratedKeys();
            int id = -1;
            while (rs.next()) {
                id = rs.getInt(1);
            }

            rs.close();
            ps.close();

            //k_id的值为该从表对于关联主表的主键
            String sql2 = "insert into r_post (id, content, k_id) values (p_seq.nextva1, ?, ?)";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, "今天天气不错，晚上有雾霾！");
            ps.setInt(2, id);
            n = ps.executeUpdate();
            if (n != 1) {
                throw new Exception("天气太糟");
            }

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            DbUtils.rollback(conn);
        } finally {
            DbUtils.close(conn);
        }
    }

}
