package com.xcgn.marry.business.service.serviceImpl;

import com.xcgn.marry.business.model.User;
import com.xcgn.marry.business.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User findByUsername(String userName) {
        return null;
    }
}
