package com.ssg.gallery.cart.service;

import com.ssg.gallery.cart.dto.CartRead;
import com.ssg.gallery.cart.entity.Cart;

import java.util.List;

public interface CartService {
    // 장바구니 상품 목록 조회
    List<CartRead> findAll(Integer memberId);

    // 장바구니 상품 데이터 조회
    CartRead find(Integer memberId, Integer itemId);

    // 장바구니 상품 데이터 전체 삭제
    void removeAll(Integer memberId);

    // 장바구니 상품 데이터 삭제
    void remove(Integer memberId, Integer itemId);

    // 장바구니 상품 데이터 저장
    void save(Cart cart);
}
