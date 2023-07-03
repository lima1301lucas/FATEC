function redefineSenha() {
    var email = document.getElementById("inp-email");
    var pwd = document.getElementById("inp-pswd");
    var confirmaPwd = document.getElementById("inp-confirma-pswd");

    var emailUser = email.value;
    var pwdDigitada = pwd.value;
    var confirmaPwdDigitada = confirmaPwd.value;

    if (emailUser != "" && pwdDigitada != "" && confirmaPwdDigitada != "") {
        if (pwdDigitada === confirmaPwdDigitada) {

            var dados = {
                identificador: emailUser,
                senha: confirmaPwdDigitada
            };

            fetch("URL_DA_API/login", {

                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(dados)
                })

                .then(response => {
                    if (response.status === 200) {
                        window.location.href = "login.html";
                    } else if (response.status === 400) {
                        alert("Usuário não encontrado!");
                    }
                })

                .catch(error => {
                    console.error("Erro na requisição:", error);
                });

        } else {
            alert("Senhas diferem!");
        }
    } else {
        alert("Digite o e-mail, a senha e confirme novamente para redefinir a senha!");
    }
}