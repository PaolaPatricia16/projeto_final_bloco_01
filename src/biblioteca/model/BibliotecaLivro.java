package biblioteca.model;

public class BibliotecaLivro extends Biblioteca{
	
	private int qtdeExemplares;
	
	public BibliotecaLivro(int numero, String titulo, String autor, int ano, String editora, int tipo, int qtdeExemplares) {
		super(numero, titulo, autor, ano, editora, tipo);
		
		this.qtdeExemplares = qtdeExemplares;
	}

	public int getQtdeExemplares() {
		return qtdeExemplares;
	}

	public void setQtdeExemplares(int qtdeExemplares) {
		this.qtdeExemplares = qtdeExemplares;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		
		System.out.println("Quantidade de exemplares: " +this.qtdeExemplares);
	}

}
