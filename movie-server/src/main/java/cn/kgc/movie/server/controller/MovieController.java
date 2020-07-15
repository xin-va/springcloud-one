package cn.kgc.movie.server.controller;

import cn.kgc.movie.server.service.MovieService;
import cn.kgc.project.common.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 18:38  <br/>
 * 类描述   ：
 */
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Value("${page.size}")
    private Integer pageSize;
    @GetMapping("/getAllMovie/{movieIds}")
    public List<Movie> getAllMovie(@PathVariable("movieIds") String movieIds){
        return movieService.getAllMovie(movieIds);
    }

}
