package model;

public class Unidade {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Unidade(String nome) {
		super();
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
	
}
