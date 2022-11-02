public class contaPoupanca extends contaBancaria{
    private double taxaJuros;
    double saldoAtualizado;

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void atualizaSaldo() {
        saldoAtualizado = super.getSaldo() + (super.getSaldo() * taxaJuros);
    }

    @Override
    public void Imprime(){
        System.out.print("\nTaxa juros: " + this.taxaJuros);
        System.out.print("\nSaldo atualizado: " + saldoAtualizado);
    }
}
