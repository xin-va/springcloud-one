package cn.kgc.user.server.service;

import cn.kgc.project.common.entity.User;

import javax.jws.soap.SOAPBinding;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:03  <br/>
 * 类描述   ：
 */
public interface UserService {
    public abstract User getUserByUserName(String userName);
    public abstract void  addUser(String key,User user);
    public abstract User getUser(String key);
    public abstract  void setExpire(String key);
}
