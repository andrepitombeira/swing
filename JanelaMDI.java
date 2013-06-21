/*
 * JanelaMenus.java
 *
 * Created on 8 de Setembro de 2006, 20:21
 */

package minicurso2;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;



/**
 *
 * @author  vitor
 */
public class JanelaMDI extends javax.swing.JFrame {
    private static final int INCR = 15;
    private int posX = 0;
    private int posY = 0;
    
    /** Creates new form JanelaMenus */
    public JanelaMDI() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemNovo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        itemSobre = new javax.swing.JMenuItem();
        itemAjuda = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        itemSair = new javax.swing.JMenuItem();
        menuJanelas = new javax.swing.JMenu();
        menuCascata = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Janela MDI");
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        menuArquivo.setMnemonic('A');
        menuArquivo.setText("Arquivo");
        itemNovo.setMnemonic('N');
        itemNovo.setText("Nova janela");
        itemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNovoActionPerformed(evt);
            }
        });

        menuArquivo.add(itemNovo);

        menuArquivo.add(jSeparator4);

        itemSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconAbout.png")));
        itemSobre.setMnemonic('S');
        itemSobre.setText("Sobre...");
        itemSobre.setToolTipText("Sobre esta aplica\u00e7\u00e3o.");
        menuArquivo.add(itemSobre);

        itemAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconHelp.png")));
        itemAjuda.setMnemonic('A');
        itemAjuda.setText("Ajuda...");
        itemAjuda.setToolTipText("Abre a ajuda do programa.");
        menuArquivo.add(itemAjuda);

        menuArquivo.add(jSeparator1);

        itemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconExit.png")));
        itemSair.setMnemonic('r');
        itemSair.setText("Sair");
        itemSair.setToolTipText("Termina o programa.");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });

        menuArquivo.add(itemSair);

        menuBar.add(menuArquivo);

        menuJanelas.setMnemonic('J');
        menuJanelas.setText("Janelas");
        menuCascata.setMnemonic('c');
        menuCascata.setText("Em cascata");
        menuCascata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCascataActionPerformed(evt);
            }
        });

        menuJanelas.add(menuCascata);

        menuBar.add(menuJanelas);

        setJMenuBar(menuBar);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-600)/2, (screenSize.height-400)/2, 600, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCascataActionPerformed(java.awt.event.ActionEvent evt) {
        int x = 0, y = 0;
        int larguraDesktop = desktopPane.getWidth();
        int alturaDesktop = desktopPane.getHeight();
        int largura = larguraDesktop / 2;
        int altura = alturaDesktop / 2;
        
        for (JInternalFrame janela : desktopPane.getAllFrames()) {
            // Ignora janelas minimizadas.
            if (! janela.isIcon()) {
                try {
                    // Retira do estado maximizado e redimensiona.
                    janela.setMaximum(false);
                    janela.reshape(x, y, largura, altura);
                    x += INCR;
                    y += INCR;
                    
                    // Verifica se passou do ponto.
                    if ((x + largura > larguraDesktop) || 
                    	(y + altura > alturaDesktop)) 
                    	x = y = 0;
                    
                    // Seleciona a janela.
                    janela.setSelected(true);
                }
                catch (PropertyVetoException e) { /* Ignora esta janela. */ }
            }
        }
    }//GEN-LAST:event_menuCascataActionPerformed

    private void itemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNovoActionPerformed
        final MyInternalFrame janela = new MyInternalFrame();
       
        janela.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        
        // Determina tamanho e posição.
        janela.pack();
        janela.reshape(posX, posY, janela.getWidth(), janela.getHeight());
        
        // Altera o ícone.
        Icon icone = new ImageIcon(getClass().getResource("/resources/images/colorBlue.png"));
        janela.setFrameIcon(icone);
        
        // Adiciona e exibe.
        desktopPane.add(janela);
        posX += INCR; posY += INCR;
        janela.setVisible(true);
        
        // Seleciona a nova janela.
        try { janela.setSelected(true); }
        catch (PropertyVetoException e) { /* Desiste da seleção. */ }
        
        
        // Adiciona uma verificação de fechamento da janela.
        janela.addVetoableChangeListener(new VetoableChangeListener() {
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                if ("closed".equals(evt.getPropertyName()) && (Boolean.TRUE.equals(evt.getNewValue()))) {
                    int resposta = JOptionPane.showInternalConfirmDialog(janela, "Tem certeza que deseja fechar?", "Fechar?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resposta == JOptionPane.YES_OPTION) return;
                    else throw new PropertyVetoException("Usuário cancelou o fechamento da janela.", evt);
                }
            }
        });
    }//GEN-LAST:event_itemNovoActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemSairActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JanelaMDI janela = new JanelaMDI();
        janela.setSize(600, 600);
        janela.setVisible(true);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemAjuda;
    private javax.swing.JMenuItem itemNovo;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSobre;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCascata;
    private javax.swing.JMenu menuJanelas;
    // End of variables declaration//GEN-END:variables
    
}
