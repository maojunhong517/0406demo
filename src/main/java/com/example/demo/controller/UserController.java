package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(String userName,String passWord){
        User loginUser = new User();
        loginUser.setUserName(userName);
        loginUser.setPassWord(passWord);
        return userService.login(loginUser);
    }

    @GetMapping("/regist")
    public String regist(String userName,String passWord){
        User reGistUser = new User();
        reGistUser.setUserName(userName);
        reGistUser.setPassWord(passWord);
        return userService.regist(reGistUser);
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(String userName,String passWord){
        User addUser = new User();
        addUser.setUserName(userName);
        addUser.setPassWord(passWord);
        return userService.add(addUser);
    }
    @PostMapping("/update")
    @ResponseBody
    public String update(String id,String userName,String passWord){
        User updateUser = new User();
        updateUser.setId(id);
        updateUser.setUserName(userName);
        updateUser.setPassWord(passWord);
        return userService.update(updateUser);
    }

    @PostMapping("/deleteById")
    @ResponseBody
    public String deleteById(String id){
        return userService.deleteById(id);
    }

    @PostMapping("/queryAll")
    @ResponseBody
    public List<User> queryAll(){
        return userService.queryAll();
    }

}

