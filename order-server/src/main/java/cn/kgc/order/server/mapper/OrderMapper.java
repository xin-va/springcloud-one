package cn.kgc.order.server.mapper;

import cn.kgc.project.common.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 18:48  <br/>
 * 类描述   ：
 */
@Mapper
public interface OrderMapper {
    public abstract Integer addOneOrder(@Param("movie_show_id") Integer movie_show_id,
                                        @Param("user_id") Integer user_id,
                                        @Param("seat_num") String seat_num);

    public abstract List<Order> getOrderByMovie_show_id(@Param("movie_show_id") Integer movie_show_id);
    public abstract List<Order> getOrderByUserId(@Param("user_id") Integer user_id);
}
