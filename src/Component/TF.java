package Component;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class TF extends JTextField {
	
		private static final long serialVersionUID = 1L;
		
			public TF(String title,int size,int x,int y,int w,int h) {
				 super(title);
				 Font myfont = new Font("SanSerif", Font.BOLD,size);
				 this.setBackground(Color.BLACK);
				 this.setForeground(Color.WHITE);
				 this.setFont(myfont);
				 this.setBounds(x,y,w,h);
			}
	}

