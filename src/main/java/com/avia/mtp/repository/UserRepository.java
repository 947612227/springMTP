package com.avia.mtp.repository;

import com.avia.mtp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 根据手机号查询用户是否已经存在
    boolean existsByPhoneNumber(String phoneNumber);

    // 根据手机号和密码查询用户信息
    Optional<User> findByPhoneNumberAndPassword(String phoneNumber, String password);

    // 根据手机号查询用户信息
    Optional<User> findByPhoneNumber(String phoneNumber);
}
