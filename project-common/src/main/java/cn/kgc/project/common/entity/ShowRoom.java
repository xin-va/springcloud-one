package cn.kgc.project.common.entity;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/10 9:42  <br/>
 * 类描述   ：
 */
public class ShowRoom {
    private Integer showroom_id;
    private String showroom_name;
    private Integer showroom_capacity;
    private Store store;

    public Integer getShowroom_id() {
        return showroom_id;
    }

    public void setShowroom_id(Integer showroom_id) {
        this.showroom_id = showroom_id;
    }

    public String getShowroom_name() {
        return showroom_name;
    }

    public void setShowroom_name(String showroom_name) {
        this.showroom_name = showroom_name;
    }

    public Integer getShowroom_capacity() {
        return showroom_capacity;
    }

    public void setShowroom_capacity(Integer showroom_capacity) {
        this.showroom_capacity = showroom_capacity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

