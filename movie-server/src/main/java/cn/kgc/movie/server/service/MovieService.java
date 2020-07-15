package cn.kgc.movie.server.service;

import cn.kgc.project.common.entity.Movie;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 17:52  <br/>
 * 类描述   ：
 */
public interface MovieService {
    public  abstract List<Movie> getAllMovie(String movieIds);

}
