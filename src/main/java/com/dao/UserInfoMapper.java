package com.dao;

import com.dao.model.UserInfo;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {
    UserInfo getUser(String userId);
}
