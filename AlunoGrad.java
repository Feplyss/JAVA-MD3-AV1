package Avaliacao1;

public class AlunoGrad extends Aluno {
	
	//--Construtor--
	public AlunoGrad(String nome, String cpf, String matricula, String telefone, String email, String endereco) {
		super(nome, cpf, matricula, telefone, email, endereco);
		AlunoGrad.setModulos(5);
		AlunoGrad.setMesesModulo(6);
		AlunoGrad.setTipoAvaliacao("Projeto integrador");
	}
}
