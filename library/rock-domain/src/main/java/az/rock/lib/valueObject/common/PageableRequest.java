package az.rock.lib.valueObject.common;

public class PageableRequest {
    private Integer offset;
    private Integer limit;

    public PageableRequest(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }
}
