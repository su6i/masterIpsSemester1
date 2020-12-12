// toujours placer le code Javascript à l'intérieur de l'écouteur d'événement "DOMContentLoaded"
document.addEventListener('DOMContentLoaded', () => {

    // ------------------------- code de l'ajout de loutre (TP 6) -------------------------------------

    const formAjoutLoutre = document.getElementById("nouvelle-loutre");
    formAjoutLoutre.addEventListener("submit", (event) => {
        const requeteHTTPPost = new XMLHttpRequest();
        const donneesFormulaire = new FormData(formAjoutLoutre);
        requeteHTTPPost.open("post", "wsAjoutLoutre.php");
        requeteHTTPPost.send(donneesFormulaire);
        event.preventDefault();
    });

});
