package cn.kgc.store.server.service;

import cn.kgc.project.common.entity.ShowRoom;

import java.util.List;
import java.util.Map;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 20:50  <br/>
 * 类描述   ：
 */
public interface ShowRoomService {
    public abstract Map<Integer, List<ShowRoom>> getShowRooms(List<Integer> store_ids);

    public abstract List<ShowRoom> getShowRoomByshowRoomIds(String showRoomIds);
}
