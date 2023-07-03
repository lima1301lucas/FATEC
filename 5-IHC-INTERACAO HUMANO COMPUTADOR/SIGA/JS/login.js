function fazLogin() {
    let emailUser = document.getElementById("inp-email").value;
    let pwdUser = document.getElementById("inp-pswd").value;

    let dados = {
        "identificador": emailUser.toString(),
        "senha": pwdUser.toString()
    };

    fetch("http://faculdadebackendnew-env.us-east-1.elasticbeanstalk.com/autenticacao/login/ALUNO", {

            method: "GET",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(dados)
        })
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));

    // .then(response => {
    //     if (response.status === 200) {
    //         if (nivel == 0) {
    //             window.location.href = "Admin-Home.html";
    //         }
    //         if (nivel == 1) {
    //             window.location.href = "Coordenador-Home.html";
    //         }
    //         if (nivel == 2) {
    //             window.location.href = "Professor-Home.html";
    //         }
    //     } else if (response.status === 400) {
    //         alert("Senha incorreta!");
    //     } else if (response.status === 404) {
    //         alert("Usuário não encontrado!");
    //     }
    // })

    // .catch(error => {
    //     console.error("Erro na requisição:", error);
    // });
}


$(document).ready(function () {
    $("#login").click(function () {
        // var settings = {
        //     "url": "http://faculdadebackendnew-env.us-east-1.elasticbeanstalk.com/autenticacao/login/ALUNO/",
        //     "method": "GET",
        //     "timeout": 0,
        //     "headers": {
        //         "Content-Type": "application/json"
        //     },
        //     "body": JSON.stringify({
        //         "identificador": "julinhateste@gmail.com",
        //         "senha": "testando"
        //     }),
        // };

        // $.ajax(settings).done(function (response) {
        //     console.log(response);
        // });



        // $.ajax({
        //     url: "http://faculdadebackendnew-env.us-east-1.elasticbeanstalk.com/autenticacao/login/ALUNO",
        //     type: 'GET',
        //     contentType: 'application/json',
        //     headers: {
        //         "Content-Type": "application/json"
        //     },
        //     data: JSON.stringify({
        //         "identificador": "julinhateste@gmail.com",
        //         "senha": "testando"
        //     }),
        //     success: function (data) {
        //         alert(data);
        //     },
        //     error: function (data) {
        //         alert(data.responseText);
        //     }
        // });

        $.ajax({
            url: "http://faculdadebackendnew-env.us-east-1.elasticbeanstalk.com/autenticacao/login/ALUNO",
            method: "GET",
            body: JSON.stringify({
                "identificador": "julinhateste@gmail.com",
                "senha": "testando"
            }),
            dataType: "jsonp",
            crossDomain: true,
            timeout: 0,
            headers: {
                'Access-Control-Allow-Origin': '*',
                //   Accept: "application/json",
                "Content-Type": "application/json",
            },
            success: function (result) {
                console.log(result);
                //   if (result != "Error") {
                //     //console.log('Authenticated');
                //     sessionStorage.setItem("token", result.data.accessToken);
                //     //Armazenando as permissoes do usuario
                //     let retorno = result.data.userToken.claims;
                //     var arr = retorno.map(function (obj) {
                //       return Object.keys(obj).map(function (key) {
                //         return obj[key];
                //       });
                //     });
                //     //console.log(arr);
                //     sessionStorage.setItem("user-profile", arr);
                //     var profile = sessionStorage.getItem("user-profile");
                //     if (
                //       profile.includes("Administrador") != true &&
                //       profile.includes("Concierge") != true &&
                //       profile.includes("Spa") != true &&
                //       profile.includes("Restaurante") != true &&
                //       profile.includes("Governanca") != true
                //     ) {
                //       window.location.href = "index.html";
                //     } else {
                //       window.location.href = "home.html";
                //     }
                //   } else {
                //     alert("E-mail ou senha inválida");
                //   }
            },
            error: function (result) {
                console.log(result);
                //   let msg = result.responseText
                //     .replace('{"errors":["', "")
                //     .replace('"],"success":false,"data":null}', "");
                //   if (msg.length > 0) {
                //     alert(msg);
                //   }
            },
        });
    });
});

// "method": "GET",
// "timeout": 0,
// "headers": {
//     "Content-Type": "application/json"
// },
// "data": JSON.stringify({
//     "identificador": "julinhateste@gmail.com",
//     "senha": "testando"
// }),