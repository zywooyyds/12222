package com.sy.mapper;

import com.sy.entity.User;

public interface UserMapper {
    User getUserByUserName(String name);
    boolean addUser(User user);
}
