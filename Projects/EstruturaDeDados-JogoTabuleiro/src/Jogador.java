public class Jogador {

	private Pizza pizza;
	private int posicaoTabulero;
	private Sacola sacola;
	private String nome;
	private Jogador proximo;
	private Jogador anterior;
	
	
	public Jogador() {
		this.sacola = new Sacola();
		this.proximo = null;
		this.anterior = null;
	}

	//verifica se a pizza selecionada contem o item
	public boolean verificaItem(int item){
		return this.pizza.verificaItem(item);
	}
	
	//verifica se a sacola esta cheia para identifica o ganhador
	public boolean verificaSacolaCheia(){
		return this.sacola.estaCheia();
	}
	
	//adicio o item na sacola
	public String addItemSacola(int item){
		
		if (this.pizza.verificaItem(item)){
			
			if(!this.sacola.jaContemItem(item)){
				
				this.sacola.add(item);
				return "Item adicionado na sacola!";
			}else{
				return "Sua Sacola ja contém o item ganho.";
			}
				
		}else{
			return "Sua pizza não contem o item ganho.";
		}
			
	}
	
	//remove item na sacola
	public void removeItemSacola(){
		this.sacola.remove();
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getPosicaoTabulero() {
		return posicaoTabulero;
	}

	public void setPosicaoTabulero(int posicaoTabulero) {
		this.posicaoTabulero = posicaoTabulero;
	}

	public Sacola getSacola() {
		return sacola;
	}

	public void setSacola(Sacola sacola) {
		this.sacola = sacola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Jogador getProximo() {
		return proximo;
	}

	public void setProximo(Jogador proximo) {
		this.proximo = proximo;
	}

	public Jogador getAnterior() {
		return anterior;
	}

	public void setAnterior(Jogador anterior) {
		this.anterior = anterior;
	}
}