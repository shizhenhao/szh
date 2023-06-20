package cn.szh.service.impl;/*
package cn.service.impl;

import cn.entity.SupplierInfo;
import cn.service.IStreamService;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

*/
/**
 * @author Zhenhao.Shi
 * @date 2023/1/4 13:54
 *//*

public class StreamServiceImpl implements IStreamService {

    @Override
    public String getNames(String supplierIds, List<SupplierInfo> supplierInfoList) {
        if (StringUtils.isBlank(supplierIds)) {
            return StringPool.EMPTY;
        }

        //map时每一个元素转换得到一个值，null也为值，然后可通过去除null达到效果；不知是否有更好方法得到这种效果
        return Arrays.stream(supplierIds.split(StringPool.COMMA))
                .map(i -> {
                    SupplierInfo supplierInfo = supplierInfoList.parallelStream()
                            .filter(sup -> Objects.equals(sup.getSupplierId().toString(), i)).findAny().orElse(null);
                    return supplierInfo == null ? null : supplierInfo.getSupplierName();
                })
                .filter(Objects::nonNull).collect(Collectors.joining("；"));
    }

}
*/
