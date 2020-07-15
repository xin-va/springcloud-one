package cn.kgc.movie.client.service;

import cn.kgc.project.common.entity.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 18:28  <br/>
 * 类描述   ：
 */
@FeignClient("movie-server")
public interface MovieService {
    @GetMapping("/getAllMovie/{movieIds}")
    public List<Movie> getAllMovie(@PathVariable("movieIds") String movieIds);
}
