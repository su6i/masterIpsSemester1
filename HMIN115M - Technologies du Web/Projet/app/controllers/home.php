<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR


$data = [];
$data['PageTitle'] ="Home";
$data['PageHeader'] = "MarmitUM Projet";
$data['carousel'] = true;

$recipes_list = (object)get_recipes_list();

// slice of all recipes
$data['recipes'] = array_slice($recipes_list->data, 0, 3);
$data['last_update'] = $recipes_list->last_update;


render_template('_recipes_list.php', $data);
