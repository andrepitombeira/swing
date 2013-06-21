package minicurso;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class JPanelJava2D {
	public static void main(String[] args) {
		JanelaPanel2D janela = new JanelaPanel2D("Minha primeira janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}



class painel2D extends JPanel{
	private boolean desenho;
	public painel2D(){
		super();
		initComponents();
	}
	public void initComponents(){
			desenho = true;
			repaint();
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);	// Essencial!
		if(desenho){
		g.setColor(Color.GREEN);
		g.drawLine(20, 20, 100, 100);
		g.setColor(Color.BLUE);
		g.fillRect(20, 20, 20, 20);
		g.setColor(Color.RED);
		g.drawOval(50, 50, 20, 30);
		g.setColor(Color.YELLOW);
		g.drawRect(100, 100, 50, 50);
		}
	}
	public void limpar() {
		desenho = false;
		repaint();
	}
}

class JanelaPanel2D extends JFrame{
	private painel2D painel;
	private JLabel teclastatus;
	public JanelaPanel2D(String titulo) {
		super(titulo);
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout());
		painel = new painel2D();
		add(painel, BorderLayout.CENTER);
		
		teclastatus = new JLabel("Status do teclado");
		add(teclastatus, BorderLayout.PAGE_END);
		
		TecladoListener listener = new TecladoListener();
		addKeyListener(listener);
	}
	private class TecladoListener implements KeyListener{
		public void keyPressed(KeyEvent e) {
			
			teclastatus.setText("Tecla Pressionada :" + e.getKeyChar());
			if (e.getKeyCode() == KeyEvent.VK_L) {
				if ((e.getModifiers() & KeyEvent.CTRL_MASK) > 0)
				  painel.limpar();
			}
		}
	}
	
}