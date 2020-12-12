<?php
    session_start();
    // var_dump($_REQUEST);

    // Récupération des variables envoyées par le formulaire.
    // $_REQUEST permet de récupérer les variables envoyées par la méthode GET ou
    // la méthode POST, sans avoir à changer le code.
    $titre = $_REQUEST["titre"];
    $cuisine = $_REQUEST["cuisine"];
    $recette = $_REQUEST["recette"];
    $adresse = $_REQUEST["adresse"];

    // Si l'emplacement en session 'nexiste pas, on le crée
    if (! isset($_SESSION["mes_recettes"])) {
        $_SESSION["mes_recettes"] = [];
    }

    // On ajoute les informations reçues du formulaire, à la
    // liste des informations conservées

    // A. version simple : on ne stocke que le titre
    // array_push($_SESSION["mes_recettes"], $titre);

    // B. version moins simple : on stocke plusieurs variables dans un tableau
    array_push($_SESSION["mes_recettes"], [
        "titre" => $titre,
        "type_cuisine" => $cuisine,
        "adresse_auteur" => $adresse,
        "instructions_recette" => $recette
    ]);

    // Affichage des recettes
    echo "<ol>";
    foreach ($_SESSION["mes_recettes"] as $rec) {
        // A. version simple : titre uniquement
        // echo "<li>" . $rec . "</li>";

        // B. version à plusieurs variables
        echo "<li>" . $rec["titre"] . " (" . $rec["type_cuisine"] . ") - par " . $rec["adresse_auteur"] . " : " . $rec["instructions_recette"] . "</li>";
    }
    echo "</ol>";
?>
