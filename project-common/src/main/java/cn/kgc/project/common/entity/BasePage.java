package cn.kgc.project.common.entity;

/**
 * @author : 李鑫 <br/>
 * @date : 2020/7/11 11:13  <br/>
 * 类描述   ：
 */
public class BasePage {
    private Integer rowCount;
    private Integer pageCount;
    private Integer pageNum;
    private Integer pageSize;

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
