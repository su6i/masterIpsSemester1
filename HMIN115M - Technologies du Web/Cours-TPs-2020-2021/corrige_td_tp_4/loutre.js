// toujours placer le code Javascript à l'intérieur de l'écouteur d'événement "DOMContentLoaded"
document.addEventListener('DOMContentLoaded', () => {

    console.log("la page est chargée !");

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
                    console.log("affichage de l'image " + index);
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
        console.log("en pause (bouton) :", enPause);
    });

    // ajout d'écouteurs d'événements à toutes les images
    for (const im of images) {
        // lors de l'événement "mouseover" (la souris passe au dessus de l'élément),
        // mettre en pause
        im.addEventListener("mouseover", () => {
            enPause = true;
            console.log("en pause (survol) :", enPause);
        });
        // lors de l'événement "mouseover" (la souris quitte la zone de l'élément),
        // sortir de la pause
        im.addEventListener("mouseout", () => {
            enPause = false;
            console.log("en pause (survol) :", enPause);
        });
    }
    
});
