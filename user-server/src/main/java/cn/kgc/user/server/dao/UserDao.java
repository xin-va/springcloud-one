package cn.kgc.user.server.dao;

import java.util.Map;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:07  <br/>
 * 类描述   ：
 */
public interface UserDao {
    public abstract void add(String key, Map<String, String> map);

    public abstract Map<Object, Object> get(String key);

    public abstract void setExpire(String key,Integer sec);

}
