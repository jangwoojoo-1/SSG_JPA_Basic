package com.ssg.gallery.order.service;

import com.ssg.gallery.order.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    //주문 상품 목록 조회
    List<OrderItem> findAll(Integer orderId);

    // 즈믄 싱픔 조회
    OrderItem find(Integer orderId, Integer itemId);

    // 주문 상품 데이터 저장
    void saveAll(List<OrderItem> orderItems);
}
