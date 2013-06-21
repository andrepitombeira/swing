package minicurso;

import javax.swing.JFrame;
import javax.swing.JLabel;

class JanelaTeste extends JFrame {
	public JanelaTeste(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		JLabel rotuloTitulo = new JLabel("Hello, Swing World!");
		add(rotuloTitulo);
	}
}


public class JanelaClasse {
	public static void main(String[] args) {
		JanelaTeste janela = new JanelaTeste("Minha primeira janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}



