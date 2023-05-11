import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DroneVirtual {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<String> historicoVoo = new ArrayList<>();
		
		int eixos[] = new int[2]; // O indice 0 é referente ao eixo X, o indice 1 é referente ao eixo Y
		boolean continuar = true;
		String opcao;
		
		while (continuar) {
			// Escolha de decolagem
			System.out.println("_________| O drone esta pronto! |_________\n"
					+ "Escreva uma das opcaoes a seguir para continuar:\n\n"
					+ "decolar - Para decolar com o drone\n"
					+ "sair - Para finalizar o Drone Virtual");
			opcao = input.next();
			
			if (opcao.equals("decolar")) {
				System.out.println("Drone decolado!");
				while (continuar) {
					System.out.println("\n_______| Controle de voo |_______\n"
							+ "f - frente | t - tras\n"
							+ "d - direita | e - esquerda\n"
							+ "pousar - para pousar");
					opcao = input.next();
					
					// Controle de "movimento"
					switch (opcao) {
					case "f":
						eixos[1]++;
						System.out.println("O drone foi para frente!");
						
						historicoVoo.add("O drone foi para frente (x= " + eixos[0] + ", y= " + eixos[1] + ")");
						break;
					case "t":
						eixos[1]--;
						System.out.println("O drone foi para tras!");
						
						historicoVoo.add("O drone foi para tras (x= " + eixos[0] + ", y= " + eixos[1] + ")");
						break;
					case "d":
						eixos[0]++;
						System.out.println("O drone foi para direita!");
						
						historicoVoo.add("O drone foi para direita (x= " + eixos[0] + ", y= " + eixos[1] + ")");
						break;
					case "e":
						eixos[0]--;
						System.out.println("O drone foi para esquerda!");
						
						historicoVoo.add("O drone foi para esquerda (x= " + eixos[0] + ", y= " + eixos[1] + ")");
						break;
					case "decolar":
						System.out.println("O drone ja esta decolado!");
						break;
					case "pousar":
						System.out.println("\nO drone foi  pousado!");
						
						// Vai listar o historico do voo
						System.out.println("________| Historico de Voo |________");
						for (int i = 0; i < historicoVoo.size(); i++) {
							System.out.println(historicoVoo.get(i));
						}
						System.out.println("\nVoce parou na posicao X= " + eixos[0] +  ", Y= " + eixos[1]);
						
						continuar = false;
						break;

					default:
						System.out.println("Escolha um comando valido!");
						break;
					}
				}
				
				
				
			} else if (opcao.equals("sair")) {
				continuar = false;
			} else {
				System.out.println("Escolha um comando valido!\n");
			}
			
		}
		System.out.println("O drone foi desligado!");
		
	}

}