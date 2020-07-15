package cn.kgc.movie.client.controller;

import cn.kgc.movie.client.service.StoreService;
import cn.kgc.project.common.entity.ShowRoom;
import cn.kgc.project.common.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:39  <br/>
 * 类描述   ：
 */
@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;


    @RequestMapping(value = "/")
    public String getStore(Model model){
        return "index";
    }

    @RequestMapping("/getStore")
    @ResponseBody
    public List<Store> getStores(){
        List<Store> allStore = storeService.getAllStore();
        StringBuilder stroreIds = new StringBuilder();
        for (Store store : allStore) {
            if (stroreIds.length() > 0){
                stroreIds.append(",");
            }
            stroreIds.append(store.getStore_id());
        }

        Map<Integer, List<ShowRoom>> allShowRooms = storeService.getAllShowrooms(stroreIds.toString());
        for (Store store : allStore) {
            for (Integer id : allShowRooms.keySet()) {
                if (id == store.getStore_id()){
                    store.setShowrooms(allShowRooms.get(id));
                }
            }
        }
        return allStore;
    }
}
