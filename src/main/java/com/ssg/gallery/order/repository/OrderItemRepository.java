package com.ssg.gallery.order.repository;

import com.ssg.gallery.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    // 주문 상품 목록 조회
    List<OrderItem> findAllByOrderId(Integer orderId);

    //주문 상품 조회
    Optional<OrderItem> findByOrderIdAndItemId(Integer orderId, Integer itemId);
}
