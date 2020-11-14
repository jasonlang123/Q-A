

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;

	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		drawCircles(g, 50);
		rectangle(g);
		circleSquareTriangle(g);
		circles10(g);
	}
		
	// call your methods here
	//Write a method that draws n (a parameter) circles across the screen
	//Write a method that draws circles across the screen, which start small, grow bigger, then shrink again
	//
		public void drawCircles(Graphics g, int n){
			int circleX = 10, circleY = 10, DIAM = 10;
			int red = 0;
					
			for(int i = 0; i < n; i++) {
			circleX += 10;
			red += 15;
			DIAM--;
			if(DIAM == 1)
				DIAM = 15;
			if(red>=255) {
				red = 0;
			}
			g.setColor(new Color(red,0,0));
			g.fillOval(circleX, circleY, DIAM, DIAM);
			}}
		//Write a method that draws rectangles across the screen, cycling through various colors
		public void rectangle(Graphics g) {
			int red = 0;
			int n = 15;
			int rectX = 10; int rectY = 50; int height = 10; int width = 15;
	
			for(int i = 0; i < n; i++) {
				g.setColor(new Color(red,0,0));
				g.fillRect(rectX, rectY, width, height);
				rectX += 50;
				red += 15;
				if(red>=255) {
					red = 0;}
			}
//Write a method that draws a circle, then a square, then a triangle, then a circle, 
//then a square, then a triangle, and so on..
			
		}
//I got help on this one
public void circleSquareTriangle(Graphics g) {
	int n = 10;
	int x = 10;
	int y = 100;
	int diam = 10;
	for(int p = 0; p<n; p++) {
		
		for(int i = 0; i<=3; i++) {
			x += 20;
		if (i == 0) {
			
			g.setColor(new Color(255,0,0));
			g.drawOval(x, y, diam, diam);
		}else if(i == 1){
			g.setColor(new Color(255,0,0));
			g.drawRect(x, y, diam, diam);
		}else if(i == 2) {
			// draw line to make triangle
			g.setColor(new Color(255, 0, 0));
			g.drawLine(x, y+diam, x+diam, y+diam);
			g.drawLine(x, y+diam, x+(diam/2), y);
			g.drawLine(x+diam, y+diam, x+(diam/2), y);
		}
		}
	
	
}}
public void circles10(Graphics g) {
	int diam = 10;
	int x = 10;
	int y = 200;
	for(int p = 0; p<10; p++) {
		x+=10;
		y=200;
		for(int i = 0; i<10; i++) {
			y+= 10;
		g.setColor(new Color(255,0,0));
		g.drawOval(x, y, diam, diam);
	}}
}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
		
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}