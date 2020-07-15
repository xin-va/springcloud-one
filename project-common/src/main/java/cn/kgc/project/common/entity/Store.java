package cn.kgc.project.common.entity;

import java.util.List;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/10 9:49  <br/>
 * 类描述   ：
 */
public class Store {
    private Integer store_id;
    private String store_name;
    private List<ShowRoom> showrooms;

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public List<ShowRoom> getShowrooms() {
        return showrooms;
    }

    public void setShowrooms(List<ShowRoom> showrooms) {
        this.showrooms = showrooms;
    }
}
