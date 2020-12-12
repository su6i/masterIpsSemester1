<html>

<head>
    <title></title>
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
        <!-- profil de l'espèce de loutre-->
        <div id="profil" class="bloc">
            <h2 id="tpl-nom"></h2>
            <h3 id="tpl-nomlatin"></h3>

            <!-- un joli bouton "pause" avec un id (unique) -->
            <button id="bouton_pause">Interrompre / reprendre le diaporama</button>

            <div id="container_images">
            </div>
            <p id="tpl-description">
            </p>
        </div>
        <!-- caractéristiques-->
        <div id="description" class="bloc">
            <ul>
                <li>
                    <label>Taille:</label> <span id="tpl-taillemin"></span> à <span id="tpl-taillemax"></span>cm de long
                </li>
                <li>
                    <label>Pelage:</label> <span id="tpl-pelage"></span>
                </li>
                <li>
                    <label>Poids:</label> <span id="tpl-poidsmin"></span> à <span id="tpl-poidsmax"></span>kg
                </li>
            </ul>
        </div>
        <!-- liste des amis -->
        <div id="amis" class="bloc">
            <h2>Amis</h2>
            ON NE S'OCCUPE PAS DES AMIS DANS LE TP6
        </div>
        <!-- commentaires -->
        <div id="commentaires" class="bloc">
            <h2>Commentaires</h2>
            <form id="ajout_commentaire">
                <label>pseudo : </label><input type="text" name="auteur"><br>
                <label>commentaire : </label><input type="text" name="texte"><br>
                <input type="submit" value="Envoyer">
            </form>
            <div id="liste_commentaires">
            </div>
        </div>
    </div>
</body>

</html>
