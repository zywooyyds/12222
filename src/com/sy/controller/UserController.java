package com.sy.controller;

import com.sy.entity.User;
import com.sy.service.UserService;
import com.sy.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

import static com.sy.constant.BusinessConstant.SESSION_VALIDATE_CODE_NAME;


@RequestMapping("users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;
    @RequestMapping(value = "regist",method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        User user1 = userService.addUser(user);
        return user1;
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public User login(@RequestBody LoginVo loginVo ){
        String correctValidateCode = "6666";
        User user = userService.login(loginVo, correctValidateCode);
        return user;
    }
}
