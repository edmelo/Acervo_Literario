// Classe LeitorModelo
package modelos;

public class LeitorModelo {
	private String nome;
	private String cpf;
	private String email;
	private int emprestimosAtivos;

	// Construtores, getters e setters

	public LeitorModelo() {}

	public LeitorModelo(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmprestimosAtivos() {
		return emprestimosAtivos;
	}

	public void setEmprestimosAtivos(int emprestimosAtivos) {
		this.emprestimosAtivos = emprestimosAtivos;
	}

	// Adicionar o método getEmprestimo
	public int getEmprestimo() {
		return emprestimosAtivos;
	}

	// Adicionar o método setEmprestimo
	public void setEmprestimo(int emprestimosAtivos) {
		this.emprestimosAtivos = emprestimosAtivos;
	}

	// Adicionar o método adicionarEmprestimo
	public void adicionarEmprestimo(int quantidade) {
		this.emprestimosAtivos += quantidade;
	}

	// adicionar o método removerEmprestimo
	public void removerEmprestimo(int quantidade) {
		this.emprestimosAtivos -= quantidade;
	}
}