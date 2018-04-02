
class No {
	
	//Attributes
	public int valor;
	public No proximo;
	
	//Constructor
	public No(int v){
		valor = v;
		proximo = null;
	}
}

public class PilhaDinamica {
	
	private No topo = null;
	
	public PilhaDinamica() {
	}
	
	public boolean estaVazia() {
		return topo == null;
	}
	
	public void empilha(int v) {
		No novo = new No(v);
		if(topo == null)
			topo = novo;
		else {
			novo.proximo = topo;
			topo = novo;
		}
	}
	
	public int desempilhar() {
		int retVal = topo.valor;
		topo = topo.proximo;
		return retVal;
	}
	
}