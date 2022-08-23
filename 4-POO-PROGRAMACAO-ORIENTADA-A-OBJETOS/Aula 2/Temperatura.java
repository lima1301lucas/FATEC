import java.util.Scanner;

public class Temperatura{

   public static void main(String args [])
   {
      Scanner input = new Scanner (System.in);
      float tempCelc, tempFare;
      
      System.out.print("Digite a temperatura em Celsius: ");
      tempCelc= input.nextFloat();
      
      tempFare = ((tempCelc * 9/5) + 32);
      System.out.printf("A temperatura convertida em Farenheit é: %5.2f", tempFare);  
   }
}