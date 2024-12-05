CREATE TABLE IF NOT EXISTS his_charge
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `creator`     varchar(64)           DEFAULT '' COMMENT '创建者',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`     varchar(64)           DEFAULT '' COMMENT '更新者',
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     bit(1)       NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint(20)   NOT NULL DEFAULT '1' COMMENT '租户编号',
    `org_id`      bigint(20)   NOT NULL DEFAULT '0' COMMENT '机构ID',
    `his_code`    varchar(255) NOT NULL DEFAULT '' COMMENT 'his编码',
    PRIMARY KEY (`id`)
);
ALTER TABLE his_charge
    COMMENT 'his收费信息';
CREATE INDEX idx_his_code ON his_charge (his_code);

CREATE TABLE IF NOT EXISTS inventory_daily
(
    `id`                bigint(20)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `creator`           varchar(64)             DEFAULT '' COMMENT '创建者',
    `create_time`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`           varchar(64)             DEFAULT '' COMMENT '更新者',
    `update_time`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`           bit(1)         NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`         bigint(20)     NOT NULL DEFAULT '1' COMMENT '租户编号',
    `org_id`            bigint(20)     NOT NULL DEFAULT '0' COMMENT '机构ID',
    `cycle_date`        date           NOT NULL COMMENT '统计周期（日）',
    `dept_id`           bigint(20)     NOT NULL COMMENT '科室ID',
    `warehouse_id`      bigint(20)     NOT NULL COMMENT '库房ID',
    `goods_id`          bigint(20)     NOT NULL COMMENT '物资ID',
    `source_goods_code` varchar(255)   NOT NULL DEFAULT '' COMMENT '物资编码',
    `supplier_id`       bigint(20)     NOT NULL COMMENT '供应商ID',
    `last_number`       decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '上期结余数量',
    `in_number`         decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期入库数量',
    `out_number`        decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期出库/消耗数量',
    `return_number`     decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期退货/退库数量',
    `current_number`    decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期结余数量',
    `inventory_number`  decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '实时库存数量',
    PRIMARY KEY (`id`)
);
ALTER TABLE inventory_daily
    COMMENT '库存日结统计表';
CREATE INDEX idx_cycle_date_warehouse_id ON inventory_daily (cycle_date, warehouse_id);

CREATE TABLE IF NOT EXISTS inventory_month
(
    `id`                bigint(20)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `creator`           varchar(64)             DEFAULT '' COMMENT '创建者',
    `create_time`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`           varchar(64)             DEFAULT '' COMMENT '更新者',
    `update_time`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`           bit(1)         NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`         bigint(20)     NOT NULL DEFAULT '1' COMMENT '租户编号',
    `org_id`            bigint(20)     NOT NULL DEFAULT '0' COMMENT '机构ID',
    `start_time`        datetime       NOT NULL COMMENT '开始时间',
    `end_time`          datetime       NOT NULL COMMENT '结束时间',
    `period`            varchar(20)    NOT NULL DEFAULT '' COMMENT '期间（年-月）',
    `dept_id`           bigint(20)     NOT NULL COMMENT '科室ID',
    `warehouse_id`      bigint(20)     NOT NULL COMMENT '库房ID',
    `level`             int(4)         NOT NULL COMMENT '仓库级别101-I 级 院内中心库 201-II 级 科室库',
    `goods_id`          bigint(20)     NOT NULL COMMENT '物资ID',
    `source_goods_code` varchar(255)   NOT NULL DEFAULT '' COMMENT '物资编码',
    `supplier_id`       bigint(20)     NOT NULL COMMENT '供应商ID',
    `price`             decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '单价（元）',
    `unit`              varchar(255)            DEFAULT '' COMMENT '单位',
    `last_number`       decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '上期结余数量',
    `in_number`         decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期入库数量',
    `out_number`        decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期出库/消耗数量',
    `return_number`     decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期退货/退库数量',
    `current_number`    decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期结余数量',
    `inventory_number`  decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '实时库存数量',
    PRIMARY KEY (`id`)
);
ALTER TABLE inventory_month
    COMMENT '库存进销存月结';
CREATE INDEX idx_period_warehouse_id_supplier_id ON inventory_month (period, warehouse_id, supplier_id);
CREATE INDEX idx_period_supplier_id ON inventory_month (period, supplier_id);

CREATE TABLE IF NOT EXISTS finance_inventory_month
(
    `id`                bigint(20)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `creator`           varchar(64)             DEFAULT '' COMMENT '创建者',
    `create_time`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`           varchar(64)             DEFAULT '' COMMENT '更新者',
    `update_time`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`           bit(1)         NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`         bigint(20)     NOT NULL DEFAULT '1' COMMENT '租户编号',
    `org_id`            bigint(20)     NOT NULL DEFAULT '0' COMMENT '机构ID',
    `start_time`        datetime       NOT NULL COMMENT '开始时间',
    `end_time`          datetime       NOT NULL COMMENT '结束时间',
    `period`            varchar(20)    NOT NULL DEFAULT '' COMMENT '期间（年-月）',
    `goods_id`          bigint(20)     NOT NULL COMMENT '物资ID',
    `source_goods_code` varchar(255)   NOT NULL DEFAULT '' COMMENT '物资编码',
    `supplier_id`       bigint(20)     NOT NULL COMMENT '供应商ID',
    `price`             decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '单价（元）',
    `unit`              varchar(255)            DEFAULT '' COMMENT '单位',
    `last_number`       decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '上期结余数量',
    `in_number`         decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期入库数量',
    `out_number`        decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期出库/消耗数量',
    `return_number`     decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期退货/退库数量',
    `current_number`    decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '本期结余数量',
    PRIMARY KEY (`id`)
);
ALTER TABLE finance_inventory_month
    COMMENT '供应商进销存月结';
CREATE INDEX idx_period_supplier_id ON finance_inventory_month (period, supplier_id);
CREATE INDEX idx_goods_id ON finance_inventory_month (goods_id);

CREATE TABLE IF NOT EXISTS inventory_in_out
(
    `id`                bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `creator`           varchar(64)           DEFAULT '' COMMENT '创建者',
    `create_time`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`           varchar(64)           DEFAULT '' COMMENT '更新者',
    `update_time`       datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`           bit(1)       NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`         bigint(20)   NOT NULL DEFAULT '1' COMMENT '租户编号',
    `org_id`            bigint(20)   NOT NULL DEFAULT '0' COMMENT '机构ID',
    `in_out_total_type` tinyint(4)   NOT NULL DEFAULT '0' COMMENT '入出库总类型0-入库 1-出库',
    `in_out_type`       tinyint(4)   NOT NULL DEFAULT '0' COMMENT '入出库类型0-手工入库 1-手工请领 2-波次补货 3-二级库退库 4-科室拒收入库；1001-手工请领出库 1002-手工出库 1003-扫码出库 1004-波次补货 1005-验收出库; 1501-退货',
    `in_out_user`       bigint(20) COMMENT '入出库人',
    `in_out_time`       datetime     NOT NULL COMMENT '入出库时间',
    `in_out_code`       varchar(255) NOT NULL DEFAULT '' COMMENT '入出库流水单号',
    `source_id`         bigint(20)   NOT NULL COMMENT '入出库来源ID',
    `source_code`       varchar(255) NOT NULL DEFAULT '' COMMENT '入出库来源单号',
    `dept_id`           bigint(20)   NOT NULL COMMENT '科室ID',
    `warehouse_id`      bigint(20)   NOT NULL COMMENT '库房ID',
    `level`             int(4)       NOT NULL COMMENT '仓库级别101-I 级 院内中心库 201-II 级 科室库',
    PRIMARY KEY (`id`)
);
ALTER TABLE inventory_in_out
    COMMENT '库存入出库流水';
CREATE INDEX idx_total_type_warehouse_id_type ON inventory_in_out (in_out_total_type, warehouse_id, in_out_type);

CREATE TABLE IF NOT EXISTS inventory_in_out_det
(
    `id`                bigint(20)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `creator`           varchar(64)             DEFAULT '' COMMENT '创建者',
    `create_time`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`           varchar(64)             DEFAULT '' COMMENT '更新者',
    `update_time`       datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`           bit(1)         NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`         bigint(20)     NOT NULL DEFAULT '1' COMMENT '租户编号',
    `org_id`            bigint(20)     NOT NULL DEFAULT '0' COMMENT '机构ID',
    `in_out_id`         bigint(20)     NOT NULL COMMENT '入出库ID',
    `in_out_number`     decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '入出数量',
    `goods_id`          bigint(20)     NOT NULL COMMENT '物资ID',
    `source_goods_code` varchar(255)   NOT NULL DEFAULT '' COMMENT '物资编码',
    `product_type`      varchar(255)   NOT NULL COMMENT '产品类型',
    `goods_type`        tinyint(4)     NOT NULL COMMENT '物资属性(1高值 2低值)',
    `settlement`        varchar(255)   NOT NULL DEFAULT '' COMMENT '结算方式',
    `price`             decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '单价（元）',
    `unit`              varchar(255)            DEFAULT '' COMMENT '单位',
    `supplier_id`       bigint(20)     NOT NULL COMMENT '供应商ID',
    PRIMARY KEY (`id`)
);
ALTER TABLE inventory_in_out_det
    COMMENT '库存入出库流水明细';
CREATE INDEX idx_in_out_id ON inventory_in_out_det (in_out_id);
CREATE INDEX idx_goods_id ON inventory_in_out_det (goods_id);

CREATE TABLE IF NOT EXISTS inventory_in_out_code
(
    `id`               bigint(20)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `creator`          varchar(64)             DEFAULT '' COMMENT '创建者',
    `create_time`      datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`          varchar(64)             DEFAULT '' COMMENT '更新者',
    `update_time`      datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`          bit(1)         NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`        bigint(20)     NOT NULL DEFAULT '1' COMMENT '租户编号',
    `org_id`           bigint(20)     NOT NULL DEFAULT '0' COMMENT '机构ID',
    `in_out_det_id`    bigint(20)     NOT NULL COMMENT '入出库明细ID',
    `in_out_number`    decimal(10, 4) NOT NULL DEFAULT '0.0000' COMMENT '入出数量',
    `barcode`          varchar(255)            DEFAULT '' COMMENT 'SPD条码',
    `goods_batch_id`   bigint(20)     NOT NULL COMMENT '批号ID',
    `batch_code`       varchar(255)   NOT NULL COMMENT '批号',
    `expiration_date`  datetime                DEFAULT NULL COMMENT '有效日期',
    `manufacture_date` datetime                DEFAULT NULL COMMENT '生产日期',
    PRIMARY KEY (`id`)
);
ALTER TABLE inventory_in_out_code
    COMMENT '库存入出库流水条码';
CREATE INDEX idx_in_out_det_id ON inventory_in_out_code (in_out_det_id);
