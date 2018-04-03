
public class UsaPilhaDinamica {

	public static void main(String[] args) {

		PilhaDinamica p = new PilhaDinamica();
		System.out.println("Empilhando...");
		p.empilha(10);
		p.empilha(20);
		p.empilha(30);
		p.empilha(40);
		while (p.estaVazia() == false) {
			System.out.println(p.desempilhar());
		}
		
	}
}
