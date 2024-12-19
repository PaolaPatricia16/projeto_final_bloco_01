package biblioteca;

import java.io.IOException;
import java.util.Scanner;

import biblioteca.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		String titulo, autor, editora, reimpressao;
		int op, ano, qtdeExemplares, tipo, qtdeVol;
		
		do {
			System.out.println(Cores.ANSI_PINK_BACKGROUND
							  +"**********************************");
			System.out.println("           BIBLIOTECA             ");
			System.out.println("**********************************");
			System.out.println("                                  ");
			System.out.println("         1 - Cadastrar            ");
			System.out.println("         2 - Atualizar            ");
			System.out.println("         3 - Listar               ");
			System.out.println("         4 - Excluir              ");
			System.out.println("         5 - Sair                 ");
			System.out.println("                                  ");
			System.out.println("**********************************");
			System.out.println(" Entre com a opção desejada:      ");
			System.out.println("                                  " +Cores.TEXT_RESET);

			op = leia.nextInt();

			switch (op) {
			case 1:
				System.out.println("Novo Cadastro ");
				
				keypress();
				break;
			case 2:
				System.out.println("Atualizar Cadastro");


				
				keypress();
				break;
			case 3:
				System.out.println("Listar Produtos");

				keypress();
				break;
			case 4:
				System.out.println("Excluir Produto");

				keypress();
				break;
			case 5:
				System.out.println("Até a próxima!!!");

				sobre();
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida!");
				
				keypress();
				break;
			}
		} while (op != 5);

	}
	
	public static void sobre() {
		System.out.println("\n**********************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Paola Patricia - patricia-9856@hotmail.com");
		System.out.println("https://github.com/PaolaPatricia16");
		System.out.println("**********************************************");
	}

	public static void keypress(){

		try {
			System.out.println("\nPressiona Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		
		}
	}
	
}
