<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import {useAccountStore} from "@/stores/account";
import {watch} from "vue";
import {useRoute} from "vue-router";
import {check} from "@/services/accountService"; // 로그인 체크 여부 기능 불러오기

// 계정 스토어
const accountStore = useAccountStore(); // ①

// 라우트 객체
const route = useRoute(); // ②

// 로그인 여부 확인
const checkAccount = async () => { // ③
  const res = await check(); // 로그인 여부 확인 기능

  if (res.status === 200) {
    accountStore.setChecked(true);
    accountStore.setLoggedIn(res.data === true);
  } else {
    accountStore.setChecked(false);
  }
};

// 커스텀 생성 훅
(async function onCreated() {
  await checkAccount();
})();

// 라우트 경로가 바뀔 때마다 로그인 여부를 확인
// 즉, 로그인한 사람과 로그인 안 한 사람의 권한을 구별하는 것
watch(() => route.path, () => { // ⑤
  checkAccount();
});
</script>

<template>
  <template v-if="accountStore.checked">
    <Header/>
    <main>
      <!-- 라우터 뷰 -->
      <router-view></router-view> <!-- ⑥ -->
    </main>
    <Footer/>
  </template>
</template>