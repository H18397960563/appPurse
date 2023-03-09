package com.controller.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserRefundVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;

    private String paymentNo;

    private BigDecimal refundAmount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }
}
