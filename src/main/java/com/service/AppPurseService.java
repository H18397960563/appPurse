package com.service;

import com.controller.vo.UserPayVo;
import com.controller.vo.UserPaymentQryVo;
import com.controller.vo.UserRefundVo;
import com.dao.model.OrderPayment;

import java.math.BigDecimal;
import java.util.List;

public interface AppPurseService {

    BigDecimal getAccountAmount(String userId);

    void pay(UserPayVo userPayVo);

    void refund(UserRefundVo userRefundVo);

    List<OrderPayment> payments(UserPaymentQryVo qryVo);
}
