package com.util;

public enum OrderPaymentTypeEnum {

    PAY((byte)1,"消费"),
    REFUND((byte)2,"退款"),
    RECHARGE((byte)3,"充值"),
    WITHDRAW((byte)4 ,"提现");


    private Byte status;
    private String desc;

    OrderPaymentTypeEnum(Byte status , String desc){
        this.status = status;
        this.desc = desc;
    }

    public Byte getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
