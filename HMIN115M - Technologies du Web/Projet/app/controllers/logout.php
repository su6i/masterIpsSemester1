<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR


$_SESSION = array();
session_destroy();

$url = $_COOKIE['PREV_URL'] ? $_COOKIE['PREV_URL'] : '/';
header("Location: $url");
