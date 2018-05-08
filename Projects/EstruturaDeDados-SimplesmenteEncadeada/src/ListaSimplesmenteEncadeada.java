
public class ListaSimplesmenteEncadeada {
	private No primeiro = null, ultimo = null;
	private int size = 0;
	
	public void adicionaPrimeiro (Object entrada) {
		No novo = new No(entrada);
		
		if (primeiro == null) {
			primeiro = novo;
			ultimo = novo;
		} else {
			novo.setProx(primeiro);;
			primeiro = novo;
		}
		
		size++;
	}
	
	public No getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(No primeiro) {
		this.primeiro = primeiro;
	}

	public No getUltimo() {
		return ultimo;
	}

	public void setUltimo(No ultimo) {
		this.ultimo = ultimo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Object removePrimeiro() {
		if (isVazia()) return null;
		
		No aux = primeiro;
		primeiro = aux.getProx();
		
		aux.setProx(null);
		
		size--;
		
		return aux.getItem();
	}
	
	public void adicionaUltimo (Object entrada) {
		No novo = new No(entrada);
		
		if (isVazia()) {
			primeiro = novo;
			ultimo = novo;
		} else {
			ultimo.setProx(primeiro);;
			ultimo = novo;
		}
		
		size++;
	}
	
	public Object removeUltimo() {
		if (isVazia()) return null;
		
		No aux = primeiro;
		while (aux != null) {
			
			if (aux.getProx().getProx() == null) {
				No aux2 = ultimo;
				ultimo = aux;
				ultimo.setProx(null);
				return aux2.getItem();
			}
			
			aux = aux.getProx();
		}
		
		size--;
		
		return null;
	}

	private boolean isVazia() {
		return primeiro == null;
	}
	
	public Object mostraPrimeiro() {
		No novo = new No();
		return primeiro.getItem();
	}
}


