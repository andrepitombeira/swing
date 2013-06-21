package minicurso2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class JSlideDemo {
	public static void main(String[] args) {
		
		JFrame frame  = new JFrame("JanelaDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);	
		SlidePanel animator = new SlidePanel();
    
        //Add content to the window.
        frame.add(animator, BorderLayout.CENTER);

	}
}

class SlidePanel extends JPanel implements ChangeListener {
	
	static final int TEMP_MIN = 0;
	static final int TEMP_MAX = 100;
	static final int TEMP_INIT = 25;
	
	private JSlider celsius, farenheit;
	
	public int celsius2farenheit(int celsius){
		return (9*celsius+160)/5;
	}
	
	public int farenheit2celsius(int farenheit){
		return (5*farenheit-160)/9;
	}
	
	public SlidePanel(){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel slideLabel1 = new JLabel("Temperatura em Celsius", JLabel.CENTER);
		slideLabel1.setAlignmentX(CENTER_ALIGNMENT);
		
		
        celsius = new JSlider(JSlider.HORIZONTAL,
                                              TEMP_MIN, TEMP_MAX, TEMP_INIT);
		
        celsius.setMajorTickSpacing(10);
        celsius.setMinorTickSpacing(5);
        celsius.setPaintLabels(true);
        celsius.setPaintTicks(true);
        Font font = new Font("Serif", Font.ITALIC, 15);
        celsius.setFont(font);
        celsius.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        celsius.addChangeListener(this);
        
        JLabel slideLabel2 = new JLabel("Temperatura em Farenheit", JLabel.CENTER);
		slideLabel2.setAlignmentX(CENTER_ALIGNMENT);
	
		
		
        farenheit = new JSlider(JSlider.HORIZONTAL,
        celsius2farenheit(TEMP_MIN),celsius2farenheit(TEMP_MAX) , celsius2farenheit(TEMP_INIT));
        farenheit.setMajorTickSpacing(10);
        farenheit.setMinorTickSpacing(5);
        farenheit.setPaintLabels(true);
        farenheit.setPaintTicks(true);
        farenheit.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        farenheit.addChangeListener(this);
        
		add(slideLabel1);
		add(celsius);
		
		add(slideLabel2);
		add(farenheit);
		
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		
		
	}

	public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        
        
        
        if (source == celsius){
        	int temp_celsius = source.getValue();
        	farenheit.setValue(celsius2farenheit(temp_celsius));
        }
        
        if (source == farenheit){
        	int temp_farenheit = source.getValue();
        	celsius.setValue(farenheit2celsius(temp_farenheit));
        }
        
        
    }

	
	

}


