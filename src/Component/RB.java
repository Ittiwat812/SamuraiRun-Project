package Component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

public class RB extends JRadioButton {
	
	private static final long serialVersionUID = 1L;

	  public RB(String title,int size,int x,int y,int w,int h) {
		 super(title);
		 Font myfont = new Font("SanSerif", Font.BOLD,size);
		 this.setFont(myfont);
		 this.setBackground(Color.BLACK);
		 this.setForeground(Color.WHITE);
		 this.setBounds(x,y,w,h);
	}
}
