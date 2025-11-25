//계정 서비스 구현
// frontend/src/services/accountService.js
import axios from "axios";

// 회원가입 : HTTP POST 메서드로 회원가입 API를 호출하고 응답값을 리턴하는 기능
export const join = (args) => { // ①
    return axios.post("/v1/api/account/join", args).catch(e => e.response);
};

// 로그인 : HTTP POST 메서드로 로그인 API를 호출하고 응답값을 리턴하는 기능
export const login = (args) => { // ②
    return axios.post("/v1/api/account/login", args).catch(e => e.response);
};

// 로그인 여부 확인 : HTTP GET 메서드로 로그인 여부 확인 API를 호출하고 응닶값을 리턴하는 기능
export const check = () => { // ③
    return axios.get("/v1/api/account/check").catch(e => e.response);
};

// 로그아웃 : HTTP POST 메서드로 로그아웃 API를 호출하고 응답값을 리턴하는 기능
export const logout = () => { // ④
    return axios.post("/v1/api/account/logout").catch(e => e.response);
};