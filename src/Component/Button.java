package Component;

import java.awt.*;
import javax.swing.JButton;

public class Button extends JButton{

	private static final long serialVersionUID = 1L;

		public Button(String title,int size,int x,int y,int width,int height) {
			super(title);
			this.setBackground(Color.BLACK); //color of background button
			this.setForeground(Color.white); //color of text
			Font myfont = new Font("SanSerif", Font.BOLD,size);
			this.setFont(myfont);
			this.setBounds(x, y, width, height);
		}
}
