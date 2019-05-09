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
            List<User> userByUsername = userService.findUserByUsername(user.getUsername());
            if(userByUsername.size()==0||userByUsername==null){
                userService.insertUser(user);
                return SzpJsonResult.ok();
            }
            return SzpJsonResult.errorMsg("该用户已注册");
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
        User userById = userService.findUserById(user.getId());
        return SzpJsonResult.ok(userById);
    }
    @ApiOperation("通过id找到User")
    @GetMapping("/findUserById.action")
    public SzpJsonResult findUserById(long id){
        User userById = userService.findUserById(id);
        return SzpJsonResult.ok(userById);
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
        if (userByUsernameAndPassword.size()!=0&&userByUsernameAndPassword!=null){
            return SzpJsonResult.ok(userByUsernameAndPassword);
        }
        return SzpJsonResult.errorMsg("请检查用户名和密码");
    }
    @ApiOperation("显示所有user")
    @GetMapping("/findAllUsers.action")
    public SzpJsonResult findAllUsers(){
        List<User> allUser = userService.findAllUser();
        return SzpJsonResult.ok(allUser);
    }
}
