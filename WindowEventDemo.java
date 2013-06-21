package minicurso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class WindowEventDemo extends JFrame {
		
	
	public static void main(String args[]){
		EventWindow frame = new EventWindow("WindowEventDemo");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

class EventWindow extends JFrame{
	
	private JTextArea display;
	private char newline = 	'\n';
    private char space = ' ';
	
	public EventWindow(String name){
		super(name);
		addComponents();
	}
	
	void displayMessage(String msg) {
        display.append(msg + '\n');
        System.out.println(msg);
    }

	
	public void addComponents(){
		setLayout(new BorderLayout());
		
		display = new JTextArea();
        display.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(500, 450));
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        this.addWindowListener( new WindowAdapter(){
        	public void windowOpened(WindowEvent e){
                displayMessage("WindowListener method called: windowOpened.");
            }
        	public void windowActivated(WindowEvent e) {
                displayMessage("WindowListener method called: windowActivated.");
            }
        	public void windowClosed(WindowEvent e) {
                //This will only be seen on standard output.
                displayMessage("WindowListener method called: windowClosed.");
                
        	}
        	public void windowDeactivated(WindowEvent e) {
                displayMessage("WindowListener method called: windowDeactivated.");
            }

        	public void windowIconified(WindowEvent e) {
                displayMessage("WindowListener method called: windowIconified.");
            }

            public void windowDeiconified(WindowEvent e) {
                displayMessage("WindowListener method called: windowDeiconified.");
            }
        });
        
        addWindowFocusListener( new WindowAdapter(){
        	public void windowGainedFocus(WindowEvent e) {
                displayMessage("WindowFocusListener method called: windowGainedFocus.");
            }

            public void windowLostFocus(WindowEvent e) {
                displayMessage("WindowFocusListener method called: windowLostFocus.");
            }
        });
        
        addWindowStateListener(new WindowAdapter(){
        	public void windowStateChanged(WindowEvent e) {
                displayStateMessage(
                  "WindowStateListener method called: windowStateChanged.", e);
            }

        });
        
	}
    String convertStateToString(int state) {
        if (state == Frame.NORMAL) {
            return "NORMAL";
        }
        String strState = " ";
        if ((state & Frame.ICONIFIED) != 0) {
            strState += "ICONIFIED";
        }
        //MAXIMIZED_BOTH is a concatenation of two bits, so
        //we need to test for an exact match.
        if ((state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
            strState += "MAXIMIZED_BOTH";
        } else {
            if ((state & Frame.MAXIMIZED_VERT) != 0) {
                strState += "MAXIMIZED_VERT";
            }
            if ((state & Frame.MAXIMIZED_HORIZ) != 0) {
                strState += "MAXIMIZED_HORIZ";
            }
            if (" ".equals(strState)){
                strState = "UNKNOWN";
            }
        }
        return strState.trim();
    }

    void displayStateMessage(String prefix, WindowEvent e) {
        int state = e.getNewState();
        int oldState = e.getOldState();
        String msg = prefix+ newline + space
                   + "New state: "+ convertStateToString(state)
                   + newline + space
                   + "Old state: "
                   + convertStateToString(oldState);
        displayMessage(msg);
    }
     
}