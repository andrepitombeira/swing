package minicurso;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainTesteCombobox {
	public static void main(String[] args) {
		JanelaTesteCombobox janela = new JanelaTesteCombobox("Teste de JComboBox");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(550, 550);
		janela.setVisible(true);
	}
}

class JanelaTesteCombobox extends JFrame {
	// Nomes das imagens.
	private static String[] imagens = new String[] {
		"",
		"/resources/imagem/jackson5.jpg",
		"/resources/imagem/offthewall.jpg",
		"/resources/imagem/thriller.jpg",
		"/resources/imagem/bad.jpg",
		"/resources/imagem/dangerous.jpg",
		"/resources/imagem/invincible.jpg"
	};
	
	public JanelaTesteCombobox(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setResizable(false);
		
		// Rótulo de título.
		JLabel rotuloTitulo = new JLabel("Discos do Michael Jackson");
		rotuloTitulo.setHorizontalAlignment(JLabel.CENTER);
		rotuloTitulo.setFont(rotuloTitulo.getFont().deriveFont(20f));
		add(rotuloTitulo, BorderLayout.PAGE_START);
		
		// Rótulo que exibirá as imagens.
		final JLabel rotuloImagem = new JLabel();
		rotuloImagem.setHorizontalAlignment(JLabel.CENTER);
		add(rotuloImagem, BorderLayout.CENTER);
		
		// Caixa de combinação que conterá imagens possíveis.
		final JComboBox comboImagens = new JComboBox(imagens);
		comboImagens.setMaximumRowCount(3);
		comboImagens.setEditable(true);
		add(comboImagens, BorderLayout.PAGE_END);
		
		// Adiciona o ouvinte.
		comboImagens.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String imagem = comboImagens.getSelectedItem().toString();
				URL url = getClass().getResource(imagem);
				rotuloImagem.setIcon((url == null) ? null : new ImageIcon(url));
			}
		});
	}
}