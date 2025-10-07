package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    //使用包装类而不是基本数据类型，因为基本数据类型都有默认值，而包装类没有
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
}
