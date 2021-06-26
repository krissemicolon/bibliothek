<script>
    import Card from './Card.svelte';
    import Sidebar from './Sidebar.svelte';

    import axios from "axios";

    let books = '';

    axios.get('http://localhost:4545/books')
    .then((response) => {
        books = response.data;
    });

</script>

<style>
    :global(body) {
	    padding: 0;
	}
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
        
        <h1>📚 Books</h1>

        <!-- Loading Books as Cards-->
        <div>
            {#each books as book}
                <Card class="card" title={book.title} content={book.author} button="Borrow"/>
            {/each}
        </div>
    </div>
</div>