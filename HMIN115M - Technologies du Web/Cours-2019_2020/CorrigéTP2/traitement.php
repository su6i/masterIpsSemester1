<?php
    // var_dump($_REQUEST);

    // Récupération des variables envoyées par le formulaire.
    // $_REQUEST permet de récupérer les variables envoyées par la méthode GET ou
    // la méthode POST, sans avoir à changer le code.
    $titre = $_REQUEST["titre"];
    $type = $_REQUEST["type"];
    $cuisine = $_REQUEST["cuisine"];
    $allergenes = $_REQUEST["allergenes"];
    $difficulte = $_REQUEST["difficulte"];
    $temps = $_REQUEST["temps"];
    $recette = $_REQUEST["recette"];
    $date = $_REQUEST["date"];
    $photo = $_REQUEST["photo"];
    $adresse = $_REQUEST["adresse"];

    // conversion de l'indicateur de difficulté (1, 2 ou 3) en un texte compréhensible
    $difficulte_texte = [ "facile", "moyenne", "difficile" ];

    // Récupération du fichier image uploadé
    $nouvelEmplacementFichierUploade = null;
    $nomFichierUploade = null;
    if (! empty($_FILES["photo_fichier"])) {
        $nomFichierUploade = $_FILES["photo_fichier"]["name"];
        $nouvelEmplacementFichierUploade = __DIR__ . "/" . $nomFichierUploade; // __DIR__ représente le dossier dans lequel se trouve ce fichier
        move_uploaded_file($_FILES["photo_fichier"]["tmp_name"], $nouvelEmplacementFichierUploade);
    }

    // ---------- affichage de la recette ! -------------

    echo "<h1>" . $titre . "</h1>";
    echo "Recette de cuisine <strong>" . $cuisine . "</strong> proposée par " . $adresse . " (date: " . $date . ")";

    echo "<h2>Informations</h2>";
    echo "<p>Type: " . $type . "</p>";
    echo "<p>Difficulté: " . $difficulte_texte[$difficulte - 1] . "</p>";
    echo "<p>Temps de préparation: " . $temps . "</p>";

    echo "<h2>Allergènes</h2>";
    echo "<ul>";
    foreach ($allergenes as $a) {
        echo "<li>" . $a . "</li>";
    }
    echo "</ul>";

    echo "<h2>Instructions</h2>";
    echo $recette;

    echo "<h2>Illustrations</h2>";
    echo '<img src="' . $photo . '">';
    echo "<br>";
    // Si le fichier image a bien été reçu
    if ($nomFichierUploade !== null) {
        echo '<img src="' . $nomFichierUploade . '">';
    }
?>
