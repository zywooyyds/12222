package com.sy.vo;

public class MessageParams {
    private String phoneNumber;

    public MessageParams() {
    }

    public MessageParams(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MessageParams{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
