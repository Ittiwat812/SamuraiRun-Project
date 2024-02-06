package SamuraiRun;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

import Component.*;
import Component.Button;



public class Start extends MainPanel implements ActionListener,MouseListener,ItemListener {	
	private static final long serialVersionUID = 1L;
	JPanel p = new JPanel();
	JLabel l1 = new JLabel("Samurai Run",JLabel.CENTER);
	JLabel l2 = new JLabel("6422782647 Ittiwat Nimitliupanit",JLabel.CENTER);
    LB samurailb = new LB("Samurai Run",72,405,150,600,100); 
	Button btnStart = new Button("Start", 30,325,390,200,100);
	Button btnClose = new Button("Exit", 30,725,390,200,100);
	LB fn = new LB ("Your name",30,1200,190,200,30);
	TF name = new TF("",20,1200,230,200,30);
	LB time = new LB ("Time",30,1200,270,200,30);
	RB Easy = new RB(" Easy",20,1200,310,200,50);
	RB Normal = new RB(" Normal",20,1200,350,200,50);
	RB Hard = new RB(" Hard",20,1200,390,200,50);
	Start(String title) {
		try { // try maybe exception
		this.setBackground(Color.WHITE); //set background to white
	    this.setBounds(0,0,1500,700); // set bounds
		this.setVisible(true);
		this.setLayout(null); //dertermine my Layout
       
		
		//add all to panel
		p.add(l1); p.add(l2);
		p.setLayout(new GridLayout(2,1));
		p.setBounds(0,611,1500,50);
		this.add(p,BorderLayout.SOUTH);
		this.add(btnStart); 
        this.add(btnClose);
        this.add(fn);
        this.add(name);
        this.add(time);
        this.add(Easy);
        this.add(Normal);
        this.add(Hard);
		this.add(samurailb);
		//add action
		btnStart.addActionListener(this);
		btnClose.addActionListener(this);
		Easy.addItemListener(this);
		Normal.addItemListener(this);
		Hard.addItemListener(this);
		name.addActionListener(this);
		this.addMouseListener(this);
		} catch (Exception e) { // catch exception
			e.printStackTrace();
		 }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Main.name = name.getText();
		if (e.getActionCommand().equals("Start")) {
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
	@Override
	public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == Easy && e.getStateChange() == 1) {
        	Main.speed = 60;
        	Hard.setSelected(false); 
        	Normal.setSelected(false); 
	   }
        if(e.getSource() == Normal && e.getStateChange() == 1) {
        	Main.speed = 80;
        	Easy.setSelected(false);
        	Hard.setSelected(false); 
	   }
        if(e.getSource() == Hard && e.getStateChange() == 1) {
        	Main.speed = 110;
        	Easy.setSelected(false);
        	Normal.setSelected(false);
	   }
  }
}