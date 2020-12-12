<html>

<head>
    <title>Ajouter une nouvelle loutre</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="otterbook.css">
    <script type="text/javascript" src="ajoutloutre.js"></script>
</head>

<body>
    <!-- barre d'entête -->
    <header>
        <div id="logo">
            otterbook - ajout de loutre
        </div>
    </header>

    <!-- conteneur flex -->
    <div id="container">
        <form id="nouvelle-loutre" enctype="multipart/form-data" method="post">
            <label>Nom</label>
            <input type="text" name="nom" required pattern="[a-zA-Z -]+">
            <br>
            <label>Nom latin</label>
            <input type="text" name="nom_latin" required>
            <br>
            <label>Image</label>
            <input type="url" name="image">
            <!--<input type="file" name="image">-->
            <br>
            <label>Description</label>
            <br>
            <textarea name="description" required></textarea>
            <br>
            <label>Taille minimale (cm)</label>
            <input type="number" min="10" max=200" name="taille_min">
            <br>
            <label>Taille maximale (cm)</label>
            <input type="number" min="10" max=200" name="taille_max">
            <br>
            <label>Pelage</label>
            <select name="pelage">
                <option value="brun foncé">Brun foncé</option>
                <option value="brun clair">Brun clair</option>
                <option value="noir">Noir</option>
                <option value="blanc">Blanc</option>
                <option value="autre">Rouge et vert à petits pois</option>
            </select>
            <br>
            <label>Poids minimal (kg)</label>
            <input type="number" min="1" max="50" name="poids_min">
            <br>
            <label>Poids maximal (kg)</label>
            <input type="number" min="20" max="500" name="poids_max">
            <br>
            <input type="submit" value="Ajouter">
        </form>
    </div>
</body>

</html>
