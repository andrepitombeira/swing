package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class BotaoDemo {
	public static void main(String args[]){
		JanelaBotao janela = new JanelaBotao("FlowLayoutDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaBotao extends JFrame {
	public JanelaBotao(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new FlowLayout());
		Icon iconeSair = new ImageIcon(getClass().getResource("/resources/images/iconExit.png"));
		JButton botaoSair = new JButton("Sair", iconeSair);
		add(botaoSair);
	}
}
