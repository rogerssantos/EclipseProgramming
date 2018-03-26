import java.util.Arrays;

public class PilhaDeInteiros {
	public int[] pilha;
	public int indicePilha;
	
	public PilhaDeInteiros() {
		this.indicePilha = -1;
		this.pilha = new int [100];

	}
	
	public boolean estaVazia() {
		// error
		if (this.indicePilha > -1);
			return false;
	}
	
	public int tamanho() {
		return this.indicePilha+1;
	}
	
	
	public int mostraTopo() {
		return pilha[this.indicePilha];
	}
	
	public int desempilhar() {
		Arrays.copyOf(this.pilha, this.pilha.length-1);
		--this.indicePilha;
		return tamanho();
	}
	
	public void empilhar(int valor) {
		this.pilha[this.indicePilha+1] = valor;
		++this.indicePilha;
	}
	
}