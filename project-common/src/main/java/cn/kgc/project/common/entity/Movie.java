package cn.kgc.project.common.entity;

import java.util.Date;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/10 9:32  <br/>
 * 类描述   ：
 */
public class Movie {
    private Integer movie_id;
    private String movie_name;
    private String movie_pic;
    private String movie_storyline;
    private  String movie_company;
    private Date  movie_issuingdate;
    private Actor actors;
    private Type types;

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_pic() {
        return movie_pic;
    }

    public void setMovie_pic(String movie_pic) {
        this.movie_pic = movie_pic;
    }

    public String getMovie_storyline() {
        return movie_storyline;
    }

    public void setMovie_storyline(String movie_storyline) {
        this.movie_storyline = movie_storyline;
    }

    public String getMovie_company() {
        return movie_company;
    }

    public void setMovie_company(String movie_company) {
        this.movie_company = movie_company;
    }

    public Date getMovie_issuingdate() {
        return movie_issuingdate;
    }

    public void setMovie_issuingdate(Date movie_issuingdate) {
        this.movie_issuingdate = movie_issuingdate;
    }

    public Actor getActor() {
        return actors;
    }

    public void setActor(Actor actor) {
        this.actors = actor;
    }

    public Type getType() {
        return types;
    }

    public void setType(Type type) {
        this.types = type;
    }

}
