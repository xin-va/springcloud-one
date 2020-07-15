package cn.kgc.order.server.controller;

import cn.kgc.order.server.service.OrderService;
import cn.kgc.project.common.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 19:22  <br/>
 * 类描述   ：
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PutMapping("/putOrder")
    public Integer addOrder(@RequestParam Integer movie_show_id,@RequestParam Integer user_id,@RequestParam String seat_num){
        return orderService.addOrder(movie_show_id,user_id,seat_num);
    }
    @GetMapping("/selectOrderByShow/{movie_show_id}")
    public List<Order> selectOrderByShow(@PathVariable("movie_show_id") Integer movie_show_id){
        return orderService.selectOrderByShow(movie_show_id);
    }
    @GetMapping("/getOrderByUserId/{user_id}")
    public List<Order> getOrderByUserId(@PathVariable("user_id") Integer user_id){
        return orderService.getOrderByUserId(user_id);
    }
}
