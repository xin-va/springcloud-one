package cn.kgc.user.server.service;

import cn.kgc.project.common.entity.User;
import cn.kgc.user.server.dao.UserDao;
import cn.kgc.user.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:04  <br/>
 * 类描述   ：
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    @Value("${redis.expire}")
    private Integer sec;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public void addUser(String key, User user) {
        Map<String, String> map = new HashMap<>();
        map.put("user_id",user.getUser_id().toString());
        map.put("user_name",user.getUser_name().toString());
        map.put("user_phone",user.getUser_phone().toString());
        userDao.add(key,map);
    }

    @Override
    public User getUser(String key) {
        User user = new User();
        Map<Object, Object> map = userDao.get(key);
        if (map.size()==0 || map.isEmpty()){
            user.setUser_id(0);
        }else {
            user.setUser_id((Integer) map.get("user_id"));
            user.setUser_name(map.get("user_name").toString());
            user.setUser_phone(map.get("user_phone").toString());
        }

        return user;
    }

    @Override
    public void setExpire(String key) {
            userDao.setExpire(key,sec);
    }
}
