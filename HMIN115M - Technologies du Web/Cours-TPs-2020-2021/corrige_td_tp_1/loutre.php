<html>

<head>
    <title>Loutre d'Europe | Otterbook - </title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="otterbook.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>

<?php
    // Comment servir cette page :
    // ---------------------------
    //
    // cd ~/otterbook
    // php -S localhost:8000
    // => http://localhost:8000/lutra_lutra.php
?>

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
            <h2>Loutre d'europe</h2>
            <h3>Lutra lutra L.</h3>
            <img src="images/lutra_lutra.jpg" class="rounded-circle">
            <p>
                La seule espèce de loutre présente en France.
                <br>
                Elle est habituellement solitaire, occupant un territoire de 5 à 15 km de rives le long
                d'un cours d'eau (parfois davantage) ou de 20 à 30 km2 en zone de marais.
                Elle emprunte régulièrement les mêmes passages sur la berge pour se mettre à
                l'eau : les « coulées ». Lorsqu’elle sort de l’eau, elle se roule dans l’herbe pour
                essuyer sa fourrure, sur des zones reconnaissables à l’herbe couchée et appelées
                « places de ressui ». En montagne on peut la trouver jusqu'à une altitude de 1 300 m. 
            </p>
        </div>
        <!-- caractéristiques-->
        <div id="description" class="bloc">
            <ul>
                <li>
                    <label>Taille:</label> 60 à 80cm de long
                </li>
                <li>
                    <label>Pelage:</label> brun foncé
                </li>
                <li>
                    <label>Poids:</label> 5 à 15kg
                </li>
            </ul>
        </div>
        <!-- liste des amis -->
        <div id="amis" class="bloc">
            <h2>Amis</h2>
            <a href="lontra_canadensis.php">Loutre de rivière</a>
            <br>
            <a href=" pteronura_brasiliensis.php">Loutre géante</a>
        </div>
    </div>
</body>

</html>
