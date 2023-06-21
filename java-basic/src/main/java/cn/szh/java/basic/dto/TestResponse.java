package cn.szh.java.basic.dto;

import java.util.List;

/**
 * @author Zhenhao.Shi
 * @date 2023/4/24 10:30
 */
public class TestResponse {

    //@ApiModelProperty("id")
    private Integer id;

    private String name;

    //@ApiModelProperty("id信息集合")
    private List<TestResponse> idList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestResponse> getIdList() {
        return idList;
    }

    public void setIdList(List<TestResponse> idList) {
        this.idList = idList;
    }
}
