package minicurso;

import minicurso.Calculadora;
import java.util.Scanner;

public class Console {
	public static void main(String [] args){
		Calculadora calc = new Calculadora();
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com um n�mero:");
		int x = sc.nextInt();
		System.out.println("Entre com um n�mero:");
		int y = sc.nextInt();
		int exp = calc.exp(x, y);
		System.out.println( x + " ^ " + y + " = " + exp);
		
	}
}




