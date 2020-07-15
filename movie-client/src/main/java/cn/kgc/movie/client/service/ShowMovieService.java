package cn.kgc.movie.client.service;

import cn.kgc.project.common.entity.ShowMovie;
import cn.kgc.project.common.entity.ShowMoviePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 18:05  <br/>
 * 类描述   ：
 */
@FeignClient("showMovie-server")
public interface ShowMovieService {

    @GetMapping("/getShowMovie")
    public ShowMoviePage getShowMovie(@RequestParam(required = false) String showroomIds , @RequestParam(required = false) Integer mageNum);

    @GetMapping("/getShowMovieByShowMovieIds/{id}")
    public ShowMovie getShowMovieByShowMovieIds(@PathVariable("id") Integer movie_show_id);
}
