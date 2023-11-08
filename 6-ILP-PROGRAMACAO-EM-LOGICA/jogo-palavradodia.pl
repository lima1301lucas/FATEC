:- dynamic word_of_the_day/2.

% Palavras poss�veis para adivinhar.
palavras_possiveis(["le�o", "tigre", "urso", "zebra", "girafa", "hipop�tamo", "rinoceronte", "crocodilo", "jacar�", "lobo", "raposa", "coiote", "leopardo", "pantera", "puma", "on�a", "lince", "guepardo", "hiena", "elefante", "orangotango", "gib�o", "chimpanz�", "gorila", "macaco-aranha", "tucano", "pardal", "coruja", "�guia", "falc�o", "gavi�o", "gaivota", "albatroz", "pelicano", "flamingo", "cisne", "pinguim", "polvo", "lula", "baleia", "golfinho", "tubar�o", "arraia", "tartaruga", "caranguejo", "camar�o"]).

% Inicializa o jogo com a palavra do dia.
start_game :-
    palavras_possiveis(Palavras),
    random_member(PalavraDoDia, Palavras),
    random_word_hint(PalavraDoDia, Dica),
    asserta(word_of_the_day(PalavraDoDia, Dica)),
    writeln("Bem-vindo ao Adivinhe a Palavra do Dia!"),
    format("Dica: ~w~n", [Dica]),
    writeln("Uma palavra foi escolhida. Tente adivinh�-la."),
    play_game.

% Gera uma dica aleat�ria para a palavra do dia.
random_word_hint(Palavra, Dica) :-
    % L�gica para gerar dicas aleat�rias (substitua por sua pr�pria l�gica).
    atom_chars(Palavra, Chars),
    random_permutation(Chars, ShuffledChars),
    atom_chars(Dica, ShuffledChars).

% Inicia o jogo.
play_game :-
    write("Digite sua suposi��o (ou 0 para desistir): "),
    read_line_to_string(user_input, Suposicao),
    (Suposicao = "0" ->
        show_answer_and_end
    ;
        string_lower(Suposicao, SuposicaoLowerCase), % Transforma a suposi��o em min�sculas para compara��o.
        validar_suposicao(SuposicaoLowerCase)
    ).

% Fun��o para mostrar a resposta e encerrar o jogo.
show_answer_and_end :-
    word_of_the_day(PalavraDoDia, _),
    format("Voc� desistiu. A resposta era ~w. O jogo terminou. Obrigado por jogar!~n", [PalavraDoDia]),
    retract(word_of_the_day(_, _)).

% Valida a suposi��o do jogador.
validar_suposicao("0") :-
    show_answer_and_end.

validar_suposicao(Suposicao) :-
    word_of_the_day(PalavraDoDia, _),
    Suposicao = PalavraDoDia,
    format("Parab�ns! A palavra do dia � ~w. Voc� acertou.~n", [PalavraDoDia]),
    retract(word_of_the_day(_, _)),
    writeln("O jogo terminou. Obrigado por jogar!").

validar_suposicao(Suposicao) :-
    writeln("Tente novamente. Sua suposi��o est� incorreta."),
    play_game.
