package Avaliacao1;

public class Main {

	public static void main(String[] args) {
		
		Professor alberto = new Professor("Alberto", "78945612310", "101", "974185293", "alberto@gmail.com", "Rua W");
		Disciplina programacao = new Disciplina("00", "Programacao", 500.00, alberto);
		Disciplina bancoDeDados = new Disciplina("01", "Banco de dados", 500.00, alberto);
		AlunoGrad jose = new AlunoGrad("Jose", "12345678910", "001", "912345678", "jose@gmail.com", "Rua X");
		AlunoPos larissa = new AlunoPos("Larissa", "23456789101", "002", "998765432", "larissa@gmail.com", "Rua Y");
		AlunoGrad kleber = new AlunoGrad("Kleber", "23456789101", "003", "987654321", "larissa@gmail.com", "Rua Y");
		
		programacao.visualizarMatricula(jose);
		programacao.visualizarMatricula(kleber);
		bancoDeDados.visualizarMatricula(larissa);
		
		System.out.println();
		
		programacao.matricular(jose);
		programacao.matricular(kleber);
		bancoDeDados.matricular(larissa);
		
		System.out.println();
		
		programacao.visualizarMatricula(jose);
		programacao.visualizarMatricula(kleber);
		bancoDeDados.visualizarMatricula(larissa);
		
		System.out.println();
		
		
		System.out.println(programacao.getIdProfessor());
		System.out.println(RegistroDisciplina.getNota(programacao, jose));
		RegistroDisciplina.lancaNota(alberto, programacao, jose, 8.0);
		System.out.println(RegistroDisciplina.getNota(programacao, jose));
		System.out.println(RegistroDisciplina.listarNotas(programacao, jose));
		RegistroDisciplina.lancaNota(alberto, bancoDeDados, larissa, 9.0);
		System.out.println(RegistroDisciplina.listarNotas(bancoDeDados, larissa));
		System.out.println(RegistroDisciplina.listarNotas(bancoDeDados, larissa));
		RegistroDisciplina.lancaFalta(alberto, programacao, jose);
		
		Solicitacoes.solicitarHistorico(programacao, jose);
		Solicitacoes.solicitarBoleto(programacao, jose);
		
		System.out.println(Aluno.getMesesModulo());
		
		jose.listarDisciplinasMatriculadas();
		alberto.listarDisciplinasLecionadas();
	}
}
