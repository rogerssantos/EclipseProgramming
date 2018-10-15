public class Pizza {
	
	private No inicio;
	private No fim;
	private No aux;
	public int tamanho = 0;

	public Pizza(int ingrediente){
		No n = new No(ingrediente);
		tamanho++;
		this.inicio = n;
		this.fim = n;
	}
	
	public void add(int ingrediente){
		No n = new No(ingrediente);
		tamanho++;
		this.aux = fim;
		this.aux.proximo = n;
		this.fim = n;
	}

	/**
	  Metodo para verifica se a pizza contem o item passado por parametro
	 @param item
	  @return boolean <br/>true se a pizza tiver o item <br/> 
	 				   false se a pizza não tiver o item	
	 **/
	public boolean verificaItem(int item){
		this.aux = this.inicio;
		for (int i = 0; i < 5; i++) {
			if(this.aux.valor == item)
				return true;
			else
				this.aux = this.aux.proximo;
		}
		return false;
	}
}
