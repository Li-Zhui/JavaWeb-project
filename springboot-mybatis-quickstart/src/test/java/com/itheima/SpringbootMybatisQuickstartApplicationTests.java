package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //SpringBoot单元测试的注解 - 当前测试类中的测试方法运行时，
                // 会启动springboot项目 - 一旦启动IOC容器就创建好了
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询所有用户
     */
    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    /**
     *测试删除
     */
    @Test
    public void testDeleteById() {
        Integer i = userMapper.deleteById(5);
        System.out.println("执行完毕后影响的记录数：" + i);
    }

    /**
     * 测试添加用户
     */
    @Test
    public void testInsert() {
        User user = new User(null,"gaoyuanyuan","112445","高圆圆",18);
        userMapper.insert(user);
        //执行之后数据库中id自增为6（虽然4和5已经被删除了但是它存在过）
    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdate() {
        User user = new User(1,"zhouyu","112445","周瑜",20);
        userMapper.update(user);
    }

    /**
     * 测试查询用户
     */
    @Test
    public void testFindByUsernameAndPassword(){
        User user = userMapper.findByUsernameAndPassword("zhouyu", "112445");
        System.out.println(user);
    }
}
