package SamuraiRun;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*; // JFrame

public class Display extends JFrame implements ActionListener{ // create Frame
	
	private static final long serialVersionUID = 1L; //a universal version identifier for a Serializable class.
	private Dimension size = new Dimension(1500,700); // determine size
	
	public Display() {
		renew(); // set newframe
		this.getContentPane().add(new Start(getTitle())); // add Start class
	}
	
	private void renew () { // for new frame
		this.setSize(size); //set Frame
		this.setTitle("Samurai Run"); // set title of Frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLocation(15,100); // set Location when popup to dektop
		this.setVisible(true);
	}
    private void removeContent() { // remove previous
	    this.getContentPane().removeAll();
	    this.getContentPane().repaint();
}

    protected void endGame(long point) { //endgame and add point 
        removeContent();
	    this.getContentPane().add(new Endgame(point,this));
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) { //if click start button
		    removeContent(); 
			Main main = new Main(); // create main
			this.add(main); // add main to Frame
			main.requestFocus(); // Focus to Frame
	}
 }
}



