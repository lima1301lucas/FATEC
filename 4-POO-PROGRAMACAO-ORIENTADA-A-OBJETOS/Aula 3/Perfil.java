import.java.util.Scanner

public class Perfil(){
   public static void main(String[] args) {
      String data;
      
      Scanner input = new Scanner (System.in);
      System.out.print("Digite a data no formao DD/MM/YYYY");      
      data = input.next();
      
      int soma1 = Integer.parseInt(data.substring(0,4)) + Integer.parseInt(data.substring(4,8));
      int soma2 = Integer.parseInt(Integer(soma).toString().substring(0,2)) + Integer.parseInt(Integer(soma).toString().substring(2,4));
    
      System.out.print("Dia/Mês" + soma2);
      //System.out.print("Ano" + ano);    
      
   }
}