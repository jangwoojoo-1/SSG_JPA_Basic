//fronted/src/components/Header.vue
<script setup>
import {useAccountStore} from "@/stores/account";
import {logout} from "@/services/accountService";
import {useRouter} from "vue-router";

// 계정 스토어
const accountStore = useAccountStore();

// 라우터 객체
const router = useRouter();

// 로그아웃
const logoutAccount = async () => {
  const res = await logout();

  if (res.status === 200) { // 백엔드에서 로그아웃이 되면
    accountStore.setLoggedIn(false);
    await router.push("/"); // Home.vue로 이동
  }
};
</script>

<template>
  <header>
    <div class="navbar navbar-dark bg-dark text-white shadow-sm">
      <div class="container">
        <router-link to="/" class="navbar-brand">
          <strong>Gallery</strong>
        </router-link>
        <div class="menus d-flex gap-3">
<!--          로그아웃이 안 되어 있으면-->
          <template v-if="!accountStore.loggedIn">
            <router-link to="/login">로그인</router-link>&nbsp
            <router-link to="/join">회원가입</router-link>
          </template>
<!--          로그인이 되어있으면-->
          <template v-else>
            <a @click="logoutAccount()">로그아웃</a>
            <router-link to="/orders">주문 내역</router-link>
            <router-link to="/cart">장바구니</router-link>
          </template>
        </div>
      </div>
    </div>
  </header>
</template>

<style lang="scss">
header {
  .menus {
    a {
      cursor: pointer;
      color: #fff;
      text-decoration: none;
    }
  }
}
</style>