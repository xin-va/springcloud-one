package cn.kgc.movie.server.mapper;

import cn.kgc.project.common.entity.Movie;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/10 11:06  <br/>
 * 类描述   ：
 */
public interface MovieMapper {
    public abstract List<Movie> selectAllMovie (@Param("movie_ids") List<Integer> movie_ids);
}
