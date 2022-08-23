import java.util.Scanner;

public class Dolar{

   public static void main(String args [])
   {
      Scanner input = new Scanner (System.in);
      double num1, res;
      
      System.out.print("Digite o valores em reais ");
      num1= input.nextDouble();
      
      res = num1 * 5.16;
      System.out.printf("O valor convertido é: %5.2f dólares", res);  
   }
}