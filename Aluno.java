package Avaliacao1;

public abstract class Aluno extends Usuario{

	private String disciplinasMatriculadas[] = new String[10];
	private static int modulos;
	private static int mesesModulo;
	private static String tipoAvaliacao;
	
	//--Construtor--
	
	public Aluno(String nome, String cpf, String matricula, String telefone, String email, String endereco) {
		super(nome, cpf, matricula, telefone, email, endereco);
	}
	
	//--Gets e Sets--
	
	public String getDisciplinasMatriculadas(int pos) {
		return disciplinasMatriculadas[pos];
	}
	
	public void setDisciplinasMatriculadas(String disciplinasMatriculadas) {
		for(int i = 0; i < this.disciplinasMatriculadas.length; i++) {
			if(this.disciplinasMatriculadas[i] == null) {
				this.disciplinasMatriculadas[i] = disciplinasMatriculadas;
				break;
			}else if(i == this.disciplinasMatriculadas.length - 1) {
				throw new IndexOutOfBoundsException("Total de matriculas em disciplinas do aluno(a) " + this.getNome() + " alcançado.");
			}
		}
	}
	
	public int getModulos() {
		return modulos;
	}
	
	protected static void setModulos(int modulos) {
		Aluno.modulos = modulos;
	}
	
	public static int getMesesModulo() {
		return mesesModulo;
	}
	
	protected static void setMesesModulo(int mesesModulos) {
		Aluno.mesesModulo = mesesModulos;
	}
	
	public static String getTipoAvaliacao() {
		return tipoAvaliacao;
	}
	
	protected static void setTipoAvaliacao(String tipoAvaliacao) {
		Aluno.tipoAvaliacao = tipoAvaliacao;
	}
	
	//--Metodos--
	
	public void listarDisciplinasMatriculadas() {
		for(int i = 0; i < this.disciplinasMatriculadas.length; i++) {
			if(this.disciplinasMatriculadas[i] == null) {
				break;
			}
			System.out.print(this.disciplinasMatriculadas[i] + " ");
			
		}
		System.out.print("\n");
	}
}
