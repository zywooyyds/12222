package com.sy.service.impl;

import com.sy.entity.User;
import com.sy.exception.BusinessException;
import com.sy.mapper.UserMapper;
import com.sy.service.UserService;
import com.sy.vo.LoginVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User addUser(User user) {
        String userName = user.getName();
        String userPwd = user.getPwd();
        if (StringUtils.isBlank(userName)) {
            throw new BusinessException(HttpStatus.BAD_REQUEST,"用户名不能为空");
        }
        User user1 = userMapper.getUserByUserName(userName);
        if (Objects.nonNull(user1)) {
            throw new BusinessException(HttpStatus.BAD_REQUEST,"用户名已经存在");
        }
        if (StringUtils.isBlank(userPwd)) {
            throw new BusinessException(HttpStatus.BAD_REQUEST,"密码不能为空");
        }
        boolean addUser = userMapper.addUser(user);
        if (!addUser){
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"注册失败");
        }
        return user;
    }

    @Override
    public User login(LoginVo loginVo, String correctValidateCode) {
        String userName = loginVo.getName();
        String userPwd = loginVo.getPwd();
        String validateCode = loginVo.getValidateCode();
        if (StringUtils.isBlank(userName)) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"用户名不能为空");
        }
        User user = userMapper.getUserByUserName(userName);
        if (null == user) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"用户不存在");
        }
        if (StringUtils.isBlank(userPwd)) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"密码不能为空");
        }
        if (!StringUtils.equals(user.getPwd(),loginVo.getPwd())) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"密码错误");
        }
        if (StringUtils.isBlank(validateCode)) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"验证码不得为空");
        }
        if (!StringUtils.equalsIgnoreCase(correctValidateCode, loginVo.getValidateCode())) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"验证码不正确");
        }


        return user;
    }
}
