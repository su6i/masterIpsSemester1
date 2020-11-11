<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR

$data = [];
$data['PageTitle'] = "Page Not Found - 404";
$data['message'] = "Page Not Found :(";

render_custom_template("404.php", $data);
