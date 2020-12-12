<?php
    // Lorsque le paramètre est passé dans l'URL (méthode GET), on utilise la superglobale $_GET.
    // Mais on pourrait aussi utiliser $_REQUEST

    // ! empty() vérifie que le paramètre existe et contient une valeur non-vide
    if (! empty($_GET["recette"])) {
        echo '<a href="https://www.google.com/search?q=' . $_GET["recette"] . '">' . $_GET["recette"] . '</a>';
    }
?>