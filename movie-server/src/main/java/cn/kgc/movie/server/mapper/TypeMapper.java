package cn.kgc.movie.server.mapper;

import cn.kgc.project.common.entity.Type;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 17:47  <br/>
 * 类描述   ：
 */
public interface TypeMapper {
    public abstract List<Type> selectTypeByMovieId(Integer movie_id);
}
