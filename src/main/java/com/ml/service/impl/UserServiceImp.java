package com.ml.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ml.bean.User;
import com.ml.mapper.UserMapper;
import com.ml.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
}
