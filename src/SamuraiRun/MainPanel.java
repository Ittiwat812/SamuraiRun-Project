package SamuraiRun;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel{ // set Panel
	private static final long serialVersionUID = 1L;	
	public MainPanel(){
			super();
			this.setBounds(0,0,1500,700); // size of Panel
			this.setLayout(new BorderLayout()); // set to center 
			this.setFocusable(true); // focus to window 
		}
	protected void removeContent() { // remove Start form Frame 
		this.removeAll();
		this.repaint(); 
	}
}
