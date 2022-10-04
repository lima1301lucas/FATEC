import java.util.Scanner;

class ElementoArray{
    public static void main (String args[]){

        Scanner inp = new Scanner(System.in);
        int vetNum[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        System.out.println("Digite um valor para procurar no vetor");
        int num = inp.nextInt();
        inp.close();

        for(int i = 0; i < vetNum.length; i++){
            if(vetNum[i] == num){
                System.out.println("O índice do número digitado é " + i);
            } else if(i == vetNum.length - 1){
                System.out.println("Número não encontrado no vetor");
            }
        }
    }
}