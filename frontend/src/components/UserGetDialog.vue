<template>
  <q-dialog ref="UGDialog" style="width: 600px; height: 500px">
    <q-card flat bordered class="my-card">
      <q-card-section>
        <div class="text-h6">TalkService from provider1</div>
        <div class="subtitle">String</div>
      </q-card-section>

      <q-card-section class="q-pt-none">
        <p v-html="content"></p>
      </q-card-section>
    </q-card>
  </q-dialog>
</template>

<script>
export default {
  props: {
    url: {
      type: String,
    },
  },
  data() {
    return {
      content: null,
    };
  },
  mounted: async function () {
    let res = await this.$axios.get(this.url);
    this.content = res.data;
  },
  methods: {
    show() {
      this.$refs.UGDialog.show();
    },
    hide() {
      this.$refs.UGDialog.hide();
    },
  },
};
</script>

<style></style>
