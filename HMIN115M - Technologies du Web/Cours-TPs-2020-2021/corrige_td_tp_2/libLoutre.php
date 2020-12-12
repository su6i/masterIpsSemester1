<?php

function getLoutreById($id) {
    // connexion à la base de données SQL
    $pdo = new PDO('sqlite:otterbook.db');
    // requête de sélection de la loutre ayant l'identifiant $id (colonne "id")
    $requeteSQL = "SELECT * FROM loutres WHERE id=" . $id;
    // exécution de la requête
    $stm = $pdo->query($requeteSQL);
    // récupération du résultat
    $infosLoutre = $stm->fetch(PDO::FETCH_ASSOC);

    return $infosLoutre;
}

function getAmis($id) {
    // connexion à la base de données SQL
    $pdo = new PDO('sqlite:otterbook.db');
    // requête de sélection des amis de la loutre ayant l'identifiant $id
    $requeteSQL = "SELECT * FROM amis WHERE id_loutre_a=" . $id . " OR id_loutre_b=" . $id;;
    // exécution de la requête
    $stm = $pdo->query($requeteSQL);
    // récupération du résultat
    $amisLoutre = $stm->fetchAll(PDO::FETCH_ASSOC);
    // agrégation des identifiants des amis en une lsite à plat
    $amis = [];
    foreach ($amisLoutre as $a) {
        if ($a["id_loutre_a"] == $id) {
            array_push($amis, $a["id_loutre_b"]);
        } else {
            array_push($amis, $a["id_loutre_a"]);
        }
    }
    return $amis;
}

function deleteLoutreById($id) {
    // connexion à la base de données SQL
    $pdo = new PDO('sqlite:otterbook.db');
    // requête de suppression de la loutre ayant l'identifiant $id (colonne "id")
    $requeteSQL = "DELETE FROM loutres WHERE id=" . $id;
    // exécution de la requête
    $stmt = $pdo->prepare($requeteSQL);
    $stmt->execute();

    // NOTE : il faudrait aussi supprimer les amis !

    return ($stmt->rowCount() === 1); // valeur booléenne
}

function addLoutre($infosLoutre) {
    // connexion à la base de données SQL
    $pdo = new PDO('sqlite:otterbook.db');
    // requête d'insertion de données; l'identifiant est automatique si on ne le fournit pas
    $requeteSQL = "INSERT INTO loutres (nom, nom_latin, image, description, taille_min, taille_max, pelage, poids_min, poids_max) VALUES(:nom, :nom_latin, :image, :description, :taille_min, :taille_max, :pelage, :poids_min, :poids_max)";
    // exécution de la requête
    $stmt = $pdo->prepare($requeteSQL);
    return $stmt->execute($infosLoutre);
}
