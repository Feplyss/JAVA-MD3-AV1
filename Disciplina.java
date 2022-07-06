package Avaliacao1;

public class Disciplina {

	private String idDisciplina;
	private String nome;
	private Double mensalidade;
	private String idProfessor;
	private String nomeProfessor;
	private RegistroDisciplina alunosMatriculados[] = new RegistroDisciplina[50];
	
	//--Construtor--
	
	public Disciplina(String idDisciplina, String nome, Double mensalidade, Professor professor) {
		setIdDisciplina(idDisciplina);
		setNome(nome);
		setMensalidade(mensalidade);
		setIdProfessor(professor.getMatricula());
		setNomeProfessor(professor.getNome());
		professor.setDisciplinasLecionadas(this.nome);
	}
	
	//--Gets e Sets--
	
	public String getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(String idDisciplina) {
		checarIdDisciplina(idDisciplina);
		this.idDisciplina = idDisciplina;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getIdProfessor() {
		return idProfessor;
	}
	
	public void setIdProfessor(String idProfessor) {
		this.idProfessor = idProfessor;
	}
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	
	private void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	
	public Double getMensalidade() {
		return mensalidade;
	}
	
	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	public RegistroDisciplina getAlunosMatriculados(int pos) {
		return alunosMatriculados[pos];
	}
	
	public int getAlunosMatriculadosLength() {
		return alunosMatriculados.length;
	}
	
	//--Metodos--
	
	public void checarIdDisciplina(String idDisciplina) {
		try {
			Long.parseLong(idDisciplina);
		}catch(Exception e) {
			throw new NumberFormatException("O ID da disciplina conter 2 digitos numericos.");
		}
		if(idDisciplina.length() != 2) {
			throw new IndexOutOfBoundsException("O ID da disciplina deve conter 2 digitos numericos.");
		}
	}
	
	public int checarAluno(AlunoGrad a) {
		int verifica = -1;
		for(int i = 0; i < this.alunosMatriculados.length; i++) {
			if(this.alunosMatriculados[i] != null) {
				if(a.getMatricula() == this.alunosMatriculados[i].getMatricula()) {
					verifica = i;
				}
			}
		}
		return verifica;
	}
	
	public int checarAluno(AlunoPos a) {
		int verifica = -1;
		for(int i = 0; i < this.alunosMatriculados.length; i++) {
			if(this.alunosMatriculados[i] != null) {
				if(a.getMatricula() == this.alunosMatriculados[i].getMatricula()) {
					verifica = i;
				}
			}
		}
		return verifica;
	}
	
	public void matricular(AlunoGrad a) {
		if(checarAluno(a) >= 0) {
			throw new IllegalArgumentException("O aluno(a) " + a.getNome() + " ja esta matriculado(a) na disciplina " + this.nome + ".");
		}else {
			for(int i = 0; i < this.alunosMatriculados.length; i++) {
				if(this.alunosMatriculados[i] == null) {
					a.setDisciplinasMatriculadas(this.nome);
					this.alunosMatriculados[i] = new RegistroDisciplina(a.getMatricula(), a.getNome()) ;
					System.out.println("Aluno(a) " + a.getNome() + " matriculado(a) na disciplina " + this.nome + ".");
					break;
				}else if(i == this.alunosMatriculados.length - 1) {
					System.out.println("Total de matriculas da disciplina " + this.nome + " alcancado.");
				}
			}
		}
	}
	
	public void matricular(AlunoPos a) {
		if(checarAluno(a) >= 0) {
			throw new IllegalArgumentException("O aluno(a) " + a.getNome() + " ja esta matriculado(a) na disciplina " + this.nome + ".");
		}else {
			for(int i = 0; i < this.alunosMatriculados.length; i++) {
				if(this.alunosMatriculados[i] == null) {
					a.setDisciplinasMatriculadas(this.nome);
					this.alunosMatriculados[i] = new RegistroDisciplina(a.getMatricula(), a.getNome()) ;
					System.out.println("Aluno(a) " + a.getNome() + " matriculado(a) na disciplina " + this.nome + ".");
					break;
				}else if(i == this.alunosMatriculados.length - 1) {
					System.out.println("Total de matriculas da disciplina " + this.nome + " alcancado.");
				}
			}
		}
	}
	
	public void visualizarMatricula(AlunoGrad a) {
		if(checarAluno(a) >= 0) {
			System.out.println("Aluno(a) " + a.getNome() + " esta matriculado(a) na disciplina " + this.nome + ".");
		}else {
			System.out.println("Aluno(a) " + a.getNome() + " nao esta matriculado(a) na disciplina " + this.nome + ".");
		}
	}
	
	public void visualizarMatricula(AlunoPos a) {
		if(checarAluno(a) >= 0) {
			System.out.println("Aluno(a) " + a.getNome() + " esta matriculado(a) na disciplina " + this.nome + ".");
		}else {
			System.out.println("Aluno(a) " + a.getNome() + " nao esta matriculado(a) na disciplina " + this.nome + ".");
		}
	}
}
