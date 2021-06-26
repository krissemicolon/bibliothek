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
        <h1>👤 Login</h1>

        <form class="pure-form pure-form-aligned">
            <fieldset>
                <div class="pure-control-group">
                    <label for="aligned-name">Username</label>
                    <input type="text" id="aligned-name" placeholder="Username" />
                </div>
                <div class="pure-control-group">
                    <label for="aligned-password">Password</label>
                    <input type="password" id="aligned-password" placeholder="Password" />
                </div>
                <div class="pure-controls">
                    <label for="aligned-cb" class="pure-checkbox">
                    <button type="submit" class="pure-button pure-button-primary">Log in</button>
                </div>
            </fieldset>
        </form>

    </div>
</div>