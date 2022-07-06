package Avaliacao1;

public class AlunoPos extends Aluno{

	//--Construtor--
		public AlunoPos(String nome, String cpf, String matricula, String telefone, String email, String endereco) {
			super(nome, cpf, matricula, telefone, email, endereco);
			AlunoGrad.setModulos(6);
			AlunoGrad.setMesesModulo(2);
			AlunoGrad.setTipoAvaliacao("Trabalho de Conclusao de Curso");
		}
	
}
