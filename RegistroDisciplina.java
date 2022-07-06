package Avaliacao1;

public class RegistroDisciplina {
	
	private String matricula;
	private String nome;
	private double nota;
	private int faltas;
	
	//--Construtor--
	
	public RegistroDisciplina(String matricula, String nome) {
		setMatricula(matricula);
		setNome(nome);
	}
	
	//--Gets e Sets--
	
	public String getMatricula() {
		return matricula;
	}
	
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public static Double getNota(Disciplina d, AlunoGrad a) {
		return d.getAlunosMatriculados(indexAluno(a, d)).nota;
	}
	
	public static Double getNota(Disciplina d, AlunoPos a) {
		return d.getAlunosMatriculados(indexAluno(a, d)).nota;
	}
	
	private void setNota(Double nota) {
		this.nota = nota;
	}
	
	public int getFaltas() {
		return faltas;
	}
	
	private void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	
	//--Metodos--
		
	private static void checarProfessor(Professor p, Disciplina d) {
		if(d.getIdProfessor() != p.getMatricula()) {
			throw new IllegalArgumentException("O(A) professor(a) " + p.getNome() + " nao leciona a disciplina " + d.getNome() + ".");
		}
	}
	
	private static void checarDisciplina(Disciplina d, AlunoGrad a) {
		for(int i = 0; i < d.getAlunosMatriculadosLength(); i++) {
			if(d.getAlunosMatriculados(i).matricula == a.getMatricula()) {
				break;
			}else if(d.getAlunosMatriculados(i) == null || i == d.getAlunosMatriculadosLength() - 1) {
				throw new IllegalArgumentException("O(A) aluno(a) " + a.getNome() + " nao esta matriculado(a) na disciplina " + d.getNome() + ".");
			}
		}
	}
	
	private static void checarDisciplina(Disciplina d, AlunoPos a) {
		int verifica = -1;
		for(int i = 0; i < d.getAlunosMatriculadosLength(); i++) {
			if(d.getAlunosMatriculados(i) != null) {
				if(a.getMatricula() == d.getAlunosMatriculados(i).getMatricula()) {
					verifica = i;
					break;
				}
			}
		}
		if(verifica == -1) {
			throw new IllegalArgumentException("O(A) aluno(a) " + a.getNome() + " nao esta matriculado(a) na disciplina " + d.getNome() + ".");
		}
	}
	
	private static void checarNota(Double nota) {
		if(nota > 10 || nota < 0) {
			throw new IndexOutOfBoundsException("A nota deve ter um valor entre 0 e 10.");
		}
	}
	
	private static int indexAluno(AlunoGrad a, Disciplina d) {
		for(int i = 0; i < d.getAlunosMatriculadosLength(); i++) {
			if(a.getMatricula() == d.getAlunosMatriculados(i).matricula) {
				return i;
			}else if(d.getAlunosMatriculados(i) == null || i == d.getAlunosMatriculadosLength() - 1) {
				break;
			}
		}
		return -1;
	}
	
	private static int indexAluno(AlunoPos a, Disciplina d) {
		for(int i = 0; i < d.getAlunosMatriculadosLength(); i++) {
			if(a.getMatricula() == d.getAlunosMatriculados(i).getMatricula()) {
				return i;
			}else if(d.getAlunosMatriculados(i) == null || i == d.getAlunosMatriculadosLength() - 1) {
				break;
			}
		}
		return -1;
	}
	
	public static void lancaNota(Professor p, Disciplina d, AlunoGrad a, Double nota) {
		checarProfessor(p, d);
		checarDisciplina(d, a);
		checarNota(nota);
		
		d.getAlunosMatriculados(indexAluno(a, d)).setNota(nota);
	}
	
	public static void lancaNota(Professor p, Disciplina d, AlunoPos a, Double nota) {
		checarProfessor(p, d);
		checarDisciplina(d, a);
		checarNota(nota);
		
		d.getAlunosMatriculados(indexAluno(a, d)).setNota(nota);
	}
	
	public static void lancaFalta(Professor p, Disciplina d, AlunoGrad a) {
		checarProfessor(p, d);
		checarDisciplina(d, a);
		
		d.getAlunosMatriculados(indexAluno(a, d)).setFaltas(d.getAlunosMatriculados(indexAluno(a, d)).getFaltas() + 1);
	}
	
	public static void lancaFalta(Professor p, Disciplina d, AlunoPos a) {
		checarProfessor(p, d);
		checarDisciplina(d, a);
		
		d.getAlunosMatriculados(indexAluno(a, d)).setFaltas(d.getAlunosMatriculados(indexAluno(a, d)).getFaltas() + 1);
	}
	
	public static Double listarNotas(Disciplina d, AlunoGrad a) {
		checarDisciplina(d, a);
		return d.getAlunosMatriculados(indexAluno(a, d)).nota;
	}
	
	public static Double listarNotas(Disciplina d, AlunoPos a) {
		checarDisciplina(d, a);
		return d.getAlunosMatriculados(indexAluno(a, d)).nota;
	}
	
	public static int listarFaltas(Disciplina d, AlunoGrad a) {
		checarDisciplina(d, a);
		return d.getAlunosMatriculados(indexAluno(a, d)).faltas;
	}
	
	public static int listarFaltas(Disciplina d, AlunoPos a) {
		checarDisciplina(d, a);
		return d.getAlunosMatriculados(indexAluno(a, d)).faltas;
	}
}
