package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ValueObject
public enum OrderNumber {
    ORDER_NUMBER ;

    private int orderNumber = 1;

    public Integer orderNumber() {
        return orderNumber++;
    }

    public Integer duplicateOrderNumber(List<Integer> list) {
        Set<Integer> elements = new HashSet<Integer>();
        return list.stream()
                .filter(n -> !elements.add(n))
                .findAny()
                .get();
    }

}
