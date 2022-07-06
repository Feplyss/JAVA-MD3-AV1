package Avaliacao1;

public abstract class Usuario {

	private String nome;
	private String cpf;
	private String matricula;
	private String telefone;
	private String email;
	private String endereco;
	
	//--Construtor--
	
	public Usuario(String nome, String cpf, String matricula, String telefone, String email, String endereco) {
		
		setNome(nome);
		setCpf(cpf);
		setMatricula(matricula);
		setTelefone(telefone);
		setEmail(email);
		setEndereco(endereco);
	}
	
	//--Gets e Sets--
	
	public String getNome() {
		return nome;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	private void setCpf(String cpf) {
		this.checaCpf(cpf);
		this.cpf = cpf;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	private void setMatricula(String matricula) {
		this.checaMatricula(matricula);
		this.matricula = matricula;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	private void setTelefone(String telefone) {
		checaTelefone(telefone);
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	private void setEmail(String email) {
		checaEmail(email);
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	private void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//--Metodos--
	
	private void checaCpf(String cpf) {
		try {
			Long.parseLong(cpf);
		}catch(Exception e) {
			throw new NumberFormatException("O CPF deve conter 11 digitos numericos.");
		}
		if(cpf.length() != 11) {
			throw new IndexOutOfBoundsException("O CPF deve conter 11 digitos numericos.");
		}
	}

	private void checaMatricula(String matricula) {
		try {
			Long.parseLong(matricula);
		}catch(Exception e) {
			throw new NumberFormatException("A matricula deve conter 3 dígitos numéricos.");
		}
		if(matricula.length() != 3) {
			throw new IndexOutOfBoundsException("A matricula deve conter 3 dígitos numéricos.");
		}
	}
	
	private void checaTelefone(String telefone) {
		try {
			Long.parseLong(telefone);
		}catch(Exception e) {
			throw new NumberFormatException("O telefone deve conter 8 ou 9 dígitos numéricos.");
		}
		if(telefone.length() < 8 || telefone.length() > 9) {
			throw new IndexOutOfBoundsException("O telefone deve deve conter 8 ou 9 dígitos numéricos.");
		}
	}
	
	public void checaEmail(String email) {
		if(email.indexOf("@") <= 0) {
			throw new IllegalArgumentException("Email inválido.");
		}
	}
}
