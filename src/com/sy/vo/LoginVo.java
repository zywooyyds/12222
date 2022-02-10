package com.sy.vo;

public class LoginVo {
    private String name;
    private String pwd;
    private String validateCode;

    public LoginVo() {
    }

    public LoginVo(String name, String pwd, String validateCode) {
        this.name = name;
        this.pwd = pwd;
        this.validateCode = validateCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", validatecode='" + validateCode + '\'' +
                '}';
    }
}
