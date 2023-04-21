import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Para calcular a area e o perimetro do retangulo");
		
		System.out.println("Digite a base:");
		float base = input.nextFloat();
		
		System.out.println("Digite a altura:");
		float altura = input.nextFloat();
		
		System.out.println("Area: " + base * altura);
		System.out.println("Perimetro: " + 2*(base + altura));

	}

}
