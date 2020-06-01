package com.xwork.dynamic.jdbc.sample.service.impl;

import com.xwork.dynamic.jdbc.sample.entity.YtxLogin;
import com.xwork.dynamic.jdbc.sample.service.UserService;
import com.yuntongxun.xwork.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(YtxLogin user) {
        jdbcTemplate.update("INSERT INTO ytx_login (user_id,create_time) VALUES(?, ?)",
                new Object[]{user.getUser_id(), user.getCreate_time()});
    }

    @DS("slave_1")
    @Override
    public List selectFromDs() {
        return jdbcTemplate.queryForList("SELECT * FROM ytx_login");
    }

    @DS("slave")
    @Override
    public List selectFromDsGroup() {
        return jdbcTemplate.queryForList("SELECT * FROM ytx_login");
    }
}