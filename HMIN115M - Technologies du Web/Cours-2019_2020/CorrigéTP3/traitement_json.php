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

    $emplacement_fichier = "./data.json";

    // Si le fichier JSON existe, on passe à la suite
    if (file_exists($emplacement_fichier)) {
        // Lecture du fichier : on obtient une chaîne de caractères
        $contenu_fichier = file_get_contents($emplacement_fichier);
        // Décodage du format de fichier : on obtient un tableau
        $donnees = json_decode($contenu_fichier, true);
        // La première fois, si le fichier était vide, on initialise le
        // contenu avec un nouveau tableau vide
        if ($donnees == "") {
            $donnees = [];
        }

        // On ajoute les informations reçues du formulaire, à la
        // liste des informations conservées
        array_push($donnees, [
            "titre" => $titre,
            "type_cuisine" => $cuisine,
            "adresse_auteur" => $adresse,
            "instructions_recette" => $recette
        ]);

        // On encode le nouveau contenu
        $nouveau_contenu = json_encode($donnees);
        // On enregistre ce nouveau contenu dans le fichier (on écrase le contenu précédent)
        file_put_contents($emplacement_fichier, $nouveau_contenu);

        // Affichage des recettes
        echo "<ol>";
        foreach ($donnees as $rec) {
            // A. version simple : titre uniquement
            // echo "<li>" . $rec . "</li>";
    
            // B. version à plusieurs variables
            echo "<li>" . $rec["titre"] . " (" . $rec["type_cuisine"] . ") - par " . $rec["adresse_auteur"] . " : " . $rec["instructions_recette"] . "</li>";
        }
        echo "</ol>";
    }
?>
