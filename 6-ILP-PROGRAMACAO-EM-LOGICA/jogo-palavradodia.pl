:- dynamic word_of_the_day/2.

% Palavras possíveis para adivinhar.
palavras_possiveis(["leão", "tigre", "urso", "zebra", "girafa", "hipopótamo", "rinoceronte", "crocodilo", "jacaré", "lobo", "raposa", "coiote", "leopardo", "pantera", "puma", "onça", "lince", "guepardo", "hiena", "elefante", "orangotango", "gibão", "chimpanzé", "gorila", "macaco-aranha", "tucano", "pardal", "coruja", "águia", "falcão", "gavião", "gaivota", "albatroz", "pelicano", "flamingo", "cisne", "pinguim", "polvo", "lula", "baleia", "golfinho", "tubarão", "arraia", "tartaruga", "caranguejo", "camarão"]).

% Inicializa o jogo com a palavra do dia.
start_game :-
    palavras_possiveis(Palavras),
    random_member(PalavraDoDia, Palavras),
    random_word_hint(PalavraDoDia, Dica),
    asserta(word_of_the_day(PalavraDoDia, Dica)),
    writeln("Bem-vindo ao Adivinhe a Palavra do Dia!"),
    format("Dica: ~w~n", [Dica]),
    writeln("Uma palavra foi escolhida. Tente adivinhá-la."),
    play_game.

% Gera uma dica aleatória para a palavra do dia.
random_word_hint(Palavra, Dica) :-
    % Lógica para gerar dicas aleatórias (substitua por sua própria lógica).
    atom_chars(Palavra, Chars),
    random_permutation(Chars, ShuffledChars),
    atom_chars(Dica, ShuffledChars).

% Inicia o jogo.
play_game :-
    write("Digite sua suposição (ou 0 para desistir): "),
    read_line_to_string(user_input, Suposicao),
    (Suposicao = "0" ->
        show_answer_and_end
    ;
        string_lower(Suposicao, SuposicaoLowerCase), % Transforma a suposição em minúsculas para comparação.
        validar_suposicao(SuposicaoLowerCase)
    ).

% Função para mostrar a resposta e encerrar o jogo.
show_answer_and_end :-
    word_of_the_day(PalavraDoDia, _),
    format("Você desistiu. A resposta era ~w. O jogo terminou. Obrigado por jogar!~n", [PalavraDoDia]),
    retract(word_of_the_day(_, _)).

% Valida a suposição do jogador.
validar_suposicao("0") :-
    show_answer_and_end.

validar_suposicao(Suposicao) :-
    word_of_the_day(PalavraDoDia, _),
    Suposicao = PalavraDoDia,
    format("Parabéns! A palavra do dia é ~w. Você acertou.~n", [PalavraDoDia]),
    retract(word_of_the_day(_, _)),
    writeln("O jogo terminou. Obrigado por jogar!").

validar_suposicao(Suposicao) :-
    writeln("Tente novamente. Sua suposição está incorreta."),
    play_game.
