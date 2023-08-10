package az.rock.lib.valueObject.js;

public final class Order {
    private Integer orderNumber;

    public Order() {
    }

    public Order(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}
