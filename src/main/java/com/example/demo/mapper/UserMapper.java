package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository将类标识为bean
@Repository
@Mapper
public interface UserMapper {
    User findByName(String name);
    String findPswByName(String UserName);
    void save(User user);

    void add(User user);
    int update(User user);

    void deleteById(String userId);

    List<User> queryAll();
}

