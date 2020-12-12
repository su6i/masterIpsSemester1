<?php
require_once("./libLoutre.php");

// on récupère les paramètres de la requête, et on considère qu'ils contiennent
// les données nécessaires pour caractériser une loutre; si certains paramètres
// ne sont pas fournis, la requête SQL échouera !
$infosLoutre = $_REQUEST;

var_dump($_REQUEST);

addLoutre($infosLoutre);

// on informe le client que tout s'est bien passé (code 200)
http_response_code(200);

// on n'envoie pas de données : inutile donc d'en spécifier le format. Pas
// de header() ni de echo
