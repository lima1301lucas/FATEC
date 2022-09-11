package Conta;

class Conta{

    private double saldo;

    public Conta(){
    }

    public Conta(double saldoConta){
        setSaldo(saldo);
    }

    public void setSaldo(double saldoConta) {
        saldo = saldoConta;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaque(double valor) {
        saldo = saldo - valor;
    }

    public double getSaque(){
        return saldo;
    }

    public void setDeposito(double valor) {
        saldo = saldo + valor;
    }

    public double getDeposito(){
        return saldo;
    }
}