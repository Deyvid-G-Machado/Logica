import java.util.Scanner;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class exercicioFor {

	public static void main(String[] args) throws ParseException{
		Scanner input = new Scanner(System.in);
		MaskFormatter mf = new MaskFormatter("###.###.###-##");
		mf.setValueContainsLiteralCharacters(false);
		
		System.out.println("Quantidade de usuarios:");
		int qtUsuarios = input.nextInt();
		
		String usuarios[][] = new String[qtUsuarios][4];
		int numUsuario = 1;
		
		for (int i = 0; i < usuarios.length; i++) {
			System.out.println("\nCadastro do usuario " + numUsuario + ":");
			
			System.out.println("Nome:");
			usuarios[i][0] = input.next();
			
			System.out.println("CPF:");
			usuarios[i][1] = input.next();
			
			System.out.println("Cidade:");
			usuarios[i][2] = input.next();
			
			System.out.println("Profissao:");
			usuarios[i][3] = input.next();
			
			numUsuario++;
		}
		numUsuario = 1;
		
		// Exibição de dados
		System.out.println("Lista de usuarios:");
		for (int i = 0; i < usuarios.length; i++) {
			System.out.println("\nDados do usuario " + numUsuario + ":");
			System.out.println("Nome: " + usuarios[i][0]);
			System.out.println("CPF: " + mf.valueToString(usuarios[i][1]));
			System.out.println("Cidade: " + usuarios[i][2]);
			System.out.println("Profissao: " + usuarios[i][3]);
			numUsuario++;
		}

	}

}