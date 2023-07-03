var urlpadrao = "http://localhost:8080";

function getDados(url){
    let request = new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
}

//________________________________________________________________ cria elemento professor
function criaItemProfessor(professor){
    let item = document.createElement("option")
    item.value = professor.id
    item.innerHTML = professor.idpessoa.nomecompleto

    return item
}

function criaProfessor(){
    professores = getDados(urlpadrao + "/consulta/professor");
        professores = JSON.parse(professores);
        let opcoes = document.getElementById("professores")
        professores.forEach(element => {
            let item = criaItemProfessor(element);
            opcoes.appendChild(item)
        })
}
//________________________________________________________________ cria elemento curso

function criaItemCurso(curso){
    let item = document.createElement("option")
    item.value = curso.id
    item.innerHTML = curso.nome

    return item
}

function criaCurso(){
    cursos = getDados(urlpadrao + "/consulta/cursos");
        cursos = JSON.parse(cursos);
        let opcoes = document.getElementById("cursos")
        cursos.forEach(element => {
            let item = criaItemCurso(element);
            opcoes.appendChild(item)
        })
}


function main(){
    criaCurso();
    criaProfessor();

}

main()