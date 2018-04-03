
class No {
	
	//Attributes
	public String digito;
	public No proximo;
	
	//Constructor
	public No(String v){
		digito = v;
		proximo = null;
	}
}

public class PilhaADCalculadora {
	
	private No topo = null;
	
	public boolean estaVazia() {
		return topo == null;
	}
	
	public void empilha(String digito) {
		No novo = new No(digito);
		if(topo == null)
			topo = novo;
		else if (digito == "+" || digito == "-" || digito == "*" || digito == "/") {
			desempilhar();
			String operador1 = topo;
			
			
			novo.proximo = topo;
			topo = novo;
		}
	}
	
	public String desempilhar() {
		String retVal = topo.digito;
		topo = topo.proximo;
		return retVal;
	}
	
}