package cn.kgc.project.common.entity;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 11:20  <br/>
 * 类描述   ：
 */
public class ShowMoviePage extends BasePage{
    List<ShowMovie>showMovieList;

    public List<ShowMovie> getShowMovieList() {
        return showMovieList;
    }

    public void setShowMovieList(List<ShowMovie> showMovieList) {
        this.showMovieList = showMovieList;
    }
}
