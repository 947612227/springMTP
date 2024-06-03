package com.avia.mtp.model;

public class ChangePasswordRequest {
    private String phoneNumber;

    private String oldPassword; // 当前密码

    private String newPassword;
    private String rePassword;  //确认密码

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRepassword(String rePassword) {
        this.rePassword = rePassword;
    }




}
