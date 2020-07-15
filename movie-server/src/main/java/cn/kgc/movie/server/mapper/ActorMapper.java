package cn.kgc.movie.server.mapper;

import cn.kgc.project.common.entity.Actor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 11:41  <br/>
 * 类描述   ：
 */
@Mapper
public interface ActorMapper {
    public abstract List<Actor> selectActorByMovieId(Integer Movie_id);
}
