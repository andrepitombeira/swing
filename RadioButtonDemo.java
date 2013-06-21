package minicurso;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;



public class RadioButtonDemo {
	public static void main(String args[]){
		JanelaRadioButton janela = new JanelaRadioButton("RadioButtonDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(500, 400);
		janela.setVisible(true);
	}
}

class JanelaRadioButton extends JFrame implements ItemListener{
	
	private JRadioButton r1,r2,r3,r4;
	private ButtonGroup StyleFont;
	private JTextArea t1;
	

	public JanelaRadioButton(String titulo)  {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new FlowLayout());
		
		t1 = new JTextArea(5,40);
		t1.setFont(new Font("Serif", Font.PLAIN, 16));
		add(t1);
		
		r1 = new JRadioButton("Normal");
		r1.addItemListener(this);
		r1.setSelected(true);
		add(r1);
		
		r2 = new JRadioButton("Negrito");
		r2.addItemListener(this);
		add(r2);
		
		r3 = new JRadioButton("Itálico");
		r3.addItemListener(this);
		add(r3);
		
		r4 = new JRadioButton("Negrito e Itálico");
		r4.addItemListener(this);
		add(r4);
		
		StyleFont = new ButtonGroup();
		StyleFont.add(r1);
		StyleFont.add(r2);
		StyleFont.add(r3);
		StyleFont.add(r4);
		
		
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		Font fonte = t1.getFont();
		
		if (e.getSource() == r1) t1.setFont(fonte.deriveFont(Font.PLAIN));
		if (e.getSource() == r2) t1.setFont(fonte.deriveFont(Font.BOLD));
		if (e.getSource() == r3) t1.setFont(fonte.deriveFont(Font.ITALIC));
		if (e.getSource() == r3) t1.setFont(fonte.deriveFont(Font.BOLD + Font.ITALIC));
		
		
		
	}
	
}
