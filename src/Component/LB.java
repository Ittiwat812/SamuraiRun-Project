package Component;

import java.awt.Font;
import javax.swing.JLabel;

public class LB extends JLabel {

	private static final long serialVersionUID = 1L;
		
		public LB(String title,int size,int x,int y,int w,int h) {
			 super(title);
			 Font myfont = new Font("SanSerif", Font.BOLD,size);
			 this.setFont(myfont);
			 this.setBounds(x,y,w,h);
		}
}
