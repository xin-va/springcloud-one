package cn.kgc.movie.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 18:05  <br/>
 * 类描述   ：
 */
@FeignClient("order-server")
public interface OrderService {
    @PutMapping("/putOrder")
    public Integer addOther(@RequestParam Integer movie_show_id ,@RequestParam Integer user_id ,@RequestParam String seat_num );

    @GetMapping("/getAlreadyOrder/{movie_show_id}")
    public List<Order> selectOrderByShow(@PathVariable("movie_show_id") Integer movie_show_id);

    @RequestMapping("/getUserOrder/{user_id}")
    public List<Order> getOrderByUserId(@PathVariable("user_id") Integer user_id);
}
