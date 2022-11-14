public class triangulo extends formaGeometrica{
    
    private double base, altura;

    public triangulo(double base, double altura){
        super.setLados(3);
        setBase(base);
        setAltura(altura);
    }

    public void setBase(double base){
        if(base < 0) this.base = 0;
        else this.base = base;
    }

    public void setAltura(double altura){
        if(altura < 0) this.altura = 0;
        else this.altura = altura;
    }

    public double area(){
        return ((base * altura)/2);
    }

    public void imprime(){
        System.out.println("\nDados do triângulo");
        super.imprime();
        System.out.println("Base: " + base);
        System.out.println("Altura: " + altura);
    }
}
