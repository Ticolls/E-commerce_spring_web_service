package com.ticolls.web_service.entities.pk;

import com.ticolls.web_service.entities.Order;
import com.ticolls.web_service.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderItemPK)) {
            return false;
        }
        OrderItemPK orderItemPK = (OrderItemPK) o;
        return Objects.equals(order, orderItemPK.order) && Objects.equals(product, orderItemPK.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
    
}
