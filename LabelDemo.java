package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class LabelDemo {
	public static void main(String args[]){
		JanelaLabel janela = new JanelaLabel("LabelDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaLabel extends JFrame {
	public JanelaLabel(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new FlowLayout());
		java.net.URL imgURL = getClass().getResource("/resources/imagem/iconUFC.png");
		ImageIcon iconeSair =  new ImageIcon(imgURL, "Logo UFC");
		JLabel rotulo = new JLabel("Universidade Federal do Ceara", iconeSair, SwingConstants.CENTER);
		rotulo.setHorizontalTextPosition(SwingConstants.CENTER);
		rotulo.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(rotulo);
		
	}
}
