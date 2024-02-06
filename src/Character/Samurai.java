package Character;

import java.awt.event.*; // ActionEvent,ActionListener
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;
import javax.swing.*; // JPanel,Timer




public class Samurai { // determine variable of Samurai
	 public int x;
     public int y;
     public int SamuraiWidth;
     public int SamuraiHeight;
     public int Healthpoint = 100;
     private int jumpHigh = 100;
     private int sliding = 75; // to sliding
     private int slidey = 75; // to change the position of y
     private int delayjump = 450;
     private int delayslide = 550;
     
 public Samurai () {
 }
 
  public Samurai(int x,int y,int SamuraiWidth,int SamuraiHeight,int Healthpoint) { // determine constructor of Samurai
    	this.x = x;
    	this.y = y;
    	this.SamuraiWidth = SamuraiWidth;
    	this.SamuraiHeight = SamuraiHeight;
    	this.Healthpoint = Healthpoint;
    }
  public void jump(JPanel Main) { // create jump
	  this.y -= jumpHigh; //when fall 
	  Main.repaint();
	  Timer timer = new Timer(delayjump,new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) {
			  y += jumpHigh; //when jump  
			  Main.repaint();
		  }
	  });
	  timer.setRepeats(false); // to called only one ActionPerformed
	  timer.start();
  }
  public void slide(JPanel Main) { // create slide
      this.SamuraiHeight -= sliding; 
      this.SamuraiWidth += sliding; 
      this.y += slidey; // position of y while slide 
      Main.repaint();
      Timer timer = new Timer(delayslide,new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) { 
              SamuraiWidth -= sliding; 
              SamuraiHeight += sliding; 
              y -= slidey; // back to previous position 
              Main.repaint();
          }
      });
      timer.setRepeats(false); // to called only one ActionPerformed
      timer.start();
 }
  public BufferedImage getImage() { // create samurai pic
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("Image\\samurai.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
  public BufferedImage getImage1() { // create samuraislide pic
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("Image\\samuraislide.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}

