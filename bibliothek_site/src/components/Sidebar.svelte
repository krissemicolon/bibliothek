<script>
    import { Link } from 'svelte-routing';
</script>

<style>
    .custom-restricted-width {
        /* To limit the menu width to the content of the menu: */
        display: inline-block;
        /* Or set the width explicitly: */
        /* width: 10em; */
    }
    .sidebar {
        font-size: 20px;
        /* background-color: #e3e3e3; */
    }
</style>

<div class="sidebar pure-menu custom-restricted-width">
    <span class="pure-menu-heading">Bibliothek</span>
    <ul class="pure-menu-list">
        <li class="pure-menu-item">
            <Link to="/" class="pure-menu-link">📚 Books</Link>
        </li>
        <li class="pure-menu-item">
            <Link to="login" class="pure-menu-link">👤 Login</Link>
        </li>
        <li class="pure-menu-item">
            <Link to="about" class="pure-menu-link">ℹ About</Link>
        </li>
    </ul>
</div>