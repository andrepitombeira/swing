package minicurso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

public class MainTesteEventosMouse {
	public static void main(String[] args) {
		JanelaTesteEventosMouse janela = new JanelaTesteEventosMouse("Minha primeira janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 300);
		janela.setVisible(true);
	}
}

class JanelaTesteEventosMouse extends JFrame {
	private JLabel rotuloMouse;
	private JLabel rotuloStatus;
	
	public JanelaTesteEventosMouse(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		// Rótulo que captura os eventos do mouse:
		rotuloMouse = new JLabel("");
		rotuloMouse.setOpaque(true);
		rotuloMouse.setBackground(Color.RED);
		add(rotuloMouse, BorderLayout.CENTER);
		
		// Rótulo do rodapé.
		rotuloStatus = new JLabel("");
		add(rotuloStatus, BorderLayout.PAGE_END);
		
		// Cria e adiciona o ouvinte.
		MeuListener listener = new MeuListener();
		rotuloMouse.addMouseListener(listener);
		rotuloMouse.addMouseMotionListener(listener);
	}
	
	private class MeuListener implements MouseInputListener {
		public void mouseClicked(MouseEvent e) {
			rotuloStatus.setText("Clique em (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mouseEntered(MouseEvent e) {
			rotuloMouse.setBackground(Color.GREEN);		
		}

		public void mouseExited(MouseEvent e) {
			rotuloMouse.setText("");
			rotuloMouse.setBackground(Color.RED);	
		}

		public void mousePressed(MouseEvent e) {
			rotuloStatus.setText("Pressionado em (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mouseReleased(MouseEvent e) {
			rotuloStatus.setText("Liberado em (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mouseDragged(MouseEvent e) {
			rotuloStatus.setText("Arrastado em (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mouseMoved(MouseEvent e) {
			rotuloStatus.setText("Movimento em (" + e.getX() + ", " + e.getY() + ")");
		}
	}
}