package cn.kgc.store.server.Controller;

import cn.kgc.project.common.entity.ShowRoom;
import cn.kgc.project.common.entity.Store;
import cn.kgc.store.server.service.ShowRoomService;
import cn.kgc.store.server.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.net.idn.Punycode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 21:08  <br/>
 * 类描述   ：
 */
@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private ShowRoomService showRoomService;

    @GetMapping("/getAllStore")
    public List<Store> getAllStore(){
        return storeService.getAllStore();
    }


    @GetMapping("/getAllShowRooms/{storeIds}")
    public Map<Integer,List<ShowRoom>> getAllShowRooms(@PathVariable("storeIds") String  storeIds){
        List<Integer> list = new ArrayList<>();
        if(storeIds == null){
            return new HashMap<>();
        }
        String[] split = storeIds.split(",");
        for (String s: split){
            list.add(Integer.parseInt(s));
        }
        Map<Integer,List<ShowRoom>> showRomms = showRoomService.getShowRooms(list);

        return showRomms;
    }
    @GetMapping("getShowRoomByShowRoomIds/{showRoomIds}")
    public List<ShowRoom> getShowRoomByShowRoomIds(@PathVariable("showRoomIds") String showRoomIds){
        return showRoomService.getShowRoomByshowRoomIds(showRoomIds);
    }

}
