package minicurso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.URL;
import javax.swing.ImageIcon;


public class MenuLookDemo {
	public static void main(String[] args) {
		
		MenuLook frame  = new MenuLook("MenuDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);	
		
	}
}

class MenuLook extends JFrame implements ActionListener, ItemListener {
	
	JTextArea output;
    JScrollPane scrollPane;
    String newline = "\n";

	
	public MenuLook(String name){
		 	super(name);
		
			JMenuBar menuBar;
	        JMenu menu, submenu;
	        JMenuItem menuItem;
	        JRadioButtonMenuItem rbMenuItem;
	        JCheckBoxMenuItem cbMenuItem;

	        JPanel contentPane = new JPanel(new BorderLayout());
	        contentPane.setOpaque(true);

	        //Create a scrolled text area.
	        output = new JTextArea(5, 30);
	        output.setEditable(true);
	        scrollPane = new JScrollPane(output);

	        //Add the text area to the content pane.
	        contentPane.add(scrollPane, BorderLayout.CENTER);

	        setContentPane(contentPane);
	        
	        
	        //Create the menu bar.
	        menuBar = new JMenuBar();

	        //Build the first menu.
	        menu = new JMenu("A Menu");
	        menu.setMnemonic(KeyEvent.VK_A);
	        menu.getAccessibleContext().setAccessibleDescription(
	                "The only menu in this program that has menu items");
	        menuBar.add(menu);

	        //a group of JMenuItems
	        menuItem = new JMenuItem("A text-only menu item",
	                                 KeyEvent.VK_T);
	        menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
	        menuItem.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_1, ActionEvent.ALT_MASK));
	        menuItem.getAccessibleContext().setAccessibleDescription(
	                "This doesn't really do anything");
	        menuItem.addActionListener(this);
	        menu.add(menuItem);

	        URL url = getClass().getResource("/resources/imagem/middle.gif");
	        ImageIcon icon = new ImageIcon(url);
	        menuItem = new JMenuItem("Both text and icon", icon);
	        menuItem.setMnemonic(KeyEvent.VK_B);
	        menuItem.addActionListener(this);
	        menu.add(menuItem);

	        menuItem = new JMenuItem(icon);
	        menuItem.setMnemonic(KeyEvent.VK_D);
	        menuItem.addActionListener(this);
	        menu.add(menuItem);

	        //a group of radio button menu items
	        menu.addSeparator();
	        ButtonGroup group = new ButtonGroup();

	        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
	        rbMenuItem.setSelected(true);
	        rbMenuItem.setMnemonic(KeyEvent.VK_R);
	        group.add(rbMenuItem);
	        rbMenuItem.addActionListener(this);
	        menu.add(rbMenuItem);

	        rbMenuItem = new JRadioButtonMenuItem("Another one");
	        rbMenuItem.setMnemonic(KeyEvent.VK_O);
	        rbMenuItem.addActionListener(this);
	        group.add(rbMenuItem);
	        
	        menu.add(rbMenuItem);

	        //a group of check box menu items
	        menu.addSeparator();
	        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
	        cbMenuItem.setMnemonic(KeyEvent.VK_C);
	        cbMenuItem.addItemListener(this);
	        menu.add(cbMenuItem);

	        cbMenuItem = new JCheckBoxMenuItem("Another one");
	        cbMenuItem.setMnemonic(KeyEvent.VK_H);
	        menu.add(cbMenuItem);

	        //a submenu
	        menu.addSeparator();
	        submenu = new JMenu("A submenu");
	        submenu.setMnemonic(KeyEvent.VK_S);

	        menuItem = new JMenuItem("An item in the submenu");
	        menuItem.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_2, ActionEvent.ALT_MASK));
	        submenu.add(menuItem);

	        menuItem = new JMenuItem("Another item");
	        submenu.add(menuItem);
	        menu.add(submenu);

	        //Build second menu in the menu bar.
	        menu = new JMenu("Another Menu");
	        menu.setMnemonic(KeyEvent.VK_N);
	        menu.getAccessibleContext().setAccessibleDescription(
	                "This menu does nothing");
	        menuBar.add(menu);

	        setJMenuBar(menuBar);
	        
	        //Create the popup menu.
	        JPopupMenu popup = new JPopupMenu();
	        menuItem = new JMenuItem("A popup menu item");
	        //menuItem.addActionListener(this);
	        popup.add(menuItem);
	        menuItem = new JMenuItem("Another popup menu item");
	        //menuItem.addActionListener(this);
	        popup.add(menuItem);

	        //Add listener to the text area so the popup menu can come up.
	        MouseListener popupListener = new PopupListener(popup);
	        output.addMouseListener(popupListener);


	}
	
	public void displayMessage(String msg){
		output.append(msg + newline);
		System.out.println(msg);
	}
	
	class PopupListener extends MouseAdapter {
        JPopupMenu popup;

        PopupListener(JPopupMenu popupMenu) {
            popup = popupMenu;
        }

        public void mousePressed(MouseEvent e) {
            displayMessage("Mouse Pressionado");
        	maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            displayMessage("Mouse Liberado");
        	maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
        	displayMessage("Mostrando Popup");
        	if (e.isPopupTrigger()) {
                popup.show(e.getComponent(),
                           e.getX(), e.getY());
            }
        }
    }

	// Returns just the class name -- no package info.
    protected String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex+1);
    }


	
	 public void actionPerformed(ActionEvent e) {
	        JMenuItem source = (JMenuItem)(e.getSource());
	        String s = "Action event detected."
	                   + newline
	                   + "    Event source: " + source.getText()
	                   + " (an instance of " + getClassName(source) + ")";
	        output.append(s + newline);
	        output.setCaretPosition(output.getDocument().getLength());
	    }

    public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Item event detected."
                   + newline
                   + "    Event source: " + source.getText()
                   + " (an instance of " + getClassName(source) + ")"
                   + newline
                   + "    New state: "
                   + ((e.getStateChange() == ItemEvent.SELECTED) ?
                     "selected":"unselected");
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }



}


