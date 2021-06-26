<script>
    export let title;
    export let content;
    export let button;
</script>

<style>
    .card {
        display: flex;
        flex-direction: column;
        border-radius: 10px;
        box-shadow: 2px 4px 5px rgba(0, 0, 0, 0.251);
        margin: 12px 12px 36px 12px;
        padding-left: 2%;
        padding-right: 2%;
    }
    .card:hover {
        box-shadow: 2px 4px 10px rgba(0, 0, 0, 0.302);
    }
    .card-header {
        padding: 2em 1rem 0.8em;
    }
    .card-content {
        padding: 1.34em 1em;
        font-size: 1.1em;
    }
    .card-footer {
        display: flex;
        padding: 0.8em 1em 1em;
    }
    .btn {
        border-radius: 4px;
        border-style: none;
        padding: 0.5em 1em;
        background-color: #0a47b8;
        color: #fee;
        cursor: pointer;
        font-weight: bold;
    }
    .btn:hover {
        background-color: #06358b;
    }
    .card-sm {
        max-width: 400px;
    }
    .card-md {
        max-width: 600px;
    }
    .card-lg {
        max-width: 800px;
    }
    .f-start {
        margin: 0 auto;
    }
    .f-center {
        margin-right: auto;
    }
    .f-end {
        margin-left: auto;
    }
    h1, h2, h3, h4, h5, h6, p {
        margin: 0;
    }
</style>

<div class="card card-sm">
    <div class="card-header">
        <h1>{title}</h1>
    </div>
    <div class="card-content">{content}</div>
    <div class="card-footer flex f-end">
        <button class="btn">{button}</button>
    </div>
    <!-- footer is optional and try f-start, f-center and f-end to justificate de footer content -->
</div>