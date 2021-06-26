<script>
    import Sidebar from './Sidebar.svelte';
</script>

<style>
   .container {
		display: flex;
	}
	.container__main {
        margin-left: 4%;
		/* Take the remaining width */
		flex: 1;
		/* Make it scrollable */
		overflow: auto;
	}
</style>

<div class="container">
    <!-- Sidebar -->
    <Sidebar/>

    <!-- Main -->
    <div class="container__main">
        <h1>ℹ About</h1>
        <p>
            This website was made for my <a href="https://github.com/krissemicolon/bibliothek_api">Java Spring Boot API</a>.
        </p>
    </div>
</div>