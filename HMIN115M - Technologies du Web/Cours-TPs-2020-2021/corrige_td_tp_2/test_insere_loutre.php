<?php

echo "Test: insertion d'une nouvelle loutre\n";

require_once("libLoutre.php");

$ret = addLoutre([
    "nom" => "Loutre imaginaire",
    "nom_latin" => "Lutra imagina Ch.",
    "image" => "https://pixnio.com/free-images/2018/07/07/2018-07-07-16-51-48-793x900.jpg",
    "description" => "Une loutre qui n'existe pas<br>C'est bien dommage car elle a l'air sympa.",
    "taille_min" => 20,
    "taille_max" => 600,
    "pelage" => "arc-en-ciel",
    "poids_min" => 2,
    "poids_max" => 150
]);
var_dump($ret);
