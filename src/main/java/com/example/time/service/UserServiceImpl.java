package com.example.time.service;

import com.example.time.mapper.UserMapper;
import com.example.time.pojo.User;
import com.example.time.pojo.UserExample;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteUserById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findUserById(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> findUserByUsername(String username) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public List<User> findUserByUsernameAndPassword(String username, String password) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample
                .createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public List<User> findAllUser() {
        UserExample userExample=new UserExample();
        userExample.createCriteria()
                .getAllCriteria();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
}
