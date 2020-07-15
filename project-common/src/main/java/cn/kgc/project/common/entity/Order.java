package cn.kgc.project.common.entity;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 11:16  <br/>
 * 类描述   ：
 */
public class Order {
    private Integer order_id;
    private ShowMovie showMovie;
    private User user;
    private String seat_num;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public ShowMovie getShowMovie() {
        return showMovie;
    }

    public void setShowMovie(ShowMovie showMovie) {
        this.showMovie = showMovie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(String seat_num) {
        this.seat_num = seat_num;
    }
}
