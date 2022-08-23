package com.xzk.mapper;

import com.xzk.pojo.Users;

public interface UserMapper {
    Users queryById(int userId);
    Users queryById2(int userId);
}
