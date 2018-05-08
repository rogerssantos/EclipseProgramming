
public class UsaListaSimplesmenteEncadeada {

	public static void main(String[] args) {
		
		ListaSimplesmenteEncadeada lse = new ListaSimplesmenteEncadeada();
		System.out.println("Inserindo...");
		lse.adicionaPrimeiro(5);
		lse.adicionaUltimo(4);
		lse.removePrimeiro();
		lse.mostraPrimeiro();

	}

}
