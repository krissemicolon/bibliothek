<script>
    import { Router, Route } from 'svelte-routing';
    import Books from '../components/Books.svelte';
    import Login from '../components/Login.svelte';
    import About from '../components/About.svelte';

    export let url = '';
</script>

<Router {url}>
    <div>
        <Route path="/" component={Books}/>
        <Route path="login" component={Login}/>
        <Route path="about" component={About}/>
    </div>
</Router>