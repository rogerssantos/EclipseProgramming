public class No {

	public int valor;
	public No proximo;
	public No anterior;
	
	public No(int v){
		this.valor = v;
		this.proximo = null;
		this.anterior = null;
	}

	@Override
	public String toString() {
		return valor+"";
	}	
}