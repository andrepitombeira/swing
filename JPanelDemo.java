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
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class JPanelDemo {
	public static void main(String[] args) {
		JanelaPanel janela = new JanelaPanel("Minha primeira janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class PainelDesenho extends JPanel {
	private Set<Point> pontos = new HashSet<Point>();
	
	public PainelDesenho(){
		super();
	}
	
	public void adicionarPonto(Point p){
		pontos.add(p);
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);	// Essencial!
		for (Point p : pontos) g.fillOval(p.x, p.y, 10, 10);
	}
	public void limpar() {
		pontos.clear();
		repaint();
	}
}

class JanelaPanel extends JFrame {
	private PainelDesenho painelMouse;
	private JLabel rotuloStatus;
	
	public JanelaPanel(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		// Rótulo que captura os eventos do mouse:
		painelMouse = new PainelDesenho();
		painelMouse.setBackground(Color.RED);
		add(painelMouse, BorderLayout.CENTER);
		
		// Rótulo do rodapé.
		rotuloStatus = new JLabel("");
		add(rotuloStatus, BorderLayout.PAGE_END);
				
		
		
		// Cria e adiciona o ouvinte.
		MeuListener listener = new MeuListener();
		painelMouse.addMouseListener(listener);
		painelMouse.addMouseMotionListener(listener);
	}
	
	private class MeuListener implements MouseInputListener {
		public void mouseClicked(MouseEvent e) {
			rotuloStatus.setText("Clique em (" + e.getX() + ", " + e.getY() + ")");
			painelMouse.adicionarPonto(e.getPoint());
		}

		public void mouseEntered(MouseEvent e) {
			painelMouse.setBackground(Color.GREEN);		
		}

		public void mouseExited(MouseEvent e) {
			rotuloStatus.setText("");
			painelMouse.setBackground(Color.RED);	
		}

		public void mousePressed(MouseEvent e) {
			rotuloStatus.setText("Pressionado em (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mouseReleased(MouseEvent e) {
			rotuloStatus.setText("Liberado em (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mouseDragged(MouseEvent e) {
			rotuloStatus.setText("Arrastado em (" + e.getX() + ", " + e.getY() + ")");
			painelMouse.adicionarPonto(e.getPoint());
		}

		public void mouseMoved(MouseEvent e) {
			rotuloStatus.setText("Movimento em (" + e.getX() + ", " + e.getY() + ")");
		}
	}
}