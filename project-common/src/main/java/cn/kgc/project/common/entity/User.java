package cn.kgc.project.common.entity;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 11:12  <br/>
 * 类描述   ：
 */
public class User {
    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_phone;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
