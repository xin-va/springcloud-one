package cn.kgc.user.server.mapper;

import cn.kgc.project.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:02  <br/>
 * 类描述   ：
 */
@Mapper
public interface UserMapper {
    public abstract User getUserByName(String userName);
}
