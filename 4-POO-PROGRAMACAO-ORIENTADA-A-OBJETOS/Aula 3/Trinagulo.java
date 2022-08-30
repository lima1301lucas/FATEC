import.java.util.Scanner

public class Triangulo{
   public static void main (String args[]){
   
      int lado1, lado2, lado3;
      
      Scanner inp1 = new Scanner (System.in);
      System.out.print("Digite o valor do lado 1");
      lado1 = inp1.nextInt();
      
      Scanner inp2 = new Scanner (System.in);
      System.out.print("Digite o valor do lado 2");
      lado2 = inp2.nextInt();  
      
      Scanner inp3 = new Scanner (System.in);
      System.out.print("Digite o valor do lado 3");
      lado3 = inp3.nextInt();
      
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

