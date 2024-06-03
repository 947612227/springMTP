package com.avia.mtp.controller;

import com.avia.mtp.model.ChangePasswordRequest;
import com.avia.mtp.model.LoginRequest;
import com.avia.mtp.model.User;
import com.avia.mtp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info/detail")
    public Map<String, Object> getUserDetails(@RequestParam("userId") Long userId) {
        return userService.getUserDetails(userId);
    }

    @PostMapping("/op/signIn")
    public Map<String, Object> signIn(@RequestBody LoginRequest loginRequest) {
        String phoneNumber = loginRequest.getPhoneNumber();
        String password = loginRequest.getPassword();
        return userService.signIn(phoneNumber, password);
    }

    @PostMapping("/op/updateUserInfo")
    public Map<String, Object> updateUserInfo(@RequestBody LoginRequest loginRequest) {
        String phoneNumber = loginRequest.getPhoneNumber();
        String password = loginRequest.getPassword();
        String name = loginRequest.getName();
        Integer age = loginRequest.getAge();
        String nickname = loginRequest.getNickname();
        String avatarUrl = loginRequest.getAvatarUrl();

        return userService.updateUserInfo(phoneNumber, password, name, age, nickname, avatarUrl);
    }


    @PostMapping("/op/signup")
    public Map<String, Object> signUp(@RequestBody User user) {
        return userService.signUp(user);
    }


    @PostMapping("/op/changePassword")
    public Map<String, Object> changePassword(@RequestBody ChangePasswordRequest request) {
        String phoneNumber = request.getPhoneNumber();
        String oldPassword = request.getOldPassword();
        String newPassword = request.getNewPassword();  // todo
        String rePassword = request.getRePassword();

        return userService.changePassword(phoneNumber, oldPassword, newPassword, rePassword);
    }



}
