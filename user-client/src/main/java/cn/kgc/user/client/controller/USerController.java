package cn.kgc.user.client.controller;

import cn.kgc.project.common.entity.User;
import cn.kgc.user.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 21:46  <br/>
 * 类描述   ：
 */
@Controller
public class USerController {
    @Autowired
    private UserService userService;

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }
    public Map<String,Object> login(String userName, String password, HttpServletResponse response){

        Map<String,Object> map = new HashMap<>();
        User userByUserName = userService.getUserByUserName(userName);
        if (userByUserName==null){
            map.put("success",-1);
            map.put("msg","该用户不存在");

        }else if(!userByUserName.getUser_password().equals(password)){
            map.put("success",-2);
            map.put("msg","密码错误");

        }else {
            //登录成功则将用户存放到redis中
            //先生成一个token并将用户存到redis中
            String token = UUID.randomUUID().toString().replace("-","-");
            System.out.println(token);
            userService.addUser(token,userByUserName);
            //将token放到cookie中返回
            Cookie cookie = new Cookie("token",token);
            cookie.setMaxAge(3600);
            cookie.setDomain("movie.com");
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);

            map.put("success",0);
            map.put("msg","登陆成功");
        }
        return map;
    }


}
