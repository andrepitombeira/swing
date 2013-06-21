package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;


public class NullLayoutDemo {

	public static void main(String args[]){
		JanelaNull janela = new JanelaNull("NullLayoutDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaNull extends JFrame {
	public JanelaNull(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(null);
		
		JButton b1 = new JButton("Botao 1");
		
		add(b1);
		
		b1.setBounds(100, 100, 100, 100);
		
	}
}
