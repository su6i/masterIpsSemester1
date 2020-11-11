<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR


$data = [];
$data['PageTitle'] ="Home";
$data['PageHeader'] = "MarmitUM Projet";
$data['carousel'] = true;

$query_for = null;
if (isset($_GET['search']) && strlen($_GET['search']) != 0) {
    $query_for = $_GET['search'];
}

$recipes_list = (object)get_recipes_list($query_for);

// slice of all recipes
$data['recipes'] = $recipes_list->data;
$data['last_update'] = $recipes_list->last_update;

render_template('_recipes_list.php', $data);
