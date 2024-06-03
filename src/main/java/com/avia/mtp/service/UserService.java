package com.avia.mtp.service;

import com.avia.mtp.model.User;

import java.util.Map;

public interface UserService {
    Map<String, Object> getUserDetails(Long userId);

    Map<String, Object> signUp(User user);
    Map<String, Object> signIn(String phoneNumber, String password);

    Map<String, Object> changePassword(String phoneNumber, String oldPassword, String newPassword, String rePassword);

//    Map<String, Object> verifyOldPassword(String phoneNumber, String oldPassword);

    Map<String, Object> updateUserInfo(String phoneNumber, String password, String name, Integer age, String nickname, String avatarUrl);

}
