package com.dao.model;

import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "order_payment")
public class OrderPayment {

    private String paymentNo;

    private String account;

    private BigDecimal payAmount;

    private Byte type;

    private Long createTime;

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void save(OrderPayment refundPayment) {
    }
}
