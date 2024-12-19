package biblioteca.repository;

import biblioteca.controller.BibliotecaController;
import biblioteca.model.Biblioteca;

public interface BibliotecaRepository {
	
	public void cadastrar(Biblioteca biblioteca);
	public void localizar(int numero);
	public void atualizar(Biblioteca biblioteca);
	public void listar();
	public void excluir(int numero);
}
