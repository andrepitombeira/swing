package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JanelaTextFieldDemo {
	public static void main(String args[]){
		JanelaTextField janela = new JanelaTextField("Calculadora");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaTextField extends JFrame {
	public JanelaTextField(String titulo) {
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
		
		//R�tulo do primeiro n�mero
		JLabel rotuloNum1 = new JLabel("Primeiro n�mero: ");
		rotuloNum1.setHorizontalAlignment(JLabel.RIGHT);
		rotuloNum1.setPreferredSize(new Dimension(200, 30));
		add(rotuloNum1);
		
		// Campo do primeiro n�mero:
		JTextField textoNum1 = new JTextField("1");
		textoNum1.setHorizontalAlignment(JTextField.RIGHT);
		textoNum1.setPreferredSize(new Dimension(180, 20));
		add(textoNum1);
		
		// R�tulo do  segundo n�mero:
		JLabel rotuloNum2 = new JLabel("Segundo n�mero: ");
		rotuloNum2.setHorizontalAlignment(JLabel.RIGHT);
		rotuloNum2.setPreferredSize(new Dimension(200, 30));
		add(rotuloNum2);
		
		// Campo do segundo n�mero:
		JTextField textoNum2 = new JTextField("1");
		textoNum2.setHorizontalAlignment(JTextField.RIGHT);
		textoNum2.setPreferredSize(new Dimension(180, 20));
		add(textoNum2);
		
		// R�tulo do campo do resultado:
		JLabel rotuloResultado = new JLabel("Resultado = ");
		rotuloResultado.setHorizontalAlignment(JLabel.RIGHT);
		rotuloResultado.setPreferredSize(new Dimension(200, 50));
		add(rotuloResultado);
		
		// Campo do resultado:
		JTextField textoResultado = new JTextField("1");
		textoResultado.setHorizontalAlignment(JTextField.RIGHT);
		textoResultado.setPreferredSize(new Dimension(180, 20));
		textoResultado.setEditable(false);
		add(textoResultado);
		
	}
}
