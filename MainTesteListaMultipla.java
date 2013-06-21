package minicurso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainTesteListaMultipla {
	public static void main(String[] args) {
		JanelaTesteListaMultipla janela = new JanelaTesteListaMultipla("Teste de JList");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(550, 550);
		janela.setVisible(true);
	}
}

class JanelaTesteListaMultipla extends JFrame {
	
	// Cores.
	private static Map<String, Color> cores = new HashMap<String, Color>();
	static {
		cores.put("Preto", Color.BLACK);
		cores.put("Branco", Color.WHITE);
		cores.put("Azul", Color.BLUE);
		cores.put("Vermelho", Color.RED);
		cores.put("Amarelo", Color.YELLOW);
		cores.put("Verde", Color.GREEN);
	}
	
	public JanelaTesteListaMultipla(String titulo) {
		super(titulo);
		initComponents();
	}
	private void initComponents() {
		// Lista de cores.
		final JList listaCores = new JList(cores.keySet().toArray());
		listaCores.setVisibleRowCount(6);
		listaCores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(listaCores), BorderLayout.PAGE_START);
		
		// Adiciona um ouvinte à lista.
		listaCores.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int r = 0, g = 0, b = 0;
				Object[] selecao = listaCores.getSelectedValues();
				
				if (selecao.length > 0) {
					// Tira a média aritmética dos valores de r, g e b.
					for (int i = 0; i < selecao.length; i++) {
						Color cor = cores.get(selecao[i]);
						r += cor.getRed();
						g += cor.getGreen();
						b += cor.getBlue();
					}
					r /= selecao.length;
					g /= selecao.length;
					b /= selecao.length;
				}
				
				getContentPane().setBackground(new Color(r, g, b));
			}
		});
	}
}