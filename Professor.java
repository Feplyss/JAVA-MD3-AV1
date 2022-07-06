package Avaliacao1;

public class Professor extends Usuario {

	String disciplinasLecionadas[] = new String[5];
	
	//--Construtor--
	
	public Professor(String nome, String cpf, String matricula, String telefone, String email, String endereco) {
		super(nome, cpf, matricula, telefone, email, endereco);
	}
	
	//--Gets e Sets--
	
	public String getDisciplinasLecionadas(int pos) {
		return disciplinasLecionadas[pos];
	}
	
	public void listarDisciplinasLecionadas() {
		for(int i = 0; i < this.disciplinasLecionadas.length; i++) {
			if(this.disciplinasLecionadas[i] == null) {
				break;
			}
			System.out.print(this.disciplinasLecionadas[i] + " ");
			
		}
		System.out.print("\n");
	}
	
	public void setDisciplinasLecionadas(String disciplinasMatriculadas) {
		for(int i = 0; i < this.disciplinasLecionadas.length; i++) {
			if(this.disciplinasLecionadas[i] == null) {
				this.disciplinasLecionadas[i] = disciplinasMatriculadas;
				break;
			}else if(i == this.disciplinasLecionadas.length - 1) {
				throw new IndexOutOfBoundsException("Total de disciplinas lecionadas do(a) professor(a) " + this.getNome() + " alcançado.");
			}
		}
	}
}
