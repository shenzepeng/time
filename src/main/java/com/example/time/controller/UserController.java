package com.example.time.controller;

import com.example.time.pojo.User;
import com.example.time.service.UserService;
import com.example.time.uitls.SzpJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("use接口")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation("注册新的用户")
    @PostMapping("/insertUser.action")
    public SzpJsonResult insertUser(@RequestBody User user){
        if (user.getPassword()!=null&&user.getUsername()!=null){
            userService.insertUser(user);
            return SzpJsonResult.ok();
        }else{
            return SzpJsonResult.errorMsg("未获取到user");
        }
    }
    @ApiOperation("通过id删除user")
    @DeleteMapping("/deleteUserById.action")
    public SzpJsonResult deleteUserById(@RequestBody long id){
        userService.deleteUserById(id);
        return SzpJsonResult.ok();
    }
    @ApiOperation("更新user，按主键id，更新值不为null的字段")
    @PutMapping("/updateUserById.action")
    public SzpJsonResult updateUserById(@RequestBody User user){
        userService.updateUserById(user);
        return SzpJsonResult.ok();
    }
    @ApiOperation("通过id找到User")
    @GetMapping("/findUserById.action")
    public SzpJsonResult findUserById(long id){
        userService.findUserById(id);
        return SzpJsonResult.ok();
    }
    @ApiOperation("通过username找到User")
    @GetMapping("/findUserByUsername.action")
    public SzpJsonResult findUserByUsername(String username){
        List<User> userByUsername = userService.findUserByUsername(username);
        return SzpJsonResult.ok(userByUsername);
    }
    @ApiOperation("登录，username，password")
    @GetMapping("/findUserByUsernameAndPassword.action")
    public SzpJsonResult findUserByUsernameAndPassword(String username,String password){
        List<User> userByUsernameAndPassword = userService.findUserByUsernameAndPassword(username, password);
        return SzpJsonResult.ok(userByUsernameAndPassword);
    }
    @ApiOperation("显示所有user")
    @GetMapping("/findAllUsers.action")
    public SzpJsonResult findAllUsers(){
        List<User> allUser = userService.findAllUser();
        return SzpJsonResult.ok(allUser);
    }
}
