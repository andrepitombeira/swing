package minicurso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class SlideDemo2 {
	public static void main(String[] args) {
		
		JFrame frame  = new JFrame("JanelaDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);	
		SlidePanel2 animator = new SlidePanel2();
    
        //Add content to the window.
        frame.add(animator, BorderLayout.CENTER);

	}
}

class CirclePanel extends JPanel{
	
	private int xc,yc,r;
	
	public CirclePanel(int x,int y, int r){
		super();
		this.xc = x;
		this.yc = y;
		this.r = r;

	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);	// Essencial!
		g.setColor(Color.BLUE);
		g.drawOval(xc,yc,r,r);
	
	}
	
	public void setDiameter(int diameter){
		this.r = diameter/2;
		repaint();
	}
	
}

class SlidePanel2 extends JPanel implements ChangeListener {
	
	static final int MIN = 0;
	static final int MAX = 500;
	static final int INIT = 50;
	
	private JSlider s;
	private CirclePanel c;
	
	public SlidePanel2(){
		
		setLayout(new BorderLayout());
		
		s = new JSlider(JSlider.HORIZONTAL,MIN, MAX,INIT);
		
        s.setMajorTickSpacing(50);
        s.setMinorTickSpacing(25);
        s.setPaintLabels(true);
        s.setPaintTicks(true);
        s.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        s.addChangeListener(this);
        
        c = new CirclePanel(100,100,50);
		
		
        add(s,BorderLayout.PAGE_START);
        add(c,BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		
		
	}

	public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
         
        if( source == s){
        	c.setDiameter(source.getValue());
        }
        
    }

	
	

}


