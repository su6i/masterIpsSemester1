<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR


if (!is_logged_in()) {
    header("Location: /");
    die();
}

$data = [];
$data['PageTitle'] ="Modify";
$data['PageHeader'] = "Modify";

$recipes_list = (object)get_recipes_list();
// slice of all recipes
$data['recipes'] = $recipes_list->data;
$data['last_update'] = $recipes_list->last_update;
$data['index'] = 0;

render_template('_recipe_modify.php', $data);
