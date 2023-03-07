<script lang="ts">
  import SvelteMarkdown from 'svelte-markdown'
  import type { PageData } from "./$types";

  export let data: PageData;
  console.log(data)
</script>

<SvelteMarkdown source={data.document.data.text} />