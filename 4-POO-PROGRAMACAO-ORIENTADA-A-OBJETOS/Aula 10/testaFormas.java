public class testaFormas {
    public static void main(String args[]){
        
        circulo c = new circulo(5);
        c.imprime();
        System.out.println();

        retangulo r = new retangulo(3, 4);
        r.imprime();
        System.out.println();
        
        triangulo t = new triangulo(6, 8);
        t.imprime();
        System.out.println();
    }
}
