package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息控制器
 */
@RestController
public class UserController {
   /* @RequestMapping("/list")
    public List<User> list() throws  Exception {
        //1.加载并读取user.txt文件，获取用户数据
        //InputStream in = new FileInputStream(new File("D:\\code\\idea\\Web-project\\springboot-web-01\\src\\main\\resources"));
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, "UTF-8", new ArrayList<>());

        //2.解析用户信息，封装为User对象 -> List集合中
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.valueOf(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.valueOf(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();

        //3.返回数据（json）
        return  userList;
        //服务器在将这个对象或者集合响应给客户端是，会先将其转化为 json格式
        //再响应给客户端
    }*/

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list() throws  Exception {
        //1.调用service层方法，获取用户数据
        List<User> userList = userService.findAll();

        //2.返回数据（json）
        return  userList;
        //服务器在将这个对象或者集合响应给客户端是，会先将其转化为 json格式
        //再响应给客户端
    }
}
