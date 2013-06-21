package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;


public class FlowLayoutDemo {

	public static void main(String args[]){
		JanelaFlow janela = new JanelaFlow("FlowLayoutDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaFlow extends JFrame {
	public JanelaFlow(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Botao 1");
		JButton b2 = new JButton("Botao 2");
		JButton b3 = new JButton("Botao 3");
		JButton b4 = new JButton("Botao 4");
		JButton b5 = new JButton("Botao 5");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
	}
}
