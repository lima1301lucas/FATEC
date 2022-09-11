package Circulo;
import java.util.Scanner;

public class Circulo {
    public static void main (String args[]){

        Circunferencia circulo = new Circunferencia();

        Scanner dado = new Scanner(System.in);
        double raio;

        System.out.print("Digite o raio: ");
        raio = dado.nextDouble();
        dado.close();

        circulo.setRaio(raio);

        System.out.printf("\nA área da circunferência é: %.2f", circulo.getArea());
        System.out.printf("\nO perímetro da circunferência é: %.2f", circulo.getPerimetro());
        System.out.printf("\nO diâmetro da circunferência é: %.2f", circulo.getDiametro());
    }
}
