package cn.kgc.showmovie.server.controller;

import cn.kgc.project.common.entity.ShowMovie;
import cn.kgc.project.common.entity.ShowMoviePage;
import cn.kgc.showmovie.server.service.ShowmovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 19:42  <br/>
 * 类描述   ：
 */
public class ShowmovieController {
    @Autowired
    private ShowmovieService showmovieService;

    @Value("${page.size}")
    private Integer pageSize;

    @GetMapping("/getShowMovie")
    public ShowMoviePage getShowMovie(@RequestParam(required = false) String showroomIds , @RequestParam(required = false)Integer pageNum){
        Integer page = pageNum == null? 1: pageNum;
        List<Integer> list = new ArrayList<>();
        if (showroomIds!=null && !showroomIds.equals(null)){
            String[] split = showroomIds.split("," );
            for (String s : split) {
                list.add(Integer.parseInt(s));
            }
            return showmovieService.getShowMovie(list,page,pageSize);
        }
        else {
            return showmovieService.getShowMovie(null,page,pageSize);
        }
    }

    @GetMapping("/getShowMovieByShowMovieId/{id}")
    public ShowMovie getShowMovieByShowMovieIds(@PathVariable("id") Integer movie_show_id){
        return  showmovieService.getShowMovieByShowMovieId(movie_show_id);
    }
}
