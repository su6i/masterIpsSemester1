<?php
require_once("./libLoutre.php");

// on récupère les paramètres de la requête, et on considère qu'ils contiennent
// les données nécessaires pour caractériser un commentaires : id_loutre, texte,
// auteur, date. Si ces 4 paramètres ne sont pas fournis, la requête SQL échouera !
$infosCommentaire = $_REQUEST;

// var_dump($_REQUEST);

addCommentaire($infosCommentaire);

// on informe le client que tout s'est bien passé (code 200)
http_response_code(200);

// on n'envoie pas de données : inutile donc d'en spécifier le format. Pas
// de header() ni de echo
