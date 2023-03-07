<script lang="ts">
  import type { PageData } from "./$types";
  export let data: PageData;

  function getChildren(doc: any): any[] {
    if (doc.children.length === 0) {
      return [doc];
    }

    return doc.children.map((d: any) => getChildren(d));
  }

  const docs = data.collection.data.documents.flatMap(getChildren).flatMap((d: any) => d)
</script>

<h1>Welcome to SvelteKit</h1>
<p>Visit <a href="https://kit.svelte.dev">kit.svelte.dev</a> to read the documentation</p>

<div class="list">
{#each docs as doc}
<a class="document" href="/documents/{doc.id}">{doc.title}</a>
{/each}
</div>



<style lang="scss">
  .list {
    display: flex;
    flex-direction: column;
    gap: 1rem;
  }
</style>