package cn.szh.dto;

import java.util.List;

/**
 * @author Zhenhao.Shi
 * @date 2023/4/24 10:30
 */
public class VitalSignsViewResponse {

    //@ApiModelProperty("id")
    private Integer id;

    //@ApiModelProperty("id信息集合")
    private List<VitalSignsViewResponse> idList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<VitalSignsViewResponse> getIdList() {
        return idList;
    }

    public void setIdList(List<VitalSignsViewResponse> idList) {
        this.idList = idList;
    }
}
