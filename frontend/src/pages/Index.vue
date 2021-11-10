<template>
  <q-page class="row justify-center items-center">
    <q-card
      flat
      bordered
      class="column items-center bg-grey-1"
      style="width: 1200px; height: 800px"
    >
      <q-card-section>
        <div class="row items-center no-wrap">
          <div class="text-h6">举例：消费者消费</div>
        </div>
      </q-card-section>

      <q-card-section>
        <q-img
          src="~assets/dubbo-arc.png"
          style="width: 600px; height: 500px"
        />
      </q-card-section>

      <q-separator />

      <q-card-actions>
        <q-btn flat @click="openUserGetDialog()">user info</q-btn>
        <q-btn flat @click="openTalkServiceDialog(1)">query time</q-btn>
        <q-btn flat @click="openTalkServiceDialog(2)">query ip</q-btn>
        <q-btn flat @click="openTalkServiceDialog(3)">query None</q-btn>
      </q-card-actions>
    </q-card>
  </q-page>
</template>

<script>

export default {
  name: "PageIndex",
  data() {
    return {
      icon: false,
    };
  },
  methods: {
    async openUserGetDialog() {
      let url = "/api/dubbo/user/get";
      let res = await this.$axios.get(url);

      this.$q.dialog({
        title: "TalkService from provider1",
        message: res.data,
        html: true,
        style: "width: 550px;"
      });
    },
    async openTalkServiceDialog(sid) {
      let url = "/api/dubbo/talk/" + sid + "/get";
      let res = await this.$axios.get(url);

      this.$q.dialog({
        title: "TalkService from provider2",
        message: res.data,
        html: true,
        style: "width: 550px;"
      });
    },

    // 原来的 基于组件的 qDialog 的写法，退出动画错误，可能和parent指针有关？？
  },
};
</script>
