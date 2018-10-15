public class Tabuleiro {
	
	private No inicio;
	private No fim;
	private No aux;
	
	public Tabuleiro(int item) {
		No n = new No(item);
		this.inicio = n;
		this.inicio.anterior = n;
		this.fim = n;
		this.fim.anterior = n;
		this.fim.proximo = n;
	}
	
	public void add(int item){		

		No n = new No(item);
		this.aux = this.fim;
		 this.aux.proximo = n;
		this.fim = n;
		this.fim.anterior = this.aux;
		this.fim.proximo = this.inicio;
		this.inicio.anterior = this.fim;		
	}

	public int getItem(int posicao){
		
		this.aux = this.inicio;
		
		for (int i = 1; i <= posicao; i++) {
			
			this.aux = this.aux.proximo;
		}
		
		return this.aux.valor;
	}
}
