package com.cs527.web.entity;


public class OrderProducts {

    private Long orderId;
    private Long productId;
    private Long addToCartOrder;
    private Long reordered;

    @Override
    public String toString() {
        return "OrderProducts{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", addToCartOrder=" + addToCartOrder +
                ", reordered=" + reordered +
                '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public Long getAddToCartOrder() {
        return addToCartOrder;
    }

    public void setAddToCartOrder(Long addToCartOrder) {
        this.addToCartOrder = addToCartOrder;
    }


    public Long getReordered() {
        return reordered;
    }

    public void setReordered(Long reordered) {
        this.reordered = reordered;
    }

}
