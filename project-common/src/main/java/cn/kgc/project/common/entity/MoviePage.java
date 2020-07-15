package cn.kgc.project.common.entity;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 11:15  <br/>
 * 类描述   ：
 */
public class MoviePage extends BasePage{
    private List<Movie> movielist;

    public List<Movie> getMovielist() {
        return movielist;
    }

    public void setMovielist(List<Movie> movielist) {
        this.movielist = movielist;
    }
}
