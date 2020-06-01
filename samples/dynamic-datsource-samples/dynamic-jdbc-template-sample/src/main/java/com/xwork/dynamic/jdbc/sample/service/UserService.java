package com.xwork.dynamic.jdbc.sample.service;

import com.xwork.dynamic.jdbc.sample.entity.YtxLogin;

import java.util.List;

public interface UserService {

    void add(YtxLogin user);

    List selectFromDs();

    List selectFromDsGroup();
}