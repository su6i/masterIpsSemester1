<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR


$data = [];
$data['PageTitle']  = "About";
$data['PageHeader'] = "Qui sommes-nous?";
$data['about'] = 'something about food';
$data['carousel'] = false;

$recipes_list = (object)get_recipes_list();
$data['last_update'] = $recipes_list->last_update;
render_template('_about_content.php', $data);
