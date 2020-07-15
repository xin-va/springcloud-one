package cn.kgc.order.server.service;

import cn.kgc.project.common.entity.Order;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 19:00  <br/>
 * 类描述   ：
 */
public interface OrderService {
    public abstract Integer addOrder(Integer movie_show_id, Integer user_id, String seat_num);
    public abstract List<Order> selectOrderByShow(Integer movie_show_id);
    public abstract List<Order> getOrderByUserId(Integer user_id);
}
