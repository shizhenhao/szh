-- 新增数据库，下述库名需自行更改下
CREATE DATABASE `ahfy_spd_prod` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

-- 增量SLQ新增语句时，下述这些表不应该插入ID值，因为可能现场已经自行新增使用了这个ID值
-- system_role角色信息表，下述语句为示例
INSERT INTO `system_role` (`id`, `name`, `code`, `sort`, `data_scope`, `data_scope_dept_ids`, `status`, `type`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`, `business_type`) VALUES (NULL, '手术室专员', '手术室专员', 11, 1, '', 0, 2, '', '1', NOW(), '1', NOW(), b'0', 1, 3);

-- shyadmin md5加密后的密码为	4bf915314a191d9051367438dbb52e8f
-- 123456   md5加密后的密码为	e10adc3949ba59abbe56e057f20f883e

-- SQL-打印模板-不要直接更新 SET content = '';
--              要删除再新增，因为出现了更新内容中有 \n ，mysql存为了换行

-- BigDecimal类型的字段统一为 decimal(20,4) NOT NULL DEFAULT '0.0000' COMMENT '数量'