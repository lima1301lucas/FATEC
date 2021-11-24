//Feito por Bianca Goiano e Lucas Lima

typedef struct {
    int dia;
    int mes;
    int ano;
}
DATA;

typedef struct {
    int hora;
    int minutos;
}
HORA;

typedef struct {
    char esp_med[40];
    char nome[40];
    char convenio[40];
    DATA consulta;
    HORA inicio;
}
CONSULTA;