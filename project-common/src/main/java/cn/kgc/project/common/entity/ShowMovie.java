package cn.kgc.project.common.entity;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 11:18  <br/>
 * 类描述   ：
 */
public class ShowMovie {
    private Integer movie_show_id;
    private Movie movie;
    private ShowRoom showroom;
    private String show_date;
    private Double price;

    public Integer getMovie_show_id() {
        return movie_show_id;
    }

    public void setMovie_show_id(Integer movie_show_id) {
        this.movie_show_id = movie_show_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ShowRoom getShowroom() {
        return showroom;
    }

    public void setShowroom(ShowRoom showroom) {
        this.showroom = showroom;
    }

    public String getShow_date() {
        return show_date;
    }

    public void setShow_date(String show_date) {
        this.show_date = show_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
