package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;



public class BotaoListenerDemo {
	public static void main(String args[]){
		JanelaListenerDemo janela = new JanelaListenerDemo("FlowLayoutDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaListenerDemo extends JFrame {
	public JanelaListenerDemo(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new FlowLayout());
		JButton botaoClique = new JButton("Clique");
		add(botaoClique);
		
		JanelaListener listener = new JanelaListener();
		botaoClique.addActionListener(listener);
	}
	
	private class JanelaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Vc clicou o botao", "Botao", 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
