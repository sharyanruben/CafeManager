package cafemanagement.model;

import cafemanagement.model.enums.ProductInOrderStatus;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RuBen on 27.03.2017.
 */
@Entity
@javax.persistence.Table(name = "product_in_order")
public class ProductInOrder implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order productOrder;

    @Column(name = "amount")
    private int orderAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProductInOrderStatus productInOrderStatus;


    public ProductInOrder() {
    }

    public ProductInOrder(Product product, Order productOrder, int orderAmount, ProductInOrderStatus productInOrderStatus) {
        this.product = product;
        this.productOrder = productOrder;
        this.orderAmount = orderAmount;
        this.productInOrderStatus = productInOrderStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Order productOrder) {
        this.productOrder = productOrder;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public ProductInOrderStatus getProductInOrderStatus() {
        return productInOrderStatus;
    }

    public void setProductInOrderStatus(ProductInOrderStatus productInOrderStatus) {
        this.productInOrderStatus = productInOrderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductInOrder)) return false;

        ProductInOrder that = (ProductInOrder) o;

        if (getOrderAmount() != that.getOrderAmount()) return false;
        if (getProduct() != null ? !getProduct().equals(that.getProduct()) : that.getProduct() != null) return false;
        if (getProductOrder() != null ? !getProductOrder().equals(that.getProductOrder()) : that.getProductOrder() != null)
            return false;
        return getProductInOrderStatus() == that.getProductInOrderStatus();

    }

    @Override
    public int hashCode() {
        int result = getProduct() != null ? getProduct().hashCode() : 0;
        result = 31 * result + (getProductOrder() != null ? getProductOrder().hashCode() : 0);
        result = 31 * result + getOrderAmount();
        result = 31 * result + (getProductInOrderStatus() != null ? getProductInOrderStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductInOrder{" +
                "product=" + product +
                ", productOrder=" + productOrder +
                ", orderAmount=" + orderAmount +
                ", productInOrderStatus=" + productInOrderStatus +
                '}';
    }
}
