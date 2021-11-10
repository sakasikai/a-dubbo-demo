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
        <q-btn flat @click="openUserGetDialog()">UserGet</q-btn>
        <q-btn flat @click="openTalkServiceDialog(1)">TalkService1</q-btn>
        <q-btn flat @click="openTalkServiceDialog(2)">TalkService2</q-btn>
      </q-card-actions>
    </q-card>
  </q-page>
</template>

<script>
import UserGetDialog from "components/UserGetDialog";
import TalkServiceDialog from "components/TalkServiceDialog";

export default {
  name: "PageIndex",
  methods: {
    async openUserGetDialog() {
      let url = "/api/dubbo/user/get";
      // let res = "tes"

      this.$q.dialog({
        component: UserGetDialog,
        parent: this,
        url: url,
      });
    },
    async openTalkServiceDialog(sid) {
      let url = "/api/dubbo/talk/" + sid + "/get";
      // let res = "tes"

      this.$q.dialog({
        component: TalkServiceDialog,
        parent: this,
        url: url
      });
    },
  },
};
</script>
