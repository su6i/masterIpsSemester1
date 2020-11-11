<?php

/**
* Cours: Web Technologies
* Project: MarmitUM
* Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR
*/

define('APP_DIR', realpath(__DIR__ . '/../'));
define('TEMPLATES_DIR', APP_DIR . '/templates');
define('CONTROLLERS_DIR', APP_DIR . '/controllers');
define('LIB_DIR', APP_DIR . '/lib');
define('DB_DIR', APP_DIR . '/db');
define('STYLES_PATH', '/public/asset/css');
define('SCRIPTS_PATH', '/public/asset/js');
define('IMG_PATH', '/public/asset/img');


// associative array like dictionary in Python
// Routes
define('ROUTES', [
  '/'         => ['link' => '/home.php', 'title' => 'Home'],
  '/about'    => [ 'link' => '/about.php','title' => 'About' ],
  '/modify'   => [ 'link' => '/modify.php','title' => 'Modify' ],
  '/recipe/([0-9]+)'   => [ 'link' => '/recipe.php','title' => 'Recipe' ],
  '/recipes(\?search=.*)?'  => [ 'link' => '/recipes.php','title' => 'Recipes' ],
  '/login'    => [ 'link' => '/login.php','title' => 'Login' ],
  '/logout'   => [ 'link' => '/logout.php', 'title' => 'Logout' ]
]);

define('MENU_ITEMS', [
  "Accueil"         => "",
  "Recette"         => "recipes",
  "Qui Sommes Nous" => "about"
]);


define('API_FN', [
  'GET /recipe'    => 'get_recipe',
  'POST /recipe'    => 'add_recipe',
  'PUT /recipe'    => 'update_recipe',
  'GET /recipes'    => 'get_recipes',
  'DELETE /recipe'    => 'delete_recipe',
]);
