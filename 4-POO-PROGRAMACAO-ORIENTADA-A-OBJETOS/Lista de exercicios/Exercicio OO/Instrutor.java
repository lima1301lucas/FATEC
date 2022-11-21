public class Instrutor extends Funcionario{

    private String disciplina;

    public Instrutor(String nome, String email, String disciplina) {
        super(nome, email);
        this.disciplina = disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public void exibeDados(){
        System.out.print("\nDisciplina: " + this.disciplina);
    }   
}
