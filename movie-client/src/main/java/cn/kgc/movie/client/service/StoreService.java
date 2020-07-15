package cn.kgc.movie.client.service;

import cn.kgc.project.common.entity.ShowRoom;
import cn.kgc.project.common.entity.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 18:05  <br/>
 * 类描述   ：
 */
@FeignClient("store-server")
public interface StoreService {

    @GetMapping("/getAllStore")
    public List<Store> getAllStore();

    @GetMapping("/getAllShowrooms/{storeIds}")
    public Map<Integer, List<ShowRoom>> getAllShowrooms(@PathVariable("storeIds") String storeIds);

    @GetMapping("/getShowRoomByShowRoomIds/{showRoomIds}")
    public List<ShowRoom> getShowRoomByShowRoomIds(@PathVariable("showRoomIds") String showRoomIds);
}
