package cn.kgc.store.server.mapper;

import cn.kgc.project.common.entity.ShowRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 20:18  <br/>
 * 类描述   ：
 */
@Mapper
public interface ShowRoomMapper {
    public abstract List<ShowRoom> selectShowRooms(Integer store_id);
    public abstract List<ShowRoom> selectByShowRoomIds(@Param("showroom_ids") List<Integer>  showroom_ids);

}
