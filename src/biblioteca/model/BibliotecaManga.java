package biblioteca.model;

public class BibliotecaManga extends Biblioteca{
	
	private int qtdeVol;
	private String reimpressao;
	
	public BibliotecaManga(int numero, String titulo, String autor, int ano, String editora, int tipo, int qtdeVol, String reimpressao) {
		super(numero, titulo, autor, ano, editora, tipo);
		
		this.qtdeVol = qtdeVol;
		this.reimpressao = reimpressao;
		
	}

	public int getQtdeVol() {
		return qtdeVol;
	}

	public void setQtdeVol(int qtdeVol) {
		this.qtdeVol = qtdeVol;
	}

	public String getReimpressao() {
		return reimpressao;
	}

	public void setReimpressao(String reimpressao) {
		this.reimpressao = reimpressao;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		
		System.out.println("Quantidade de volumes: " +this.qtdeVol);
		System.out.println("Reimpressão: " +this.reimpressao);
	}
	

}
