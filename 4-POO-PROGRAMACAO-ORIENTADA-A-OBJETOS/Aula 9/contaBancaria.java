public class contaBancaria{
    private String titular;
    private int numConta;
    private double saldo;

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar( double valor){
        saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void Imprime(){
        System.out.print("\nTitular: " + this.titular);
        System.out.print("\nConta: " + this.numConta);
        System.out.print("\nSaldo: " + this.saldo);
    }
}