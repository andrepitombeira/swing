package minicurso;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;



public class CheckBoxDemo {
	public static void main(String args[]){
		JanelaCheckBox janela = new JanelaCheckBox("CheckBoxDemo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaCheckBox extends JFrame implements ItemListener{
	
	private JCheckBox c1,c2;
	private JTextArea t1;
	
	private int negrito;
	private int italico;
	
	public JanelaCheckBox(String titulo)  {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setLayout(new FlowLayout());
		
		t1 = new JTextArea(5,30);
		t1.setFont(new Font("Serif", Font.PLAIN, 16));
		add(t1);
		
		c1 = new JCheckBox("Negrito");
		c1.setSelected(false);
		c1.addItemListener(this);
		add(c1);
		
		c2 = new JCheckBox("Italico");
		c2.setSelected(false);
		c2.addItemListener(this);
		add(c2);
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == c1) negrito = c1.isSelected() ? Font.BOLD : Font.PLAIN;
		if (e.getSource() == c2) italico = c2.isSelected() ? Font.ITALIC : Font.PLAIN;
		Font fonte = t1.getFont();
		t1.setFont(fonte.deriveFont(negrito + italico));
	}
	
}
