// Prova feita por Bianca Goiano e Lucas Lima
#include <stdio.h>
#include <locale.h>
#include <windows.h>

void quadrante(float x, float y){
    if (x == 0.0 && y == 0.0){
        printf("Origem\n");
    }
    else if (x == 0.0 && y != 0.0){
        printf("Eixo Y\n");
    }
    else if (y == 0.0 && x != 0.0){
        printf("Eixo X\n");
    }
    else if (x > 0.0){
        if (y > 0.0){
            printf("\nO Ponto ( %.2f, %.2f ) pertence ao Q1\n",x,y);
        } 
        else printf("\nO Ponto ( %.2f,%.2f ) pertence ao Q4\n",x,y);
    }
    else if (y > 0.0){
        printf("\nO Ponto ( %.2f,%.2f ) pertence ao Q2\n",x,y);
    } 
    else printf("\nO Ponto ( %.2f,%.2f ) pertence ao Q3\n",x,y);
}

int main() {
    UINT CPAGE_UTF8 = 65001;
    UINT CPAGE_DEFAULT = GetConsoleOutputCP();
    SetConsoleOutputCP(CPAGE_UTF8);

    float x, y;
    printf("\nDigite o ponto X: ");
    scanf("%f", & x);
    printf("Digite o ponto Y: ");
    scanf("%f", & y);
    quadrante(x, y);

    SetConsoleOutputCP(CPAGE_DEFAULT);
    system("pause");
    return 0;
}