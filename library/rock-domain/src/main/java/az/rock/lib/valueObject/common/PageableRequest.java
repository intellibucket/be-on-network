package az.rock.lib.valueObject.common;

public class PageableRequest {
    private Integer pageSize;
    private Integer pageNumber;

    public PageableRequest(Integer pageSize, Integer pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }
}
