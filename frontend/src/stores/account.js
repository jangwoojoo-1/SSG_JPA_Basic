import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useAccountStore = defineStore("account", {
    state: () => ({
        checked: false, // ②
        loggedIn: false, // ③
    }),
    actions: {
        setChecked(val) { // ④
            this.checked = val;
        },
        setLoggedIn(val) { // ⑤
            this.loggedIn = val;
        },
    },
});
