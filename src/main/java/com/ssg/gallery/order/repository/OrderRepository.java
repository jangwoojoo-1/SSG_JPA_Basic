package com.ssg.gallery.order.repository;

import com.ssg.gallery.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    //주문 목록 조회
    List<Order> findAllByMemberIdOrderByIdDesc(Integer memberId);
}
