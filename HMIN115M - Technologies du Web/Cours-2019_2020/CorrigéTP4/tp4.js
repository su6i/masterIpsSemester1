// fichier Javascript pour les exercices 2 à 4

// ex. 2 : on a besoin de l'écouteur d'événement pour attendre que la
// page HTML soit chargée, avant d'exécuter le code qui affiche "pwet"
document.addEventListener("DOMContentLoaded", () => {
    var leDiv = document.getElementById('message');
    leDiv.innerHTML = "pwet";
});


// ex. 3
function affiche() {
    var leDiv = document.getElementById('message');
    leDiv.innerHTML = "pwet de l'exercice 3";
}
document.addEventListener("DOMContentLoaded", () => {
    var leBouton = document.querySelector("#bouton");
    leBouton.addEventListener("click", () => {
        console.log("On affiche le message (ex.3) !!!");
        affiche();
    });
});


// ex. 4 : on concatène un nouveau message toutes les 2 secondes
function afficheEx4() {
    var leDiv = document.getElementById('message');
    leDiv.innerHTML += "<br>pwet de l'exercice 4";
}
document.addEventListener("DOMContentLoaded", () => {
    setInterval(afficheEx4, 2000);
});