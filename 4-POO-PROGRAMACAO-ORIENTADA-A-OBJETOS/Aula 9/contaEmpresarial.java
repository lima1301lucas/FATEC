public class contaEmpresarial extends contaBancaria{
    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void Imprime(){
        System.out.print("\nLimite: " + this.limite);
        System.out.print("\nEmpréstimo: " + getSaldo() + this.limite);
    }
}
