<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR

if (preg_match('/\.(?:png|jpg|jpeg|gif|css|js|html|ico)$/', $_SERVER["REQUEST_URI"])) {
    return false;    // serve the requested resource as-is.
} else {
    include __DIR__ . DIRECTORY_SEPARATOR . 'public/index.php';
}