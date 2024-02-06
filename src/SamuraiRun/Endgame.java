package SamuraiRun;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


import Component.LB;
import Component.Button;



public class Endgame extends MainPanel implements ActionListener,MouseListener {	
	
	private static final long serialVersionUID = 1L; //a universal version identifier for a Serializable class.
	public long point;
	public Endgame(long point, ActionListener main) {
		try {
	    this.point = point;
		this.setBackground(Color.WHITE);
	    this.setBounds(0,0,1500,700);
		this.setVisible(true);
		this.setLayout(null); 
        
		
        LB samurailb = new LB("GameOver!!!",72,550,200,600,100);
        LB name = new LB("Your name : " + Main.name,30,625,280,700,100);
        LB showPoint = new LB("Your score : "+ this.point,30,625,340,300,100);
		Button btnrestart = new Button("Restart", 30,450,450,200,100);
		Button btnClose = new Button("Exit", 30,850,450,200,100);
		
		this.add(btnrestart);
        this.add(btnClose);
        this.add(showPoint);
		this.add(samurailb);
		this.add(name);
		btnrestart.addActionListener(this);
		btnClose.addActionListener(this);
		this.addMouseListener(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Restart")) {
			    removeContent(); 
				Main main = new Main(); // create main
				this.add(main); // add main to Frame
				main.requestFocus(); // Focus to Frame
		}
	  else if(e.getActionCommand().equals("Exit")) {
		     System.exit(0); //close the frame
	   }
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 1 ) {
			Random rand = new Random(); // create random
			int r = rand.nextInt(256); // random color 1 - 256
			int g = rand.nextInt(256);
			int b = rand.nextInt(256);
			this.setBackground(new Color(r,g,b));
		}	
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
