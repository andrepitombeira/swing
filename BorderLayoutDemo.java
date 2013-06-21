package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;


public class BorderLayoutDemo {

	public static void main(String args[]){
		JanelaBorder janela = new JanelaBorder("BorderLayoutDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaBorder extends JFrame {
	public JanelaBorder(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new BorderLayout());
		
		JButton b1 = new JButton("PAGE START");
		JButton b2 = new JButton("PAGE END");
		JButton b3 = new JButton("LEFT");
		JButton b4 = new JButton("RIGHT");
		JButton b5 = new JButton("CENTER");
		
		add(b1, BorderLayout.PAGE_START);
		add(b2, BorderLayout.PAGE_END);
		add(b3, BorderLayout.LINE_START);
		add(b4, BorderLayout.LINE_END);
		add(b5, BorderLayout.CENTER);
		
	}
}
