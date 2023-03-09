package com.controller.vo;

import java.io.Serializable;

public class UserPaymentQryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pageSize = 1;

    private Integer pageNum = 20;

    private String account;

    //时间筛选


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
