<?php
require_once("./libLoutre.php");

// on récupère l'identifiant de loutre fourni dans la requête
$idLoutre = $_REQUEST['id'];

$commentaires = getCommentaires($idLoutre);

// on informe le client qu'on va lui renvoyer des données au format JSON
header('Content-Type: application/json');

// on informe le client que tout s'est bien passé (code 200)
http_response_code(200);

// on envoie les données encodées au format JSON, sur la sortie standard
echo json_encode($commentaires);
