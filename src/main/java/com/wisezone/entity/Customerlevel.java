package com.wisezone.entity;

import java.io.Serializable;

/**
 * base_customerlevel
 * @author 
 */
public class Customerlevel implements Serializable {
    /**
     * 客户等级编号
     */
    private Integer id;

    /**
     * 客户等级名称
     */
    private String name;

    /**
     * 状态
     */
    private Integer state;

    private static final long serialVersionUID = 1L;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}