package Circulo;
class Circunferencia
{
    private double raio;
    final double PI = 3.1416;

    public Circunferencia(){
    }

    public Circunferencia( double r){
        setRaio(r);
    }

    public void setRaio(double r) {
        raio = r;
    }

    public double getRaio(){
        return raio;
    }

    public double getArea(){
        return PI * Math.pow(raio, 2);
    }

    public double getPerimetro(){
        return 2 * PI * raio;
    }

    public double getDiametro(){
        return 2 * raio;
    }  
}