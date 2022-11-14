import java.lang.Math;

public class circulo extends formaGeometrica{

    public double raio;

    public void setRaio(double raio){
        if (raio < 0) this.raio = 0;
        else this.raio = raio;
    }

    public circulo (double raio){
        setRaio(raio);
    }

    public double area(){
        return (Math.PI * Math.pow(raio, 2));
    }

    public void imprime(){
        System.out.println("Dados do Circulo");
        super.imprime();
        System.out.println("Raio: " + raio);
    }
}
