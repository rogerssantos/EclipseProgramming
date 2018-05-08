
public class ListaDuplamenteEncadeada {
	private No primeiro = null, ultimo = null;
	private int size = 0;
	
	public void adicionaPrimeiro (Object entrada) {
		No novo = new No(entrada);
		
		if (primeiro == null) {
			primeiro = novo;
			ultimo = novo;
		} else {
			primeiro.setAnt(novo);
			novo.setProx(primeiro);
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
		if (primeiro.getProx() != null)	{
			primeiro = primeiro.getProx();
			primeiro.getAnt().setProx(null);
			primeiro.setAnt(null);
		} else {
			primeiro = null;
			ultimo = null;
		}
		size--;
		
		return aux.getItem();
	}
	
	public void adicionaUltimo (Object entrada) {
		No novo = new No(entrada);
		
		if (isVazia()) {
			primeiro = novo;
			ultimo = novo;
		} else {
			novo.setAnt(ultimo);
			ultimo.setProx(novo);
			ultimo = novo;
		}
		
		size++;
	}
	
	public Object removeUltimo() {
	if (isVazia()) return null;
		
		No aux = ultimo;
		if (ultimo.getAnt() != null)	{
			ultimo = ultimo.getAnt();
			ultimo.getProx().setAnt(null);
			ultimo.setProx(null);
		} else {
			primeiro = null;
			ultimo = null;
		}
		size--;
		
		return aux.getItem();
	}

	private boolean isVazia() {
		return primeiro == null;
	}
}


