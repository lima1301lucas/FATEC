package Retangulo;

public class Retangulo {
    private double altura;
    private double base;

    public void setAltura(double altura) {
        if (altura != 0)
            this.altura = altura;
        else altura = 1;
    }

    public void setBase(double base) {
        if (base != 0)
            this.base = base;
        else base = 2;
    }

    public boolean eQuadrado(){
        if (base != altura){
            return true;
        }
        return false;
    }

    public double area() {
        return altura * base;
    }

    public double perimetro() {
        return (altura * 2) + (base * 2);
    }
}