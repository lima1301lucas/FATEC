public class Programador extends Funcionario{

    private String linguagem;
    private String sistOper;
    
    public Programador(String nome, String email, String linguagem) {
        super(nome, email);
        this.linguagem = linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public void setSistOper(String sistOper) {
        this.sistOper = sistOper;
    }
    
    @Override
    public void exibeDados(){
        System.out.print("\nLinguagem de programação: " + this.linguagem);
        System.out.print("\nSistema Operacional: " + sistOper);
    }
}