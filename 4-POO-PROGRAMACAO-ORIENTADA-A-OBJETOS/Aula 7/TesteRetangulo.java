package Retangulo;
import java.util.Scanner;

public class TesteRetangulo{
    public static void main(String[] args){
        Retangulo ret = new Retangulo();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor da altura do retangulo: ");
        double altura = teclado.nextDouble();
        System.out.println("Digite o valor da base do retangulo: ");
        double base = teclado.nextDouble();


        ret.setAltura(altura);
        ret.setBase(base);

        System.out.println("Altura do retângulo = " + altura);
        System.out.println("Base do retângulo = " + base);
        System.out.println("Área do retângulo = " + ret.area());
        System.out.println("Perímetro do retângulo = " + ret.perimetro());
        System.out.println("É retângulo = " + ret.eQuadrado());
    }
}