<?php
    session_start();

    // A. version bourrine : on détruit tout ce qu'il y a dans la session
    // session_destroy();

    // B. version plus subtile : on réinitialise uniquement la liste de recettes
    $_SESSION["mes_recettes"] = [];
?>