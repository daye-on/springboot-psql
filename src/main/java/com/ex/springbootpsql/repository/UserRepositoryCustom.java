package com.ex.springbootpsql.repository;

import com.ex.springbootpsql.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> findUserAll();
    User findUserBySeq(Long seq);

    @Transactional
    void updateUser(Long seq, String updateId);

    @Transactional
    void deleteUser(Long seq);

    @Transactional
    void deleteUserAll();
}
