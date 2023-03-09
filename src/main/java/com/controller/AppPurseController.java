package com.controller;

import com.controller.vo.UserPayVo;
import com.controller.vo.UserPaymentQryVo;
import com.controller.vo.UserRefundVo;
import com.dao.model.OrderPayment;
import com.service.AppPurseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("app/purse")
public class AppPurseController {

    @Resource
    private AppPurseService appPurseService;

    @GetMapping("/account/amount")
    private BigDecimal getAccountAmount(String userId){
           //log
          return appPurseService.getAccountAmount(userId);
    }

    @PostMapping("/pay")
    private void pay(@RequestBody UserPayVo userPayVo){

        appPurseService.pay(userPayVo);

    }

    @PostMapping("/refund")
    private void refund(@RequestBody UserRefundVo userRefundVo){

        appPurseService.refund(userRefundVo);

    }

    @GetMapping("/payment/list")
    private List<OrderPayment> payments(UserPaymentQryVo qryVo){

       return appPurseService.payments(qryVo);

    }
}
