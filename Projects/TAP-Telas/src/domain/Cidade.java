package domain;

public class Cidade {
	
	private String nome;
	private Estado estado;
	
	@Override
	public String toString() {
		return getNome()+"("+estado+")";
	}
	
	public Cidade(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
