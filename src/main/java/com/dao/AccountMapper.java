package com.dao;

import com.dao.model.Account;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

public interface AccountMapper extends Mapper<Account> {
    Account getAccount(String account);

    void update(String account, BigDecimal refundAmount);

    void update(Account account);
}
