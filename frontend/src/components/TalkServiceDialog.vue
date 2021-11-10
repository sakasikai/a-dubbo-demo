<template>
  <q-dialog ref="TSDialog" style="width: 600px; height: 500px">
    <q-card flat bordered class="my-card">
      <q-card-section>
        <div class="text-h6">TalkService from provider2</div>
        <div class="subtitle">Object.tostring</div>
      </q-card-section>

      <q-card-section class="q-pt-none" >
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
      this.$refs.TSDialog.show();
    },
    hide() {
      this.$refs.TSDialog.hide();
    },
  },
};
</script>

<style></style>
