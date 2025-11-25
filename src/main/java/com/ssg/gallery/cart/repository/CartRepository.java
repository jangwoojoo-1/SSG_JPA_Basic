package com.ssg.gallery.cart.repository;

import com.ssg.gallery.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart, Integer> {
    // 장바구니 목록 조회 (회원 기준)
    List<Cart> findByMemberId(Integer memberId);

    //장바구니 아이템 조회 (회원 기준)
    Optional<Cart> findByMemberIdAndItemId(Integer memberId, Integer itemId);

    //장바구니 전체 삭제(회원 기준)
    void deleteByMemberId(Integer memberId);

    //장바구니 아이템 삭제 (회원 기준)
    void deleteByMemberIdAndItemId(Integer memberId, Integer itemId);
}
