package cn.kgc.movie.client.controller;

import cn.kgc.movie.client.service.MovieService;
import cn.kgc.movie.client.service.ShowMovieService;
import cn.kgc.movie.client.service.StoreService;
import cn.kgc.project.common.entity.Movie;
import cn.kgc.project.common.entity.ShowMovie;
import cn.kgc.project.common.entity.ShowMoviePage;
import cn.kgc.project.common.entity.ShowRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/12 23:32  <br/>
 * 类描述   ：
 */
@Controller
public class ShowMovieController {
    @Autowired
    private ShowMovieService showmovieService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private StoreService storeService;

    @RequestMapping("/getShowMovies")
    @ResponseBody
    public ShowMoviePage getAllShow(@RequestParam(required = false) String showroomIds , @RequestParam(required = false) Integer pageNum){
        System.out.println(showroomIds);
        Integer page = pageNum ==null ? 1 : pageNum;
        ShowMoviePage showMoviePage = showmovieService.getShowMovie(showroomIds, page);
        if (showMoviePage.getShowMovieList().size()!=0){
            StringBuilder movieIds = new StringBuilder();
            StringBuilder showRoomString = new StringBuilder();
            for (ShowMovie showMovie : showMoviePage.getShowMovieList()) {
                if (movieIds.length()>0){
                    movieIds.append(",");
                }
                movieIds.append(showMovie.getMovie().getMovie_id());
            }
            List<Movie> allMovie = movieService.getAllMovie(movieIds.toString());
            for (ShowMovie showMovie : showMoviePage.getShowMovieList()) {
                for (Movie movie : allMovie) {
                    if (showMovie.getMovie().getMovie_id().equals(movie.getMovie_id())){
                        showMovie.setMovie(movie);
                    }
                }
            }

            //获取showroomId
            if (showroomIds==null){
                StringBuilder showRoomIdsString = new StringBuilder();
                for (ShowMovie showMovie : showMoviePage.getShowMovieList()) {
                    if (showRoomIdsString.length()>0){
                        showRoomIdsString.append(",");
                    }
                    showRoomIdsString.append(showMovie.getShowroom().getShowroom_id());
                }
                showroomIds=showRoomIdsString.toString();
            }
            List<ShowRoom> showRoomByShowRoomIds = storeService.getShowRoomByShowRoomIds(showroomIds);
            for (ShowMovie showMovie : showMoviePage.getShowMovieList()) {
                for (ShowRoom showRoomByShowRoomId : showRoomByShowRoomIds) {
                    if (showMovie.getShowroom().getShowroom_id().equals(showRoomByShowRoomId.getShowroom_id())){
                        showMovie.setShowroom(showRoomByShowRoomId);
                    }
                }
            }
        }
        return showMoviePage;
    }


    @RequestMapping("/getMovieInfo")
    public String  get(Integer movieId , Model model){
        List<Movie> allMovie = movieService.getAllMovie(movieId.toString());
        Movie movie = allMovie.get(0);
        model.addAttribute("movie",movie);
        return "movieInfo";
    }


}
