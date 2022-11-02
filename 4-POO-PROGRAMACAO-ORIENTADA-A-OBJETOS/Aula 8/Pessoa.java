public class Pessoa{
    private String nome;
    private String cpf;

    public Pessoa (String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void Imprime(){
        System.out.print("\nNome: " + this.nome);
        System.out.print("\nCPF: " + this.cpf);
    }
}