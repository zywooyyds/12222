package com.sy.service;

import com.sy.entity.User;
import com.sy.vo.LoginVo;

public interface UserService {
    User addUser(User user);
    User login(LoginVo loginVo, String correctValidateCode);
}
