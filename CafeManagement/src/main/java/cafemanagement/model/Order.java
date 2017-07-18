package cafemanagement.model;

import cafemanagement.model.enums.OrderStatus;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id")
    private Tables table;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "productOrder")
    private List<ProductInOrder> productInOrderList = new ArrayList<ProductInOrder>();

    public Order() {
    }

    public Order(OrderStatus orderStatus, Tables table) {
        this.orderStatus = orderStatus;
        this.table = table;
    }

    public List<ProductInOrder> getProductInOrderList() {
        return productInOrderList;
    }

    public void setProductInOrderList(List<ProductInOrder> productInOrderList) {
        this.productInOrderList = productInOrderList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getOrderId() != order.getOrderId()) return false;
        if (getOrderStatus() != order.getOrderStatus()) return false;
        return getTable() != null ? getTable().equals(order.getTable()) : order.getTable() == null;

    }

    @Override
    public int hashCode() {
        int result = getOrderId();
        result = 31 * result + (getOrderStatus() != null ? getOrderStatus().hashCode() : 0);
        result = 31 * result + (getTable() != null ? getTable().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderStatus=" + orderStatus +
                ", table=" + table +
                '}';
    }
}
