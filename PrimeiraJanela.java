package minicurso;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class PrimeiraJanela {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Minha primeira janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.add(new JLabel("Hello, Swing World!"));
		janela.setVisible(true);
	}

}