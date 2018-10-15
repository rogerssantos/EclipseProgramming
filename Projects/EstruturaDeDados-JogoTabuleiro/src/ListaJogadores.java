public class ListaJogadores {

	public Jogador inicio;
	public Jogador fim;
	public Jogador aux;
	public int total = 0;
	
	public ListaJogadores(){
		this.inicio = null;
		this.fim = null;
		this.aux = null;
	}
	
	public void add(Jogador jogador){
		this.total++;
		if(this.inicio == null){
			
			this.inicio = jogador;
			this.fim = jogador;
			
		}else{
			this.aux = this.fim;
			this.aux.setProximo(jogador);
			this.fim = jogador;
			this.fim.setProximo(this.inicio);
			
		}
		
	}
	
}