package biblioteca.model;

public abstract class Biblioteca {

	private int numero;
	private String titulo;
	private String autor;
	private int ano;
	private String editora;
	private int tipo;
	
	public Biblioteca( int numero, String titulo, String autor, int ano, String editora, int tipo) {
		
		this.numero = numero;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.editora = editora;
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getTipo() {
		return tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void visualizar() {
		String tipo = "";
		switch(this.tipo){
			case 1: 
				tipo = "Livro";
				break;
			case 2:
				tipo = "Mangá";			
				break;
		}
		System.out.println("\n\n******************************************");
        System.out.println("Dados de Cadastro                  : ");
        System.out.println("*******************************************");
        System.out.println("Código do Produto: " +this.numero);
        System.out.println("Título: " +this.titulo);
        System.out.println("Autor: " +this.autor);
        System.out.println("Ano: " +this.ano);
        System.out.println("Editora: " +this.editora);
        System.out.println("Tipo: " +tipo);
       
	}
}
	

