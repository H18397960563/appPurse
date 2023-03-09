package com.dao;

import com.dao.model.Order;
import tk.mybatis.mapper.common.Mapper;

public interface OrderMapper extends Mapper<Order> {
    void save(Order order);
}
