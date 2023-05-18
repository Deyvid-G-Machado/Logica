import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleDeVendas {
	// Escopo global (enxergado por todas as funções)
	public static Scanner input = new Scanner(System.in);
	public static List<String> nomeProdutos = new ArrayList<>();	// Onde fica guarddo os nomes dos produtos
	public static List<Double> valorProdutos = new ArrayList<>();	// Onde fica guardado os valores do produto
	public static List<String> vendas = new ArrayList<>();			// Aqui ira ficar guardado todas as vendas feitas
	public static double vendasTotal = 0;
	public static int opcao;
	
	public static void main(String[] args) {
		// Menu de escolhas
		boolean menuPrincipal = true, menuProdutos;
		
		
		while (menuPrincipal) {
			System.out.println("=====| Controle de Vendas |=====\n"
					+ "1 - PDV\n"
					+ "2 - Gerenciamento de produtos\n"
					+ "3 - Fechamento de caixa\n"
					+ "0 - Sair");
			opcao = input.nextInt();
			
			switch (opcao) {
			case 1: // PDV - Ponto de venda
				pdv();
				break;
			case 2: // Gerenciamento de produtos
				
				produtos();
				break;
			case 3: // Fechamento de caixa
				fechamentoCaixa();
				break;
			case 0: // Sair do programa
				menuPrincipal = false;
				break;
				
			default:
				System.out.println("Escolha uma opcao valida!\n");
				break;
			}
			
		}
		System.out.println("Sistema encerrado!");
	}
	
	// Menu de produtos
	public static void produtos() {
		boolean menuProdutos = true;
		while (menuProdutos) {
			System.out.println("\n=====| Gerenciamento de produtos |=====\n"
					+ "1 - Cadastrar | 2 - Listar | 3 - Alterar | 4 - Remover | 0 - Voltar");
			opcao = input.nextInt();
			switch (opcao) {
			case 1: // Cadastrar
				System.out.println("\n=====| Cadastrar produto |=====\n"
						+ "Nome:");
				String nome = input.next();
				
				System.out.println("Valor:");
				double valor = input.nextDouble();
				
				cadastrarProdutos(nome, valor);
				break;
			case 2: // Listar
				listarProdutos();
				break;
			case 3: // Alterar
				System.out.println("Qual Produto deseja alterar (digite o indice referente ao produto):");
				opcao = input.nextInt() - 1;
				
				alterarProdutos(opcao);
				break;
			case 4: // Remover
				System.out.println("Qual Produto deseja remover (digite o indice referente ao produto):");
				opcao = input.nextInt() - 1;
				
				removerProdutos(opcao);
				break;
			case 0: // Voltar para o menu principal
				menuProdutos = false;
				break;

			default:
				System.out.println("Escolha uma opcao valida!\n");
				break;
			}
		}
	}
	
	// Cadastrar produtos
	public static void cadastrarProdutos(String nome, double valor) {
		nomeProdutos.add(nome);
		valorProdutos.add(valor);
		System.out.println("Produto adicionado!");
	}
	
	// Listar produtos
	public static void listarProdutos() {
		System.out.println("Lista de produtos:");
		for (int i = 0; i < nomeProdutos.size(); i++) {
			System.out.println(i+1 + ") " + nomeProdutos.get(i) + " | R$ " + valorProdutos.get(i));
		}
	}
	
	// Alterar produtos
	public static void alterarProdutos(int opcao) {
		boolean menuAlterar = true;
		
		while (menuAlterar) {
			System.out.println("=====| Alteracao de produto |=====\n"
					+ "1 - Nome | 2 - Valor | 0 - Voltar");
			int opcaoAlterar = input.nextInt();
			
			switch (opcaoAlterar) {
			case 1: // Nome
				System.out.println("Escolha um novo nome:");
				String nome = input.next() ;
				nomeProdutos.set(opcao, nome);
				
				System.out.println("Nome do produto alterado!");
				break;
			case 2: // Valor
				System.out.println("Escolha um novo valor:");
				Double valor = input.nextDouble();
				valorProdutos.set(opcao, valor);
				
				System.out.println("Valor do produto alterado!");
				break;
			case 0: // Voltar
				menuAlterar = false;
				break;
				
			default:
				System.out.println("Escolha uma opcao valida!\n");
				break;
			}
		}
	}
	
	// Remover produtos
	public static void removerProdutos(int opcao) {
		nomeProdutos.remove(opcao);
		valorProdutos.remove(opcao);
		System.out.println("Produto removido!");
	}
	
	// Menu PDV
	public static void pdv() {
		boolean menuPDV = true;
		
		while (menuPDV) {
			System.out.println("\n=====| PDV - Ponto de Venda |=====\n"
					+ "1 - Cadastrar venda\n"
					+ "2 - Relatorio de vendas\n"
					+ "3 - Lista de produtos\n"
					+ "0 - Voltar");
			opcao = input.nextInt();
			
			switch (opcao) {
			case 1: // Cadastro venda
				System.out.println("Escolha o produto:");
				int indiceProduto = input.nextInt() - 1;
				
				System.out.println("Escolha a quantidade:");
				int quantidadeProduto = input.nextInt();
				
				cadastrarVenda(indiceProduto, quantidadeProduto);
				break;
			case 2: // Relatorio de vendas
				relatorioVendas();
				break;
			case 3: // Lista de produtos
				listarProdutos();
				break;
			case 0: // Voltar
				menuPDV = false;
				break;

			default:
				System.out.println("Escolha uma opcao valida!\n");
				break;
			}
		}
	}
	
	// Cadastrar venda
	public static void cadastrarVenda(int indiceProduto, int quantidadeProduto) {
		if (indiceProduto < nomeProdutos.size() && indiceProduto >= 0) {
			for (int i = 0; i < quantidadeProduto; i++) {
				vendas.add(nomeProdutos.get(indiceProduto) + " | " + valorProdutos.get(indiceProduto));
				vendasTotal += valorProdutos.get(indiceProduto);
			}
		} else {
			System.out.println("Escolha um produto valido!");
		}
		
		
	}
	
	// Relatorio vendas
	public static void relatorioVendas() {
		System.out.println("Relatorio de vendas:");
		for (int i = 0; i < vendas.size(); i++) {
			System.out.println(vendas.get(i));
		}
	}
	
	// Fechamento de caixa
	public static void fechamentoCaixa() {
		System.out.println("=====| Fechamento de Caixa |=====");
		relatorioVendas();
		System.out.println("\nTotal: R$ " + vendasTotal + "\n");
	}

}