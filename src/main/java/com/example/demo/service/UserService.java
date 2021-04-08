package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.util.List;

@Service
public class UserService {

    //该注解可以对类成员变量、方法以及构造函数进行标注，完成自动装配工作
    @Autowired
    UserMapper userMapper;

    public String login(User user){
        //登录逻辑函数
        try{
            User userExistN = userMapper.findByName(user.getUserName());
            if(userExistN!=null){
                String userExistP = userMapper.findPswByName(user.getUserName());
                if(userExistP.equals(user.getPassWord())){
//                    return user.getUsername()+"登录成功，欢迎您!";
                    return "personMessage";
                }else {
                    return "err";
                }
            }else {
                return "err";
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String regist(User user){
        //注册逻辑函数
        try {
            User userExist = userMapper.findByName(user.getUserName());
            if (user.getUserName().equals("")){
                return "err";
            }else if (user.getPassWord().equals("")){
                return "err";
            }else if (userExist!=null){
                return "err";
            }else{
                user.setId(getUUID());
                userMapper.save(user);
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }

    }
    //添加人员
    public String add(User user){
        user.setId(getUUID());
        userMapper.add(user);
        return user.getUserName()+"添加成功!";
    }
    //修改人员
    public String update(User user){
        int n = userMapper.update(user);
        if(n>0) {
            return user.getUserName() + "修改成功!";
        } else {
            return "修改失败";
        }
    }
    //根据id编号删除人员
    public String deleteById(String id){
        userMapper.deleteById(id);
        return "删除成功";
    }
    //查询所有人员
    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }
}

