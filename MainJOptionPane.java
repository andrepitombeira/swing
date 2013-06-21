package minicurso;

import javax.swing.JOptionPane;

public class MainJOptionPane {
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		int opcao = JOptionPane.YES_OPTION;
		
		while (opcao == JOptionPane.YES_OPTION) {
			String xs = JOptionPane.showInputDialog("Informe o 1o número:");
			String yx = JOptionPane.showInputDialog("Informe o 2o número:");
			
			int x = Integer.parseInt(xs);
			int y = Integer.parseInt(yx);
			int exp = calc.exp(x, y);
			
			JOptionPane.showMessageDialog(null, "O EXP é " + exp, "Resultado", 
					JOptionPane.INFORMATION_MESSAGE);
			opcao = JOptionPane.showConfirmDialog(null, "Deseja calcular outro EXP?", 
					"Continuar?", JOptionPane.YES_NO_OPTION);
		}
	}
}
