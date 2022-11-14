public abstract class formaGeometrica{
    protected int lados;

    public void setLados(int lados){
        if (lados < 0) this.lados = 0;
        else this.lados = lados;
    }

    public abstract double area();

    public void imprime(){
        System.out.println("Número de lados: " + lados);
        System.out.printf("Área: %.2f\n " + lados, area());
        System.out.println();
    }
}