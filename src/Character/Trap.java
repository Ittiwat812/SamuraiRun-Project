package Character;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;


	
public class Trap {

	public int x;
    public int y;
    public int width;
    public int height;
    public int speed;
    private int startpoint;
    
    public Trap(int x,int y,int w, int h,int sp,JPanel main) { // add timer Timer(delay : (int),listener : (ActionListener))
    	this.x = x;
    	this.y = y;
    	this.width = w;
    	this.height = h;
    	this.speed = sp;
    	this.startpoint = x;
    	trapmove(main); //add trap move to JPanel
    }
    public void trapmove(JPanel main) {
    	Timer timer = new Timer(50,new ActionListener() { // set timer 50 to trap for move
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= speed;
				main.repaint();
				if(x<0) { // redraw in frame
					x = startpoint; // when x < 0 in panel redraw
				}
			}
    });
    	timer.start(); 
  }
    public BufferedImage getImagetrap() { // create Kunai pic
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("Image\\kunai.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
    public BufferedImage getImageblood() { // create blood screen pic
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("Image\\Blood.png"));
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
 }
}
