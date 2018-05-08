
public class ListaCircular {
	
	No primeiro;
	int tamanho;
	
	public ListaCircular() {
		this.primeiro = null;
		this.tamanho = 0;
	}
	
	public void adicionar(Object item) {
		if (primeiro == null) {
			primeiro = new No(item);
			primeiro.setProx(primeiro);
			tamanho++;
		} else {
			No aux = primeiro;
			while (aux.getProx() != primeiro) {
				aux = aux.getProx();
			}
			
			aux.setProx(new No(primeiro));
			tamanho++;
		}
	}
	
	public Object primeiroLista(ListaCircular lista) {
		
		if(primeiro != null) {
			No aux = primeiro;
			Object item = aux.getItem();
			
			if (aux.getProx()  == primeiro) {
				return item;
			} else {
				while (aux.getProx() != primeiro) {
					if(aux.getItem() < primeiro) {
						primeiro = aux.getItem();
						aux = aux.getProx();
					} else {
						aux = aux.getProx();
					}
				}
				
				if (aux.getProx() == primeiro) {
					if (aux.getItem() < primeiro) {
						primeiro = aux.getItem();
					}
				}
			}
			
		}
	}
}
