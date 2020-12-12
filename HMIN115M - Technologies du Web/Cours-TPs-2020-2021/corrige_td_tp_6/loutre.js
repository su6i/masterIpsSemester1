// toujours placer le code Javascript à l'intérieur de l'écouteur d'événement "DOMContentLoaded"
document.addEventListener('DOMContentLoaded', () => {

    console.log("la page est chargée !");

    const paramsString = window.location.search;
    const parametresURL = new URLSearchParams(paramsString);
    const idLoutreEnCours = parametresURL.get("idloutre");
    console.log("ID loutre lu dans l'URL", idLoutreEnCours);

    // ------------------------- code des infos loutres (TP 6) -------------------------------------

    const requeteHTTPGetInfosLoutre = new XMLHttpRequest();
    requeteHTTPGetInfosLoutre.addEventListener("load", (evt) => {
        const jsonData = evt.target.responseText;
        // console.log("résultat du webservice reçu", jsonData);
        const data = JSON.parse(jsonData);
        console.log("données décodées", data);
        // injection des différentes informations dans les emplacements prévus dans le template HTML
        document.getElementById("tpl-nom").innerHTML = data["nom"];
        document.getElementById("tpl-nomlatin").innerHTML = data["nom_latin"];
        document.getElementById("tpl-description").innerHTML = data["description"];
        document.getElementById("tpl-taillemin").innerHTML = data["taille_min"];
        document.getElementById("tpl-taillemax").innerHTML = data["taille_max"];
        document.getElementById("tpl-pelage").innerHTML = data["pelage"];
        document.getElementById("tpl-poidsmin").innerHTML = data["poids_min"];
        document.getElementById("tpl-poidsmax").innerHTML = data["poids_max"];
        for (let i = 0; i < data["images"].length; i++) {
            container_images.innerHTML += '<img src="' + data["images"][i] + '">';
        }
        // on initialise le diaporama seulement lorsque toutes les images sont chargées
        initDiaporama();
    });
    requeteHTTPGetInfosLoutre.open("get", "wsInfosLoutre.php?id=" + idLoutreEnCours);
    requeteHTTPGetInfosLoutre.send();

    // ------------------------- code des commentaires (TP 5) -------------------------------------

    const emplacementListeCommentaires = document.getElementById("liste_commentaires");
    // l'id loutre est lu en haut de ce fichier, il sert à la fois au code des
    // commentaires ci-dessous, et au code du chargement des infos loutre ci-dessus

    setInterval(lireEtAfficherCommentaires, 500);

    function lireEtAfficherCommentaires() {
        const requeteHTTPGet = new XMLHttpRequest();
        requeteHTTPGet.addEventListener("load", (evt) => {
            const jsonData = evt.target.responseText;
            // console.log("résultat du webservice reçu", jsonData);
            const data = JSON.parse(jsonData);
            // console.log("données décodées", data);
            // vidage des commentaires déjà affichés
            emplacementListeCommentaires.innerHTML = "";
            for (const comm of data) {
                emplacementListeCommentaires.innerHTML += '<span class="titre_comm">' + comm.auteur + " (" + comm.date + ")</span> : " + comm.texte + "<br>";
            }
        });
        requeteHTTPGet.open("get", "wsListeCommentaires.php?id=" + idLoutreEnCours);
        requeteHTTPGet.send();
    }

    const formAjoutComm = document.getElementById("ajout_commentaire");
    formAjoutComm.addEventListener("submit", (event) => {
        const requeteHTTPPost = new XMLHttpRequest();
        const donneesFormulaire = new FormData(formAjoutComm);
        donneesFormulaire.append("id_loutre", idLoutreEnCours);
        donneesFormulaire.append("date", new Date().toISOString());
        requeteHTTPPost.open("post", "wsAjoutCommentaire.php");
        requeteHTTPPost.send(donneesFormulaire);
        event.preventDefault();
    });

    // ------------------------- code du diaporama (TP 4) -----------------------------------------

    function initDiaporama() {
        const images = document.querySelectorAll("#container_images > img");

        let index = 1; // la 1ère image est déjà affichée

        // toutes les 1.5 secondes, appeler la fonction afficheSuivante()
        setInterval(afficheSuivante, 1500);

        let enPause = false;

        // cette fonction masque toutes les images à l'exception
        // de la n-imème (n = index)
        function afficheSuivante() {
            if (! enPause) {
                for (let i = 0; i < images.length; i++) {
                    if (index === i) {
                        // console.log("affichage de l'image " + index);
                        images[i].style.display = "block";
                    } else {
                        images[i].style.display = "none";
                    }
                }
                index = (index + 1) % images.length;
            }
        }

        // lors de l'événement "click" (clic de souris) sur le bouton pause,
        // basculer le mode pause
        const leBoutonPause = document.getElementById("bouton_pause");
        leBoutonPause.addEventListener("click", () => {
            enPause = ! enPause; // inversion de la valeur booléenne
            // console.log("en pause (bouton) :", enPause);
        });

        // ajout d'écouteurs d'événements à toutes les images
        for (const im of images) {
            // lors de l'événement "mouseover" (la souris passe au dessus de l'élément),
            // mettre en pause
            im.addEventListener("mouseover", () => {
                enPause = true;
                // console.log("en pause (survol) :", enPause);
            });
            // lors de l'événement "mouseover" (la souris quitte la zone de l'élément),
            // sortir de la pause
            im.addEventListener("mouseout", () => {
                enPause = false;
                // console.log("en pause (survol) :", enPause);
            });
        }
    }
    
});
