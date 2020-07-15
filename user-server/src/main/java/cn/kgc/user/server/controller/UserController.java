package cn.kgc.user.server.controller;

import cn.kgc.project.common.entity.User;
import cn.kgc.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:25  <br/>
 * 类描述   ：
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUserByUserName(@RequestParam String userName){
        return    userService.getUserByUserName(userName);
    }

    @PostMapping("/addUserToRedis")
    public  void addUser(@RequestParam String key ,@RequestBody User user){
        userService.addUser(key,user);
    };

    @GetMapping("/getUserFromRedis")
    public  User getUser(@RequestParam String key){
        return userService.getUser(key);
    };

    @PostMapping("/setExpire")
    public  void setExpire(@RequestParam String key){
        userService.setExpire(key);
    };

}
