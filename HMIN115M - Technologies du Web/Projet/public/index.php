<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR

session_start();

require_once realpath(__DIR__ . '/../app/config/constants.php');
require_once realpath(LIB_DIR . '/functions.php');
require_once realpath(LIB_DIR . '/api.php');

if (isset($_SERVER['REQUEST_URI']) && !in_array($_SERVER['REQUEST_URI'], ['/login', '/logout'])) {
    $url =  addslashes($_SERVER['REQUEST_URI']);
    setcookie('PREV_URL', $url);
}

// api
CheckAPICall();

foreach (ROUTES as $route => $value) {
    $search_for = str_replace('/', '\\/', $route);
    $pattern = "/^" . $search_for . "$/";
    if (preg_match($pattern, $_SERVER['REQUEST_URI']) == 1) {
        require_once CONTROLLERS_DIR . ROUTES[$route]['link'];
        die();
    }
}

require_once CONTROLLERS_DIR . '/notfound.php';