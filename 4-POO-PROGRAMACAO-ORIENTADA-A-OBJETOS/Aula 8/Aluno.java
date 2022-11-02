public class Aluno extends Pessoa{
    private int ra;
    private String curso;

    public Aluno(String nome, String cpf, int ra, String curso){
        super(nome, cpf);
        this.ra = ra;
        this.curso = curso;
    }

    @Override
    public void Imprime(){
        super.Imprime();
        System.out.print("\nRA: " + this.ra);
        System.out.print("\nCurso: " + this.curso);
    }
}
