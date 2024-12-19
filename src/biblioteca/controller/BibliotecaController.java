package biblioteca.controller;

import biblioteca.repository.BibliotecaRepository;
import biblioteca.util.Cores;

import java.util.ArrayList;

import biblioteca.model.*;

public class BibliotecaController implements BibliotecaRepository {

	private ArrayList<Biblioteca> listaBibliotecas = new ArrayList<Biblioteca>();

	int numero = 0; // gera o código do produto

	@Override
	public void cadastrar(Biblioteca biblioteca) {
		listaBibliotecas.add(biblioteca);

		System.out
				.println(Cores.TEXT_PINK_BOLD+ "\nO Cadastro do produto com o Código " + biblioteca.getNumero() + " foi gerado com sucesso! " +Cores.TEXT_RESET);
	}
	
	@Override
	public void localizar(int numero) {
		var localiza = buscarNaLista(numero);
		
		if(localiza == null) {
			System.out.println("O produto do Código " +numero+ " não foi localizado! ");
		}else {
			localiza.visualizar();
		}
		
	}
	@Override
	public void atualizar(Biblioteca biblioteca) {

		var buscarProduto = buscarNaLista(biblioteca.getNumero());

		if (buscarProduto == null) {
			System.out.println(Cores.TEXT_RED_BOLD+ "O produto do Código " + biblioteca.getNumero() + " não foi localizado! " +Cores.TEXT_RESET);
		} else {
			listaBibliotecas.set(listaBibliotecas.indexOf(buscarProduto), biblioteca);
			System.out.println(Cores.TEXT_PINK_BOLD+ "O produto do Código " + biblioteca.getNumero() + " foi atualizado com sucesso!" +Cores.TEXT_RESET);
		}
	}

	@Override
	public void listar() {
		if(listaBibliotecas.isEmpty() == true) {
			System.out.println(Cores.TEXT_RED_BOLD+ "\nNão há nenhum produto cadastrado!" +Cores.TEXT_RESET);
		} else {
			for(var lista : listaBibliotecas) {
				lista.visualizar();
			}	
		}
		
	}

	@Override
	public void excluir(int numero) {

		var buscarProduto = buscarNaLista(numero);

		if (buscarProduto == null) {
			System.out.println(Cores.TEXT_RED_BOLD+ "Produto com o código " + numero + " não localizado! " +Cores.TEXT_RESET);
		} else {
			if (listaBibliotecas.remove(buscarProduto) == true)
				System.out.println(Cores.TEXT_PINK_BOLD+ "Produto excluído com sucesso! " +Cores.TEXT_RESET);

		}

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Biblioteca buscarNaLista(int numero) {
		for (var codigo : listaBibliotecas) {
			if (codigo.getNumero() == numero) {
				return codigo;

			}
		}
		return null;
	}



}
