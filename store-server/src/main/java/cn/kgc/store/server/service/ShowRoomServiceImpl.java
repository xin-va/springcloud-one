package cn.kgc.store.server.service;

import cn.kgc.project.common.entity.ShowRoom;
import cn.kgc.store.server.mapper.ShowRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 20:50  <br/>
 * 类描述   ：
 */
@Service
public class ShowRoomServiceImpl implements ShowRoomService{
    @Autowired
    private ShowRoomMapper showRoomMapper;
    @Override
    public Map<Integer, List<ShowRoom>> getShowRooms(List<Integer> store_ids) {
        Map<Integer,List<ShowRoom>> map = new HashMap<>();
        for (Integer store_id : store_ids){
            List<ShowRoom> showRooms = showRoomMapper.selectShowRooms(store_id);
            map.put(store_id,showRooms);
        }
        return map;
    }

    @Override
    public List<ShowRoom> getShowRoomByshowRoomIds(String showRoomIds) {
        if (showRoomIds!=null && !showRoomIds.isEmpty()){
            List<Integer> ids = new ArrayList<>();
            String [] split = showRoomIds.split(",");
            for (String s: split){
                ids.add(Integer.parseInt(s));
            }
            return showRoomMapper.selectByShowRoomIds(ids);
        }else {
            return new ArrayList<>();
        }

    }
}
