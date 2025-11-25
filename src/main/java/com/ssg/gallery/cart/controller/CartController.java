package com.ssg.gallery.cart.controller;

import com.ssg.gallery.account.helper.AccountHelper;
import com.ssg.gallery.cart.dto.CartRead;
import com.ssg.gallery.cart.dto.CartRequest;
import com.ssg.gallery.cart.service.CartService;
import com.ssg.gallery.item.dto.ItemRead;
import com.ssg.gallery.item.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final ItemService itemService;
    private final AccountHelper accountHelper;

    @GetMapping("/api/cart/items")
    public ResponseEntity<?> readAll(HttpServletRequest request) {
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(request);

        //장바구니 목록 조회
        List<CartRead> carts = cartService.findAll(memberId);

        // 장바구니 상품으로 상품 조회
        List<Integer> itemIds = carts.stream().map(CartRead::getItemId).toList();
        List<ItemRead> items = itemService.findAll(itemIds);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/api/cart/items/{itemId}")
    public ResponseEntity<?> read(HttpServletRequest request, @PathVariable Integer itemId) {
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(request);

        //장바구니 데이터 조회 ( 특정 상품)
        CartRead cartRead = cartService.find(memberId, itemId);

        // 상품 아이디로 상품 조회
        ItemRead item = itemService.find(itemId);

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/api/carts")
    public ResponseEntity<?> push(HttpServletRequest request, @RequestBody CartRequest cartRequest) { // ⑧
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(request);

        // 장바구니 데이터 조회(특정 상품)
        CartRead cart = cartService.find(memberId, cartRequest.getItemId());

        // 장바구니 데이터가 없다면
        if (cart == null) {
            cartService.save(cartRequest.toEntity(memberId));
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/cart/items")
    public ResponseEntity<?> removeAll(HttpServletRequest request) {
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(request);

        cartService.removeAll(memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/cart/items/{itemId}")
    public ResponseEntity<?> remove(HttpServletRequest req, @PathVariable("itemId") Integer itemId) { // ⑨
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(req);

        cartService.remove(memberId, itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
