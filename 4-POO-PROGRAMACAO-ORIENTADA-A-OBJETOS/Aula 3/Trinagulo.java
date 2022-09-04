import java.util.Scanner;

public class Triangulo{
   public static void main (String args[]){
   
      int lado1, lado2, lado3;
      
      Scanner input = new Scanner (System.in);
      
      System.out.print("Digite o valor do lado 1");
      lado1 = input.nextInt();
      
      System.out.print("Digite o valor do lado 2");
      lado2 = input.nextInt();  
      
      System.out.print("Digite o valor do lado 3");
      lado3 = input.nextInt();
      input.close();
      
      if (lado1 < lado2 + lado3 && lado2 < lado1 + lado3 && lado3 < lado1 + lado2){
         if (lado1 == lado2 && lado1 == lado3){
            System.out.print("Equilátero");
         }

        else if ((lado1 == lado2) || (lado2 == lado3) || (lado3 == lado1)){
            System.out.print("Isóceles");
        }
        else{
            System.out.print("Escaleno");
        }
      }
      else{
         System.out.print("As medidas não formam um triângulo");
      }      
   }
}
