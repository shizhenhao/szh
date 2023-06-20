package cn.szh.java.basic.nubomed;

import java.util.Arrays;

/**
 * navicat中复制表结构信息，分开输出信息，以方便粘贴到整理的数据库文档中，免去一个一个复制粘贴
 *
 * @author Zhenhao.Shi
 * @date 2022/2/23 20:33
 */
public class NavicatTable {

    public static void main(String[] args) {
        String str = "  `i_operation_id` int NOT NULL AUTO_INCREMENT COMMENT '手术ID',\n" +
                "  `s_peration_apply_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手术申请单号：导入手术信息时,HIS或手麻系统手术信息唯一关键字',\n" +
                "  `i_patient_ID` int NOT NULL COMMENT '病人ID：病人ID',\n" +
                "  `i_dept_ID` int NOT NULL COMMENT '科室ID',\n" +
                "  `s_dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '科室名称',\n" +
                "  `s_bed_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '床号编码',\n" +
                "  `s_bed_num` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '床号',\n" +
                "  `i_operation_dept` int NOT NULL COMMENT '手术科室ID',\n" +
                "  `s_operation_dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手术科室名称',\n" +
                "  `s_room_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手术间ID',\n" +
                "  `s_room_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手术间名称',\n" +
                "  `s_operation_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手术编码',\n" +
                "  `s_operation_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手术名称',\n" +
                "  `d_operap_time` datetime NOT NULL COMMENT '手术预约时间',\n" +
                "  `d_star_time` datetime DEFAULT NULL COMMENT '手术开始时间',\n" +
                "  `d_end_time` datetime DEFAULT NULL COMMENT '手术结束时间',\n" +
                "  `s_anesthesia_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '麻醉方式编码',\n" +
                "  `s_anesthesia_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '麻醉方式名称',\n" +
                "  `i_state` smallint NOT NULL COMMENT '手术状态标志：-1:放弃手术|0:未开始|1:进行中|2:手术完成|3:复苏中|4:复苏完成|5:已安排|10:即将送出 |12:即将接回',\n" +
                "  `i_check` smallint NOT NULL COMMENT '核对状态：0 未核对 |1 已核对',\n" +
                "  `i_room_nurse` int NOT NULL COMMENT '手术间护士ID',\n" +
                "  `i_operation_doctor` int DEFAULT '0' COMMENT '手术医生ID',\n" +
                "  `i_anesthesia_doctor` int DEFAULT '0' COMMENT '麻醉医生ID',\n" +
                "  `s_operation_index` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手术台次',\n" +
                "  `d_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',\n" +
                "  `i_oper_type` smallint NOT NULL DEFAULT '0' COMMENT '手术紧急类型(1:择期 2:急诊)',\n" +
                "  `i_oper_painless` smallint NOT NULL DEFAULT '0' COMMENT '是否无痛分娩（0否1是）'";

        String[] split = str.split("',");
        Arrays.stream(split).forEach(item -> {
            String[] s = item.split(" ");
            System.out.println(s[2].substring(1, s[2].length() - 1));
        });

        System.out.println("字段类型11111111111111111111111：");
        Arrays.stream(split).forEach(item -> {
            String[] s = item.split(" ");
            System.out.println(s[3]);
        });

        System.out.println("解释2222222222222222222222222：");
        Arrays.stream(split).forEach(item -> {
            String[] s = item.split("COMMENT");
            System.out.println(s[1].replace(" '", "").replace("'", ""));
        });
    }

}
