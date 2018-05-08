
public class No {
	private No prox, ant;
	private Object entrada;
	
	public No(Object item) {
		this.entrada = entrada;
		prox = null;
		ant = null;
	}

	public No getAnt() {
		return ant;
	}

	public void setAnt(No ant) {
		this.ant = ant;
	}

	public Object getEntrada() {
		return entrada;
	}

	public void setEntrada(Object entrada) {
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
