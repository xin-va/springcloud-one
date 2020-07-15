package cn.kgc.showmovie.server.mapper;

import cn.kgc.project.common.entity.ShowMovie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 19:41  <br/>
 * 类描述   ：
 */
@Mapper
public interface ShowmovieMapper {
    public abstract List<ShowMovie> selectAllShowMovie(@Param("showRoomIds") List<Integer> showRoomIds);
    public abstract ShowMovie selectShowMovieInfo(Integer movie_Show_id);
}
