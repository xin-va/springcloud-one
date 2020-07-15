package cn.kgc.order.server.service;

import cn.kgc.order.server.mapper.OrderMapper;
import cn.kgc.project.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 19:01  <br/>
 * 类描述   ：
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Integer addOrder(Integer movie_show_id, Integer user_id, String seat_num) {
        return orderMapper.addOneOrder(movie_show_id,user_id,seat_num);
    }

    @Override
    public List<Order> selectOrderByShow(Integer movie_show_id) {
        return orderMapper.getOrderByMovie_show_id(movie_show_id);
    }

    @Override
    public List<Order> getOrderByUserId(Integer user_id) {
        return orderMapper.getOrderByUserId(user_id);
    }
}
