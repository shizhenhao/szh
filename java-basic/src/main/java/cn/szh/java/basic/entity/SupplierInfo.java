package cn.szh.java.basic.entity;/*

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.nubomed.nbiot.common.util.ValidationGroups;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

*/
/**
 * <p>
 * 供应商信息表
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2022-10-18
 *//*

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@TableName("supplier_info")
@ApiModel(value = "SupplierInfo对象", description = "供应商信息表")
public class SupplierInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "供应商ID不能为空", groups = ValidationGroups.Update.class)
    @ApiModelProperty("供应商ID")
    @TableId(value = "supplier_id", type = IdType.AUTO)
    private Integer supplierId;

    @Excel(name = "供应商名称", orderNum = "1", width = 25)
    @NotBlank(message = "供应商名称不能为空", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    @ApiModelProperty("供应商名称")
    private String supplierName;

    @Excel(name = "统一社会信用代码", orderNum = "2", width = 25)
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    @ApiModelProperty("统一社会信用代码")
    private String creditCode;

    @Excel(name = "联系人", orderNum = "3", width = 20)
    @NotBlank(message = "联系人不能为空", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    @ApiModelProperty("联系人")
    private String contact;

    @Excel(name = "联系电话", orderNum = "4", width = 20)
    @NotBlank(message = "联系电话不能为空", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    @ApiModelProperty("联系电话")
    private String telephone;

    @Excel(name = "供应商类型", orderNum = "5", replace = {"设备供应商_0", "维保服务商_1", "生产厂家_2"}, width = 25)
    @ApiModelProperty("供应商类型0-设备供应商 1-维保服务商 2-生产厂家")
    @NotNull(message = "供应商类型不能为空", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    @Min(value = 0, message = "供应商类型参数错误", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    @Max(value = 2, message = "供应商类型参数错误", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    private Integer supplierType;

    @Excel(name = "状态", orderNum = "6", replace = {"停用_0", "启用_1"}, width = 10)
    @NotNull(message = "状态参数不能为空", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    @Min(value = 0, message = "状态参数错误", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    @Max(value = 1, message = "状态参数参数错误", groups = {ValidationGroups.Insert.class, ValidationGroups.Update.class})
    @ApiModelProperty("状态0-停用 1-启用")
    private Integer state;


}
*/
