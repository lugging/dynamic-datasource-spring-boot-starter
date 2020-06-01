package com.xwork.dynamic.jdbc.sample.test;

import com.xwork.dynamic.jdbc.sample.Application;
import com.xwork.dynamic.jdbc.sample.entity.YtxLogin;
import com.xwork.dynamic.jdbc.sample.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    private Random random = new Random();

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        YtxLogin user = new YtxLogin();
        user.setUser_id(random.nextInt());
        user.setCreate_time(new Date());
        userService.add(user);
    }

    @Test
    public void selectUsersFromDs() {
        List lists = userService.selectFromDs();
        System.out.println(lists);
    }

    @Test
    public void selectUserFromDsGroup() {
        List lists = userService.selectFromDsGroup();
        System.out.println(lists);
    }
}