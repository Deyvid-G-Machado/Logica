import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Para calcular a area e o perimetro do quadrado");
		
		System.out.println("Digite o valor da base/altura:");
		double lado = input.nextDouble();
		
		System.out.println("\nArea: " + (lado * lado));
		//System.out.println("Area: " + Math.pow(lado,2));		// Poderia ser usado assim também
		System.out.println("Perimetro: " + (4 * lado));
		
	}

}