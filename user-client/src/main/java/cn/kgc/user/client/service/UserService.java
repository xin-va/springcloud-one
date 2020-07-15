package cn.kgc.user.client.service;

import cn.kgc.project.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 21:31  <br/>
 * 类描述   ：
 */
@FeignClient("user-server")
public interface UserService {
    @GetMapping("/getUser")
    public User getUserByUserName(@RequestParam String userName);

    @PostMapping("addUserToRedis")
    public void addUser(@RequestParam String key ,@RequestBody User user);

    @GetMapping("/getUserFromRedis")
    public User getUser(String key);

    @PostMapping("/setExpire")
    public void  setExpire(String key);
}
