package com.avia.mtp.service;
import com.avia.mtp.model.User;
import com.avia.mtp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String, Object> getUserDetails(Long userId) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            response.put("code", 200);
            response.put("status", "success");
            response.put("data", user.get());
        } else {
            response.put("code", 200);
            response.put("status", "error");
            response.put("message", "User not found");
        }
        return response;
    }
    @Override
    @Transactional
    public Map<String, Object> signUp(User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 检查手机号是否已经被注册
            if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
                response.put("code", "200");
                response.put("status", "error");
                response.put("message", "手机号已被注册");
                return response;
            }

            // 保存用户到数据库
            userRepository.save(user);
            // 返回成功响应
            response.put("code", "200");
            response.put("status", "success");
            response.put("message", "注册成功");
            response.put("data", user);
            return response;
        } catch (Exception e) {
            // 处理异常情况
            response.put("code", "200");
            response.put("status", "error");
            response.put("message", "注册失败");
            return response;
        }
    }



    @Override
    public Map<String, Object> signIn(String phoneNumber, String password) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> user = userRepository.findByPhoneNumberAndPassword(phoneNumber, password);

        if (user.isPresent()) {
            response.put("code", "200");
            response.put("status", "success");
            response.put("message", "登录成功");
            response.put("data", user.get());
        } else {
            response.put("code", "200");
            response.put("status", "error");
            response.put("message", "手机号或密码错误");
        }
        return response;
    }

    @Override
    @Transactional
    public Map<String, Object> updateUserInfo(String phoneNumber, String password, String name, Integer age, String nickname, String avatarUrl) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> userOptional = userRepository.findByPhoneNumberAndPassword(phoneNumber, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // 更新用户信息
            if (name != null) user.setName(name);
            if (age != null) user.setAge(age); // 假设年龄是整数
            if (nickname != null) user.setNickname(nickname);
            if (avatarUrl != null) user.setAvatarUrl(avatarUrl);
            User updatedUser = userRepository.save(user); // 保存更新后的用户信息

            response.put("code", "200");
            response.put("status", "success");
            response.put("message", "用户信息更新成功");
            response.put("user", updatedUser); // 将更新后的用户信息添加到响应中
        } else {
            response.put("code", "200");
            response.put("status", "error");
            response.put("message", "手机号或密码错误");
        }
        return response;
    }

    @Override
    public Map<String, Object> changePassword(String phoneNumber, String oldPassword, String newPassword, String rePassword) {
        Map<String, Object> response = new HashMap<>();

        // 根据手机号查询用户
        Optional<User> optionalUser = userRepository.findByPhoneNumber(phoneNumber);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // 验证旧密码是否正确
            if (!user.getPassword().equals(oldPassword)) {
                response.put("status", "error");
                response.put("message", "旧密码错误");
                return response;
            }
            // 验证两次输入的新密码是否一致
            if (!newPassword.equals(rePassword)) {
                response.put("status", "error");
                response.put("message", "两次输入的新密码不一致");
                return response;
            }
            // 更新用户密码
            user.setPassword(newPassword);
            userRepository.save(user);
            response.put("status", "success");
            response.put("message", "密码修改成功");
        } else {
            response.put("status", "error");
            response.put("message", "用户不存在");
        }
        return response;
    }

}
