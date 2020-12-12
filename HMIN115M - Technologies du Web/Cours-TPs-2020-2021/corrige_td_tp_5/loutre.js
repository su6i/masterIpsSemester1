// toujours placer le code Javascript à l'intérieur de l'écouteur d'événement "DOMContentLoaded"
document.addEventListener('DOMContentLoaded', () => {

    console.log("la page est chargée !");

    // ------------------------- code des commentaires -------------------------------------

    const emplacementListeCommentaires = document.getElementById("liste_commentaires");
    const idLoutreEnCours = emplacementListeCommentaires.dataset.idloutre;

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

    // ------------------------- code du diaporama -----------------------------------------

    const images = document.querySelectorAll("#container_images > img");

    // index correspond à l'image en cours d'affichage
    let index = 1; // la 1ère image est affichée par défaut

    // toutes les 1.5 secondes, appeler la fonction afficherImageSuivante()
    setInterval(afficherImageSuivante, 1500);

    var enPause = false;

    // cette fonction masque toutes les images à l'exception
    // de la n-ième (n = index)
    function afficherImageSuivante() {
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
    
});
