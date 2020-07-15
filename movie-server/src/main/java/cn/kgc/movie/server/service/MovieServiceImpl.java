package cn.kgc.movie.server.service;

import cn.kgc.movie.server.mapper.MovieMapper;
import cn.kgc.project.common.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 17:59  <br/>
 * 类描述   ：
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> getAllMovie(String movieIds) {
        if (movieIds == null && movieIds.length()==0){
            return new ArrayList<>();
        }else {
            List<Integer> ids=new ArrayList<>();
            String[] split = movieIds.split(",");
            for (String s : split){
                ids.add(Integer.parseInt(s));
            }
            List<Movie> movies=movieMapper.selectAllMovie(ids);
            return movies;
        }

    }
}
