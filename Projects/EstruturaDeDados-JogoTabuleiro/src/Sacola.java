public class Sacola {
	
	private No item = null;
	private No fim = null;
	private No aux = null;
	public int quantidade = 0;

	public Sacola() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(int ingrediente){
		No n = new No(ingrediente);
		if(item == null){
			this.item = n;
			this.fim = n;
		}else{
			this.aux = this.fim;
			this.aux.proximo = n;
			this.fim = n;			
		}	
		quantidade++;
	}

	public boolean estaVazia(){
		return quantidade==0;
	}
	
	public void remove(){
		
		this.aux = item;		
		while (this.aux.proximo!=null) {
			
			if(this.aux.proximo.valor == this.fim.valor){
				this.aux.proximo = null;
				this.fim = this.aux;
			}else{
				this.aux = this.aux.proximo;
			}
		}
		quantidade--;
	}
	
	/**
	 * @return <strong>boolean</strong><br/>
	 * 			<u>true:</u> se a sacola estiver 5 item para formar a pizza<br/>
	 * 			<u>false:</u> se a sacola estiver menos de 5 item
	 */
	public boolean estaCheia(){
		return quantidade==5;
	}
	
	/**
	 * @return <strong>boolean</strong><br/>
	 * 			<u>true:</u> se a sacola ja tiver o item<br/>
	 * 			<u>false:</u> se a sacola nãoo tiver o item
	 */
	public boolean jaContemItem(int item){
		//verifica se a sacola esta vazia
		if(this.estaVazia())
			return false;
			
		this.aux = this.item;
			
		while (this.aux.proximo !=null) {
				
			if(this.aux.valor == item)
				return true;
			else
				this.aux = this.aux.proximo;
			
		}
		
		return false;
	}
}