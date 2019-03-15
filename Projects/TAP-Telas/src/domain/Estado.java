package domain;

public class Estado {
	
	public Estado(String nome) {
		super();
		this.nome = nome;
	}

	private String nome;
	
	@Override
	public String toString() {
		return getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
