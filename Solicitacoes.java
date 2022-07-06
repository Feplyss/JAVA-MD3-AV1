package Avaliacao1;

public class Solicitacoes {

	public static void solicitarHistorico(Disciplina d, AlunoGrad a) {
		System.out.println("Faltas = " + RegistroDisciplina.listarFaltas(d, a));
		System.out.println("Nota = " + RegistroDisciplina.getNota(d, a));
	}
	
	public static void solicitarHistorico(Disciplina d, AlunoPos a) {
		System.out.println("Faltas = " + RegistroDisciplina.listarFaltas(d, a));
		System.out.println("Nota = " + RegistroDisciplina.getNota(d, a));
	}
	
	public static void solicitarBoleto(Disciplina d, AlunoGrad a) {
		if(d.checarAluno(a) >= 0) {
			System.out.println(d.getMensalidade());
		}
	}
	
	public static void solicitarBoleto(Disciplina d, AlunoPos a) {
		if(d.checarAluno(a) >= 0) {
			System.out.println(d.getMensalidade());
		}
	}
}
