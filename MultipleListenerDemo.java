package minicurso;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;



public class MultipleListenerDemo {
	public static void main(String args[]){
		JanelaMultipleListener janela = new JanelaMultipleListener("FlowLayoutDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaMultipleListener extends JFrame {
	
	JButton b1,b2;
	JTextArea t1;
	
	public JanelaMultipleListener(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new FlowLayout());
		
		JanelaListener listener = new JanelaListener();
		
		t1 = new JTextArea(5,35);
		add(t1);
		
		b1 = new JButton("Hello World");
		b1.addActionListener(listener);
		add(b1);
		
		b2 = new JButton("Ola Mundo");
		b2.addActionListener(listener);
		add(b2);
	}
	
	private class JanelaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
				if( e.getSource() == b1 )
					t1.append("Hello World" + '\n');
				if( e.getSource() == b2)
					t1.append("Ola Mundo "  + '\n');
		}
	}
}
