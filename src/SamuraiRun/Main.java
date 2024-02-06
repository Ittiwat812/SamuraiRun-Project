package SamuraiRun;

import java.awt.*; // Color and Graphics
import java.awt.event.*; // KeyListener
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Event.Hit; // import event Hit
import Character.*;  // import Samurai


public class Main extends MainPanel implements KeyListener { 
	
	private static final long serialVersionUID = 1L; //a universal version identifier for a Serializable class.
	
	static int speed = 80; // for trap speed for normal if it no input
	long lastPress; // for delay //(8 byte) integer value time and point
	long point = 0; // for point
	static Display display; //use Display 
	static String name;
	Samurai samurai = new Samurai(50,400,75,170,100); // size of Character
	Trap[] trapsetupper = TrapSetupper(1);// trap upper
	Trap[] trapsetlower = TrapSetlower(1);// trap lower
	
	public Main() {
		// use MainPanel
		this.addKeyListener(this); // add jump and slide 
	}
	@Override
	public void paint(Graphics g) { // create hit block
			super.paint(g); // protect duplicate
			
			//Background
			try {
				this.drawBackground(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Name
			Font myfont = new Font("SanSerif", Font.BOLD,30);
			g.setFont(myfont);
			g.setColor(Color.BLACK);
			g.fillRect(25,65,30,30);
			g.setColor(Color.WHITE);
			g.drawString("N  : " + name,30,90);
			// Point
			g.setColor(Color.white);
			g.drawString(":  "+ point ,1300,40);
			
			//samurai jump
			if (samurai.y <= 400) {
			g.drawImage(samurai.getImage(),samurai.x,samurai.y,samurai.SamuraiWidth,samurai.SamuraiHeight,this); // draw hit block of Samurai
			}
			
			//samurai slide
			if (samurai.y >= 400) {
			g.drawImage(samurai.getImage1(),samurai.x,samurai.y,samurai.SamuraiWidth,samurai.SamuraiHeight,this); // draw hit block of Samurai
			}
			
			//HP
			g.setColor(Color.RED);
			g.drawString(" :  "+ samurai.Healthpoint + "%" ,70,40); //Implicit casting
			//Trap 
	        for(Trap trapdraw : trapsetupper) { //called trap upper 
	        	drawtrap(trapdraw,g);
       }
	        for(Trap trapdraw : trapsetlower) { //called trap Lower
	        	drawtrap(trapdraw,g);
	     
       }
	        this.point += 1; 
	
	        g.setColor(Color.WHITE);
	        g.fillOval(20,10, 40, 40);
	        try {
				g.drawImage(ImageIO.read(new File("Image\\heart.png")),25,17,30,30,this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	        g.setColor(Color.RED);
	        g.fillRect(1250, 15, 30, 30);
	        g.setColor(Color.WHITE);
	        g.drawString("P",1255,40);
}
	
	        private void drawBackground(Graphics g) throws IOException { //draw background
				g.drawImage(ImageIO.read(new File("Image\\BackGround.jpg")),0,0,1500,800,this);
    }
	        private void drawtrap(Trap trap,Graphics g) { //draw trap
	        g.drawImage(trap.getImagetrap(),trap.x,trap.y,trap.width,trap.height,this); 
		    if(Hit.checkHit(samurai,trap)) {//check hit 
		    	g.drawImage(trap.getImageblood(),0,0,1600,800,this);
		    	samurai.Healthpoint -= 20;
		    if(samurai.Healthpoint <= 0) {
		    		display.endGame(this.point); //use endgame and point
					samurai.Healthpoint = new Samurai().Healthpoint;
					this.point = 0;
		    	}
		    }
	      }	       
             private Trap[] TrapSetupper(int TrapNum) {
	         Trap[] trapsetupper = new Trap[TrapNum];
	         for(int i = 0;i<TrapNum;i++) { // loop the trap 
		     double trapLocation = 3000 + Math.floor(Math.random()*1000);  // random trap (x) position floor(random more than 1000) (floor to round int)
	         trapsetupper[i] = new Trap((int)trapLocation,400,60,60,speed,this); // new trap lower position //explicit casting
	}
	         return trapsetupper; // return to create again
}
             private Trap[] TrapSetlower(int TrapNum) {
		     Trap[] trapsetlower = new Trap[TrapNum];
		     for(int i = 0;i<TrapNum;i++) {
			 double trapLocation = 2000 + Math.floor(Math.random()*1000); // more than 2000
		     trapsetlower[i] = new Trap((int)trapLocation,500,60,60,speed,this); // new trap lower position //explicit casting
		}
		     return trapsetlower;
 }

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if(System.currentTimeMillis() - lastPress > 175) { //delay jump press //current millisecond UTC +0 //protected press button repeatedly
		 if(e.getKeyCode() == 38) { // arrow up = 38
			samurai.jump(this); // called jump to samurai in this panel
			this.repaint();
			lastPress = System.currentTimeMillis();
		}
	}
		if(System.currentTimeMillis() - lastPress > 600) { //delay slide 
		  if (e.getKeyCode() == 40) { // arrow up = 40
	            samurai.slide(this); // called slide to samurai in this panel
	            this.repaint();
	            lastPress = System.currentTimeMillis(); 
	           }
		}
	}
		@Override
		public void keyReleased(KeyEvent e) {}
        public static void main(String[] arg) {
		  display = new Display(); 
	}
}