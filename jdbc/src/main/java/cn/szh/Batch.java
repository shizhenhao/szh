package cn.szh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;

/**
 * @author Zhenhao.Shi
 * @date 2022/11/12 18:03
 */
public class Batch {
    //批量：1、执行一批SQL； 2、1个执行计划，一批参数

    public static void main(String[] args) {
        addBatch1();
        addBatch2();
    }

    private static void addBatch1() {
        String sql1="create table log_01 (id number(8), msg varchar2(100)) ";
        String sql2="create table log_02 (id number(8), msg varchar2(100)) ";

        Connection conn = null;
        try {
            conn = DbUtils.getConnection();
            Statement st = conn.createStatement();

            //sql1添加到Statement的缓存中
            st.addBatch(sql1);
            st.addBatch(sql2);

            //执行一批SQL   几个SQL就返回几个元素
            int[] ary = st.executeBatch();

            System.out.println(Arrays.toString(ary));
            System.out.println("oK");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.close(conn);
        }
    }

    private static void addBatch2() {
        String sql = "insert into robin_user ( id, name, pwd ) " + "values (?,?,?)";

        Connection conn = null;
        try {
            conn = DbUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            for(int i=0; i<100; i++){
                //替换参数
                ps.setInt(1,i);
                ps.setString(2, "name"+i);
                ps.setString(3,"123");

                //将参数添加到PreparedStatement缓存区
                ps.addBatch();

                //如果PreparedStatement对象中的SQL列表包含过多的待处理SQL语句,可能会产生OutOfMemory错误，故这里这种避免
                if((i+1)%8==0){
                    ps.executeBatch();

                    //清空本次的批量缓存
                    ps.clearBatch();
                }
            }

            //防最后一个循环，余8有剩余 这里执行剩余的
            int[] ary = ps.executeBatch();

            System.out.println(Arrays.toString(ary));
            System.out.println("oK");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.close(conn);
        }
    }

}
