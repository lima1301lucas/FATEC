public class testaConta {
    public static void main(String[] args){

        System.out.print("----------Conta Corrente----------");
        contaBancaria cSimples = new contaBancaria();
        cSimples.setTitular("Lucas");
        cSimples.setNumConta(123);
        cSimples.setSaldo(100);
        cSimples.Imprime();

        System.out.print("\n----------Conta Poupança----------");
        contaPoupanca cPoupanca = new contaPoupanca();
        cPoupanca.setTaxaJuros(0.1365);
        cPoupanca.Imprime();

        System.out.print("\n----------Conta Empresarial----------");
        contaEmpresarial cEmpresarial = new contaEmpresarial();
        cEmpresarial.setLimite(100);
        cEmpresarial.Imprime();
    } 
}
