package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JanelaRotulosDemo {
	public static void main(String args[]){
		JanelaRotulos janela = new JanelaRotulos("Calculadora");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaRotulos extends JFrame {
	public JanelaRotulos(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		setLayout(new FlowLayout());
		
		setLayout(new FlowLayout());
		setResizable(false);
		setUndecorated(false);
		setAlwaysOnTop(false);
		setBounds(100, 50, 400, 30);
		
		// R�tulo do campo do primeiro número:
		JLabel Label1 = new JLabel("Primeiro n�mero: ");
		Label1.setHorizontalAlignment(JLabel.LEFT);
		Label1.setPreferredSize(new Dimension(380, 30));
		add(Label1);
		
		// R�tulo do campo do segundo número:
		JLabel Label2 = new JLabel("Segundo n�mero: ");
		Label2.setHorizontalAlignment(JLabel.LEFT);
		Label2.setPreferredSize(new Dimension(380, 30));
		add(Label2);
		
		// R�tulo do campo do resultado:
		JLabel Label3 = new JLabel("Resultado: ");
		Label3.setHorizontalAlignment(JLabel.LEFT);
		Label3.setPreferredSize(new Dimension(380, 50));
		add(Label3);

	}
}
