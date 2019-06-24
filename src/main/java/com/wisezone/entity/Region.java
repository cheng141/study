package com.wisezone.entity;

import java.io.Serializable;

/**
 * base_region
 * @author 
 */
public class Region implements Serializable {
    /**
     * 区域编号
     */
    private Integer regionId;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 状态  0删除  1正常
     */
    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}