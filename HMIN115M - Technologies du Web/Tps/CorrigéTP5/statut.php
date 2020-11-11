<?php

session_start();

$ok = $_SESSION["connexion"];

if ($ok) {
    echo 'Vous êtes connecté !<br><a href="deconnexion.php">se déconnecter</a>';
} else {
    echo 'Vous n\'êtes pas connecté.<br><a href="formulaire_connexion.html">essayer à nouveau</a>';
}
