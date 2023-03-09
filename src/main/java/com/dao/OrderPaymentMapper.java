package com.dao;

import com.dao.model.OrderPayment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderPaymentMapper extends Mapper<OrderPayment> {
    List<OrderPayment> listPaymentByNo(String paymentNo);

    void save(OrderPayment orderPayment);
}
