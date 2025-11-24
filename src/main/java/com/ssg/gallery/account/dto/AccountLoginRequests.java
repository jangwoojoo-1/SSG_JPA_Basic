package com.ssg.gallery.account.dto;


import lombok.Getter;

// 로그인을 요청할 때 사용
@Getter
public class AccountLoginRequests {
    private String loginId;
    private String loginPw;
}

