package com.service.impl;

import com.controller.vo.UserPayVo;
import com.controller.vo.UserPaymentQryVo;
import com.controller.vo.UserRefundVo;
import com.dao.AccountMapper;
import com.dao.OrderMapper;
import com.dao.OrderPaymentMapper;
import com.dao.UserInfoMapper;
import com.dao.model.Account;
import com.dao.model.Order;
import com.dao.model.OrderPayment;
import com.dao.model.UserInfo;
import com.service.AppPurseService;
import com.util.OrderPaymentTypeEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppPurseServiceImpl implements AppPurseService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderPaymentMapper orderPaymentMapper;

    @Resource
    private AccountMapper accountMapper;

    @Override
    public BigDecimal getAccountAmount(String userId) {
        UserInfo user = userInfoMapper.getUser(userId);
        if(user == null){
            //log.warn()
            return BigDecimal.valueOf(-1);
        }
        Account account = accountMapper.getAccount(user.getAccount());
        if(account == null){
            return BigDecimal.valueOf(-1);
        }

        return account.getAmount();
    }

    @Override
    public void pay(UserPayVo userPayVo) {
        Account account = accountMapper.getAccount(userPayVo.getAccount());
        if(account == null){
           //账号不存在
            return;
        }

        if(account.getAmount().compareTo(userPayVo.getPayAmount()) < 0){
            //余额不足
            return;
        }

        Order order = new Order();
        order.setAccount(userPayVo.getAccount());
        order.setCreateTime(System.currentTimeMillis());
        order.setPrice(userPayVo.getPayAmount());
        order.setPayTime(System.currentTimeMillis());
        order.setOrderNo("ONO"+UUID.randomUUID());
        String paymentNo = "PNO"+UUID.randomUUID();
        order.setPaymentNo(paymentNo);

        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setPaymentNo(paymentNo);
        orderPayment.setAccount(userPayVo.getAccount());
        orderPayment.setPayAmount(userPayVo.getPayAmount());
        orderPayment.setCreateTime(System.currentTimeMillis());
        orderPayment.setType(OrderPaymentTypeEnum.PAY.getStatus());

        account.setAmount(account.getAmount().subtract(userPayVo.getPayAmount()));
        //todo 事务方法 pay（）
        pay(order , orderPayment , account);

    }

    @Override
    public void refund(UserRefundVo userRefundVo) {
        List<OrderPayment> orderPayments = orderPaymentMapper.listPaymentByNo(userRefundVo.getPaymentNo());
        if(CollectionUtils.isEmpty(orderPayments)){
            return;
        }

        List<OrderPayment> refundList = orderPayments.stream().filter(orderPayment -> {
            return OrderPaymentTypeEnum.REFUND.getStatus().equals(orderPayment.getType());
        }).collect(Collectors.toList());

        if(!CollectionUtils.isEmpty(refundList)){
            //存在退款不需再退款
            return;
        }

        OrderPayment orderPayment = orderPayments.get(0);

        if(OrderPaymentTypeEnum.PAY.getStatus().equals(orderPayment.getType())){
                 //不是消费类型不可以退款
            return;
        }

        if(orderPayment.getPayAmount().compareTo(userRefundVo.getRefundAmount()) != 0){
            //金额不对等不可以退款
            return;
        }

        accountMapper.update(userRefundVo.getAccount() , userRefundVo.getRefundAmount());
        OrderPayment refundPayment = new OrderPayment();
        refundPayment.setType(OrderPaymentTypeEnum.REFUND.getStatus());
        refundPayment.setCreateTime(System.currentTimeMillis());
        refundPayment.setPaymentNo(orderPayment.getPaymentNo());
        refundPayment.setAccount(userRefundVo.getAccount());
        refundPayment.setPayAmount(userRefundVo.getRefundAmount());
        orderPayment.save(refundPayment);
    }

    @Override
    public List<OrderPayment> payments(UserPaymentQryVo qryVo) {
        //todo PagedHelper分页查询

        return new ArrayList<>();
    }

    @Transactional
    public void pay(Order order, OrderPayment orderPayment, Account account) {

         orderMapper.save(order);
         orderPaymentMapper.save(orderPayment);
         accountMapper.update(account);
    }

}
