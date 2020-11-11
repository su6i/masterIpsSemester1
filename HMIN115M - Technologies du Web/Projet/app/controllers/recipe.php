<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR


$data = [];
$data['PageTitle'] ="Recipe";
$data['PageHeader'] = "MarmitUM Projet";
$data['carousel'] = true;

$url_parts = explode('/', trim($_SERVER['REQUEST_URI'], '/'));
$recipe_id = (int)$url_parts[1];
$recipe = get_recipe_by_id($recipe_id);


if (!empty($recipe['recipe'])) {
    $data['recipe'] = (object)$recipe['recipe'];
}

$data['last_update'] = $recipe['last_update'];


render_template('show_recipe.php', $data);
