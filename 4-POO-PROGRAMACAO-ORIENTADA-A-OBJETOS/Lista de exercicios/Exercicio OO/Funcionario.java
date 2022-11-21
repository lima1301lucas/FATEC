public class Funcionario{

    protected String nome;
    protected String email;
    protected int idade;

    public Funcionario(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public Funcionario(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void exibeDados(){
        System.out.print("\nNome: " + this.nome);
        System.out.print("\nEmail: " + this.email);
        System.out.print("\nIdade: " + this.idade);
    }
}