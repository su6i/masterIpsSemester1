<?php

$comptes = json_decode(file_get_contents("./comptes.json"), true);

array_push($comptes, [
    "adresse" => $_REQUEST["adresse_email"],
    "mdp" => md5($_REQUEST["mot_de_passe"])
]);

file_put_contents("./comptes.json", json_encode($comptes));
