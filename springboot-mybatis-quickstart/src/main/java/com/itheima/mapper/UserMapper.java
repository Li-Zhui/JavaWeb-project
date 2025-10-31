package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象）
        //并且会自动将该实现类对象存入IOC容器 - bean
public interface UserMapper {
    /**
     * 查询所有用户
     */
    @Select("select id, username, password, name, age from user")
    public List<User> findAll();

    /**
     * 根据id删除用户
     */
    @Delete("delete from user where id = #{id}")
    public Integer deleteById(Integer id);
}
