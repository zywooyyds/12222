package com.sy.service.impl;

import com.montnets.mwgate.common.GlobalParams;
import com.montnets.mwgate.common.Message;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;
import com.sy.service.SmsService;
import org.springframework.stereotype.Service;

import java.util.Random;



@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public String getCode(String phoneNumber) {

            // 梦网云发送账户的账号
            String userid = "E10ETM";

            // 创建全局参数
            GlobalParams globalParams = new GlobalParams();
            // 设置请求路径
            globalParams.setRequestPath("/sms/v2/std/");
            // 设置是否需要日志 1:需要日志;0:不需要日志
            globalParams.setNeedLog(0);
            // 设置全局参数
            ConfigManager.setGlobalParams(globalParams);
            // 设置用户账号信息
            setAccountInfo();

            // 是否保持长连接
            boolean isKeepAlive = true;
            // 实例化短信处理对象
            SmsSendConn smsSendConn = new SmsSendConn(isKeepAlive);
            // 单条发送
            //singleSend(smsSendConn, userid, phoneNumber);

            //如果把上面的String改成void则需要删除下面这行********************
            String s = singleSend(smsSendConn, userid, phoneNumber);
            System.out.println(s);
            return s;

//        return "1234";
    }

    public static void setAccountInfo() {
        // 设置用户账号信息

        // 梦网云发送账户的账号
        String userid = "E10ETM";
        // 梦网云发送账户的密码
        String password = "aUt5f6";
        // 发送优先级
        int priority = 1;
        // 主IP信息
        String ipAddress1 = "api01.monyun.cn:7901";
        // 返回值
        int result = -310007;
        try {
            // 设置用户账号信息
            result = ConfigManager.setAccountInfo(userid, password, priority,
                    ipAddress1, null, null, null);
            // 判断返回结果，0设置成功，否则失败
            if (result == 0) {
                System.out.println("设置用户账号信息成功！");
            } else {
                System.out.println("设置用户账号信息失败，错误码：" + result);
            }
        } catch (Exception e) {
            // 异常处理
            e.printStackTrace();
        }
    }

    public static String singleSend(SmsSendConn smsSendConn, String userid,String phoneNumber) {
        try {
            // 参数类
            Message message = new Message();
            // 设置用户账号 指定用户账号发送，需要填写用户账号，不指定用户账号发送，无需填写用户账号
            message.setUserid(userid);
            // 设置手机号码 此处只能设置一个手机号码
            message.setMobile(phoneNumber);
            // 设置内容
            Random random = new Random();
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            int c = random.nextInt(10);
            int d = random.nextInt(10);
            String code=""+a+b+c+d;
            message.setContent("验证码："+code+" ，打死都不要告诉别人哦！");

            // 返回的流水号
            StringBuffer returnValue = new StringBuffer();
            // 返回值
            int result = -310099;
            // 发送短信
            result = smsSendConn.singleSend(message, returnValue);
            // result为0:成功
            if (result == 0) {
                System.out.println("单条发送提交成功！");
                return code;
            }
            // result为非0：失败
            else {
                System.out.println("单条发送提交失败,错误码：" + result);
                //如果把上面的String改成void则需要删除下面这行********************
                return "发送失败";
            }
        } catch (Exception e) {
            // 异常处理
            e.printStackTrace();
        }
        //如果把上面的String改成void则需要删除下面这行********************
        return "发送失败";
    }


}
