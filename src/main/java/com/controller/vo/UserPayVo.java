package com.controller.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserPayVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;

    private BigDecimal payAmount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
}
