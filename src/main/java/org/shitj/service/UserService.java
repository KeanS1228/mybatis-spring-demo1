package org.shitj.service;

import org.shitj.mapper.OrderMapper;
import org.shitj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;

    public String selectById() {
        return userMapper.selectById() + orderMapper.selectById();
    }

}
