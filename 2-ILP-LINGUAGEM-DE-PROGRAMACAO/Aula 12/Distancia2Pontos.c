#include <locale.h>
#include <windows.h>
#include <stdio.h>
#include <math.h>

typedef struct{
    float x;
    float y;
}
PONTO;

float distancia(PONTO a, PONTO b){
    return (sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2)));
}

int main(){
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    PONTO p1, p2;
    float dist;

    printf("Introduz as coordenadas x e y do ponto p1: ");
    scanf("%f %f", & p1.x, & p1.y);
    printf("Introduz as coordenadas x e y do ponto p2: ");
    scanf("%f %f", & p2.x, & p2.y);
    dist = distancia(p1, p2);
    printf("A distância entre os pontos é %.2f\n", dist);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}