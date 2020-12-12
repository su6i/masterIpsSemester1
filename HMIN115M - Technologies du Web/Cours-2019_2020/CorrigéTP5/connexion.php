<?php
session_start();

$adresse = $_REQUEST["adresse_email"];
$mdp = $_REQUEST["mot_de_passe"];

$comptes = json_decode(file_get_contents("./comptes.json"), true);

$trouve = false;
foreach ($comptes as $c) {
    if ($c["adresse"] == $adresse && $c["mdp"] == md5($mdp)) {
        $trouve = true;
    }
}

$_SESSION["connexion"] = $trouve;

header("Location: statut.php");
