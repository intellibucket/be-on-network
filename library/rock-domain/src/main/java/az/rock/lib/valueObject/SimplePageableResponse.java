package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@ValueObject
public class SimplePageableResponse<T> {

    private final Integer pageSize;

    private final Integer pageNumber;

    private final List<T> data;

    public SimplePageableResponse(Integer pageSize, Integer pageNumber, List<T> data) {
        this.pageSize = Objects.requireNonNullElse(pageSize, 10);
        this.pageNumber = Objects.requireNonNullElse(pageNumber, 1);
        this.data = Objects.requireNonNullElse(data, Collections.emptyList());
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
}
