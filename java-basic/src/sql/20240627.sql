UPDATE base_wh_goods_third AS bwgt
INNER JOIN base_warehouse AS bw ON bwgt.warehouse_id = bw.id
SET bwgt.org_id = bw.org_id;
