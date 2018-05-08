
public class No {
	private No prox;
	private Object entrada;
	
	public No(Object item) {
		this.prox = prox;
		this.entrada = entrada;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

	public Object getItem() {
		return entrada;
	}

	public void setItem(Object item) {
		this.entrada = item;
	}
}
