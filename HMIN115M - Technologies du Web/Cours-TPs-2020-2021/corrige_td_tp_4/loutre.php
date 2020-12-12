<html>

<?php
    // Comment servir cette page :
    // ---------------------------
    //
    // cd ~/otterbook
    // php -S localhost:8000
    // => http://localhost:8000/loutre.php

require_once("libLoutre.php");

$infosLoutre = getLoutreById($_REQUEST["idloutre"] ?? 1);
// var_dump($infosLoutre); // debug
$amisLoutre = getAmis($infosLoutre['id']);
// var_dump($amisLoutre); // debug
?>

<head>
    <title><?php echo $infosLoutre ? $infosLoutre["nom"] : "loutre introuvable :(" ?> | Otterbook - </title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="otterbook.css">
    <script type="text/javascript" src="loutre.js"></script>
</head>


<body>
    <!-- barre d'entête -->
    <header>
        <div id="logo">
            otterbook
        </div>
    </header>

    <!-- conteneur flex -->
    <div id="container">
        <?php if ($infosLoutre): ?>
            <!-- profil de l'espèce de loutre-->
            <div id="profil" class="bloc">
                <h2><?php echo $infosLoutre["nom"]; ?></h2>
                <h3><?php echo $infosLoutre["nom_latin"]; ?></h3>

                <!-- un joli bouton "pause" avec un id (unique) -->
                <button id="bouton_pause">Interrompre / reprendre le diaporama</button>

                <div id="container_images">
                    <!-- une boucle PHP pour afficher toutes les images -->
                    <?php foreach($infosLoutre["images"] as $image): ?>
                        <img src="<?php echo $image; ?>">
                    <?php endforeach; ?>
                </div>
                <p>
                    <?php echo $infosLoutre["description"]; ?>
                </p>
            </div>
            <!-- caractéristiques-->
            <div id="description" class="bloc">
                <ul>
                    <li>
                        <label>Taille:</label> <?php echo $infosLoutre["taille_min"]; ?> à <?php echo $infosLoutre["taille_max"]; ?>cm de long
                    </li>
                    <li>
                        <label>Pelage:</label> <?php echo $infosLoutre["pelage"]; ?>
                    </li>
                    <li>
                        <label>Poids:</label> <?php echo $infosLoutre["poids_min"]; ?> à <?php echo $infosLoutre["poids_max"]; ?>kg
                    </li>
                </ul>
            </div>
            <!-- liste des amis -->
            <div id="amis" class="bloc">
                <h2>Amis</h2>
                <?php
                    foreach ($amisLoutre as $idAmi) {
                        $pote = getLoutreById($idAmi);
                        if ($pote) {
                            echo '<a href="loutre.php?idloutre=' . $idAmi . '">' . $pote["nom"] . '</a><br>';
                        } // else: échec silencieux
                    }
                ?>
            </div>
        <?php else: ?>
            <h1>Loutre introuvable… vérifiez le paramètre "idloutre"</h1>
        <?php endif; ?>
    </div>
</body>

</html>
