package cn.kgc.showmovie.server.service;

import cn.kgc.project.common.entity.ShowMovie;
import cn.kgc.project.common.entity.ShowMoviePage;
import cn.kgc.showmovie.server.mapper.ShowmovieMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 19:42  <br/>
 * 类描述   ：
 */
@Service
public class ShowmovieServiceImpl implements  ShowmovieService{
    @Autowired
    private ShowmovieMapper showmovieMapper;
    @Override
    public ShowMoviePage getShowMovie(List<Integer> showroomIds, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ShowMovie> showMovies = showmovieMapper.selectAllShowMovie(showroomIds);

        PageInfo<ShowMovie> showMoviePageInfo = new PageInfo<>(showMovies);
        ShowMoviePage showMoviePage = new ShowMoviePage();
        showMoviePage.setShowMovieList(showMovies);
        showMoviePage.setPageCount(showMoviePageInfo.getPages());
        showMoviePage.setPageNum(pageNum);
        showMoviePage.setPageSize(pageSize);
        showMoviePage.setRowCount(((Long)showMoviePageInfo.getTotal()).intValue());
        return showMoviePage;
    }

    @Override
    public ShowMovie getShowMovieByShowMovieId(Integer movie_show_id) {
        return showmovieMapper.selectShowMovieInfo(movie_show_id);
    }
}
