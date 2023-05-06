import java.util.Scanner;

public class IMC {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Qual seu nome:");
		String nome = input.next();
		
		System.out.println("Digite seu peso em kg:");
		float peso = input.nextFloat();
		
		System.out.println("Digite sua altura em metros:");
		float altura = input.nextFloat();
		
		float imc = peso / (altura * altura);
		
		if (imc < 18.5) {
			System.out.println("Ola "+ nome + " o resultado do seu IMC e magreza");
			
		} else if (imc <= 24.9) {
			System.out.println("Ola "+ nome + " o resultado do seu IMC e normal");
			
		} else if (imc <= 29.9) {
			System.out.println("Ola "+ nome + " o resultado do seu IMC e sobrepeso");
			
		} else if (imc <= 34.9) {
			System.out.println("Ola "+ nome + " o resultado do seu IMC e obesidade grau I");
			
		} else if (imc <= 39.9) {
			System.out.println("Ola" + nome + " o resultado do seu IMC e obesidade grau II");
			
		} else {
			System.out.println("Ola "+ nome + " o resultado do seu IMC e obesidade grau III");
		}
		
		
	}

}