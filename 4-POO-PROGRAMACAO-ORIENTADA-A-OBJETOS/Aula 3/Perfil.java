import java.util.Scanner;

public class Perfil {
    public static void main(String[] args) {
        String data;
        
        Scanner input = new Scanner (System.in);
        System.out.print("Digite a data no formato DD/MM/YYYY: ");      
        data = input.next();
        input.close();
        
        int soma1 = Integer.parseInt(data.substring(0,4)) + Integer.parseInt(data.substring(4,8));
        int soma2 = Integer.parseInt(Integer.toString(soma1).substring(0,2)) + Integer.parseInt(Integer.toString(soma1).substring(2,4));
        int res = soma2 % 5;

        switch(res){
            case 0:
            System.out.println("Seu perfil é tímido");
            break;
            case 1:
            System.out.println("Seu perfil é sonhador");
            break;
            case 2:
            System.out.println("Seu perfil é paquerador");
            break;
            case 3:
            System.out.println("Seu perfil é atraente");
            break;
            case 4:
            System.out.println("Seu perfil é irresistível");
            break;
        } 
    }    
}
