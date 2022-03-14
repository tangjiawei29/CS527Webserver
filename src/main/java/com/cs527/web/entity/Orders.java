package com.cs527.web.entity;


public class Orders {

    private Long orderId;
    private Long userId;
    private Long orderNumber;
    private Long orderDow;
    private Long orderHourOfDay;
    private Long daysSincePriorOrder;

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderNumber=" + orderNumber +
                ", orderDow=" + orderDow +
                ", orderHourOfDay=" + orderHourOfDay +
                ", daysSincePriorOrder=" + daysSincePriorOrder +
                '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }


    public Long getOrderDow() {
        return orderDow;
    }

    public void setOrderDow(Long orderDow) {
        this.orderDow = orderDow;
    }


    public Long getOrderHourOfDay() {
        return orderHourOfDay;
    }

    public void setOrderHourOfDay(Long orderHourOfDay) {
        this.orderHourOfDay = orderHourOfDay;
    }


    public Long getDaysSincePriorOrder() {
        return daysSincePriorOrder;
    }

    public void setDaysSincePriorOrder(Long daysSincePriorOrder) {
        this.daysSincePriorOrder = daysSincePriorOrder;
    }

}
