package crelle.family.model;

/**
 * @author:crelle
 * @className:PageBean
 * @version:1.0.0
 * @date:2021/4/3
 * @description:XX
 **/
public class PageBean<T> {
    private T condition;
    private int pageNo;
    private int pageSize;

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "condition=" + condition +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
