package cn.kgc.showmovie.server.service;

import cn.kgc.project.common.entity.ShowMovie;
import cn.kgc.project.common.entity.ShowMoviePage;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 19:41  <br/>
 * 类描述   ：
 */
public interface ShowmovieService {
    public abstract ShowMoviePage getShowMovie(List<Integer> showroomIds,Integer pageNum, Integer pageSize);
    public abstract ShowMovie getShowMovieByShowMovieId(Integer movie_show_id);
}
