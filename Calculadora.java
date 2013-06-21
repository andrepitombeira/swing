package minicurso;

public class Calculadora {
	public int exp(int a, int b){
		int resultado;
		resultado = 1;
		for(int i = 1; i <= b; i++ )
			resultado *=a;
		return resultado;
	}
}