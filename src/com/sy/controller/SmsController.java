package com.sy.controller;


import com.sy.service.SmsService;
import com.sy.vo.MessageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sms")
public class SmsController {
    @Autowired
    private SmsService smsService;

    @RequestMapping(value="sendCode",method = RequestMethod.POST)
    public void getCode(@RequestBody MessageParams messageParams){
        String code = smsService.getCode(messageParams.getPhoneNumber());
        System.out.println(code);

    }
}
