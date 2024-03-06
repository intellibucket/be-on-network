package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@ValueObject
public class SimplePageableResponse<T> {

    private final Integer pageSize;

    private final Integer pageNumber;

    private final Boolean hasMore;

    private final List<T> data;

    private SimplePageableResponse(Integer pageSize, Integer pageNumber, Boolean hasMore, List<T> data) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.hasMore = hasMore;
        this.data = data;
    }

    public static <T> SimplePageableResponse<T> of(Integer pageSize, Integer pageNumber, Boolean hasMore, List<T> data) {
        Objects.requireNonNull(pageSize);
        Objects.requireNonNull(pageNumber);
        hasMore = Objects.requireNonNullElse(hasMore, false);
        data = Objects.requireNonNullElse(data, Collections.emptyList());
        return new SimplePageableResponse<>(pageSize, pageNumber, hasMore, data);
    }

    public static <T> SimplePageableResponse<T> ofHasMore(Integer pageSize, Integer pageNumber, List<T> data) {
        return SimplePageableResponse.of(pageSize, pageNumber, true, data);
    }

    public static <T> SimplePageableResponse<T> ofNoMore(Integer pageSize, Integer pageNumber, List<T> data) {
        return SimplePageableResponse.of(pageSize, pageNumber, false, data);
    }

    public static <T> SimplePageableResponse<T> ofEmpty(Integer pageSize, Integer pageNumber) {
        return SimplePageableResponse.of(pageSize, pageNumber, false, Collections.emptyList());
    }


    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public Boolean isEmpty() {
        return data.isEmpty();
    }
}
