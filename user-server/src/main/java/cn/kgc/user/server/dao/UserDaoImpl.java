package cn.kgc.user.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:08  <br/>
 * 类描述   ：
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void add(String key, Map<String, String> map) {
         stringRedisTemplate.opsForHash().putAll(key,map);
    }

    @Override
    public Map<Object, Object> get(String key) {
        return stringRedisTemplate.opsForHash().entries(key);
    }

    @Override
    public void setExpire(String key, Integer sec) {
        stringRedisTemplate.expire(key,sec, TimeUnit.SECONDS);
    }
}
