
public class UsaPilhaDeInteiros{
	public static void main(String args[]) {
		PilhaDeInteiros p = new PilhaDeInteiros();
		p.empilhar(1);
		p.empilhar(2);
		p.empilhar(3);
		p.empilhar(4);
		p.empilhar(5);
		while (p.estaVazia() == false) {
			System.out.println(p.desempilhar());
		}
	}
}