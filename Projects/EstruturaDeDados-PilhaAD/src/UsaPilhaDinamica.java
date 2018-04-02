
public class UsaPilhaDinamica {

	public static void main(String[] args) {

		PilhaDinamica p = new PilhaDinamica();
		System.out.println("Empilhando...");
		p.empilha(1);
		p.empilha(2);
		p.empilha(3);
		p.empilha(4);
		while (p.estaVazia() == false) {
			System.out.println(p.desempilhar());
		}
		
	}
}
