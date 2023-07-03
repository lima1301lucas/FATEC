if (document.querySelectorAll(".ver-mais").length > 0) {
    var seta = document.querySelectorAll(".ver-mais");

    for (var i = 0; i < seta.length; i++) {
        seta[i].addEventListener("click", function (e) {
            var itemClick = e.currentTarget;
            var itemDesc = itemClick.parentElement.parentElement.querySelector(".descricao-materia");
            console.log('Elemento clicado:', itemClick);

            if (itemDesc.classList.contains("active") == true) {
                itemClick.classList.remove("active");
                itemDesc.classList.remove("active");
            } 
            else {
                var itemDescGeral = document.querySelectorAll(".descricao-materia");
                for (var i = 0; i < itemDescGeral.length; i++) {
                    itemDescGeral[i].classList.remove("active");
                }
                itemClick.classList.add("active");
                itemDesc.classList.add("active");
            }
        });
    }
}