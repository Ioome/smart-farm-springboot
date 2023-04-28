package com.farm;

import com.farm.entity.po.FarmAdmin;
import com.farm.mapper.FarmAdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * @name: AnimatedSmartFarmTest
 * @author: sutton
 * @date: 2023-04-27 11:50
 * @description: AnimatedSmartFarmTest
 */
@SpringBootTest
class AnimatedSmartFarmTest {
    @Autowired
    private FarmAdminMapper farmAdminMapper;

    @Test
    void test () {
        List<FarmAdmin> users = farmAdminMapper.selectList(null);
        //为我这个类写一个断言
        assert users.size() > 0;
    }

    @Test
    void testPassword () {
        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = cryptPasswordEncoder.encode("9978@wzb");
        System.out.printf("加密后的密码是：%s", encode);
    }


}
