import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

// Pinia에서 제공하는 defineStore라는 메서드를 호출해서 스토어를 정의한 것,
// 계정 데이터를 다루는 계정 스토어
// id 'account'는 스토어의 고유 식별자
export const useAccountStore = defineStore("account", {
    state: () => ({
        checked: false,   // 사용자의 로그인 체크여부 프로퍼티
        loggedIn: false, // 사용자의 로그인 여부 값 프로퍼티
    }),
    actions: {
        setChecked(val) { //사용자의 로그인 체크 여부 값을 수정하는 메서드
            this.checked = val;
        },
        setLoggedIn(val) { // 사용자의 로그인 여부값을 수정하는 메서드
            this.loggedIn = val;
        },
    },
});
