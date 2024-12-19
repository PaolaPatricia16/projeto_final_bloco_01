package biblioteca;

import java.io.IOException;
import java.util.Scanner;

import biblioteca.controller.BibliotecaController;
import biblioteca.model.*;
import biblioteca.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		String titulo, autor, editora, reimpressao;
		int op, numero, ano, qtdeExemplares, tipo, qtdeVol;

		BibliotecaController bibliotecas = new BibliotecaController();

		BibliotecaLivro livro = new BibliotecaLivro(bibliotecas.gerarNumero(), "Dom Casmurro", "Machado de Assís", 1899,
				"Antofágica", 1, 50);
		bibliotecas.cadastrar(livro);

		BibliotecaManga manga = new BibliotecaManga(bibliotecas.gerarNumero(), "Naruto", "Masashi Kishimoto", 1999,
				"Panini", 2, 72, "Sim");
		bibliotecas.cadastrar(manga);
		bibliotecas.listar();

		do {
			System.out.println(Cores.ANSI_PINK_BACKGROUND + "\n\n**********************************");
			System.out.println("           BIBLIOTECA             ");
			System.out.println("**********************************");
			System.out.println("                                  ");
			System.out.println("         1 - Cadastrar            ");
			System.out.println("         2 - Buscar               ");
			System.out.println("         3 - Atualizar            ");
			System.out.println("         4 - Listar               ");
			System.out.println("         5 - Excluir              ");
			System.out.println("         6 - Sair                 ");
			System.out.println("                                  ");
			System.out.println("**********************************");
			System.out.println(" Entre com a opção desejada:      ");
			System.out.println("                                  " + Cores.TEXT_RESET);

			op = leia.nextInt();

			switch (op) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD_UNDERLINED+ "\nNovo Cadastro " +Cores.TEXT_RESET);

				System.out.println("Digite o Título da Obra: ");
				leia.skip("\\R?");
				titulo = leia.nextLine();
				System.out.println("Digite o Autor: ");
				autor = leia.nextLine();
				System.out.println("Digite o ano de Publicação: ");
				ano = leia.nextInt();
				System.out.println("Digite a Editora: ");
				leia.skip("\\R?");
				editora = leia.nextLine();

				do {
					System.out.println("Digite a Categoria: (1 - Livro ou 2 - Mangá) ");
					tipo = leia.nextInt();

				} while (tipo < 1 && tipo > 2);

				switch (tipo) {
				case 1:
					System.out.println("Digite a quantidade de Exemplares: ");
					qtdeExemplares = leia.nextInt();

					bibliotecas.cadastrar(new BibliotecaLivro(bibliotecas.gerarNumero(), titulo, autor, ano, editora,
							tipo, qtdeExemplares));
					break;
				case 2:
					System.out.println("Digite a quantidade de Volumes: ");
					qtdeVol = leia.nextInt();
					System.out.println("É uma reimpressão? ");
					reimpressao = leia.next();

					bibliotecas.cadastrar(new BibliotecaManga(bibliotecas.gerarNumero(), titulo, autor, ano, editora,
							tipo, qtdeVol, reimpressao));
				}

				keypress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD_UNDERLINED+ "\nBuscar produto por Código" +Cores.TEXT_RESET);

				System.out.println("\nDigite o Código do Produto: ");
				numero = leia.nextInt();
				
				bibliotecas.localizar(numero);
				
				keypress();
				break;
				
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD_UNDERLINED+ "\nAtualizar Cadastro" +Cores.TEXT_RESET);

				System.out.println("\nDigite o Código do Produto: ");
				numero = leia.nextInt();

				var buscarProduto = bibliotecas.buscarNaLista(numero);

				if (buscarProduto == null) {
					System.out.println("Produto não localizado! ");
				} else {
					System.out.println("Digite o Título: ");
					leia.skip("\\R?");
					titulo = leia.nextLine();
					System.out.println("Digite o Autor: ");
					autor = leia.nextLine();
					System.out.println("Digite o ano de Publicação: ");
					ano = leia.nextInt();
					System.out.println("Digite a Editora: ");
					leia.skip("\\R?");
					editora = leia.nextLine();

					tipo = buscarProduto.getTipo();

					switch (tipo) {
					case 1:
						System.out.println("Digite a quantidade de Exemplares: ");
						qtdeExemplares = leia.nextInt();

						bibliotecas.atualizar(
								new BibliotecaLivro(numero, titulo, autor, ano, editora, tipo, qtdeExemplares));
						break;
					case 2:
						System.out.println("Digite a quantidade de Volumes: ");
						qtdeVol = leia.nextInt();
						System.out.println("É uma reimpressão? ");
						reimpressao = leia.next();

						bibliotecas.atualizar(
								new BibliotecaManga(numero, titulo, autor, ano, editora, tipo, qtdeVol, reimpressao));

						break;
					default:
						System.out.println("Categoria inválida! ");
					}

				}

				keypress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD_UNDERLINED+ "\nListar Produtos" +Cores.TEXT_RESET);

				bibliotecas.listar();

				keypress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD_UNDERLINED+ "\nExcluir Produto" +Cores.TEXT_RESET);

				System.out.println("\nDigite o Código do Produto: ");
				numero = leia.nextInt();

				bibliotecas.excluir(numero);

				keypress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PINK_BOLD + "\nATÉ A PRÓXIMA!!!" + Cores.TEXT_RESET);

				sobre();
				System.exit(0);
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida!" + Cores.TEXT_RESET);

				keypress();
				break;
			}
		} while (op != 6);

	}

	public static void sobre() {
		System.out.println("\n**********************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Paola Patricia - patricia-9856@hotmail.com");
		System.out.println("https://github.com/PaolaPatricia16");
		System.out.println("**********************************************");
	}

	public static void keypress() {

		try {
			System.out.println("\nPressiona Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
