package arrays;
// Angry Birds template provided by Mr. David
// I used this website to help me with the random numbers
// https://www.educative.io/edpresso/how-to-use-the-mathrandom-method-in-java
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AngryBirdsFiller extends JPanel {
	
	// the width/height of the window
	private final int W_WIDTH = 1400, W_HEIGHT = 600, DIAM = 20;
	
	// the number of enemies in the game
	private final int NUM_ENEMIES = 6;
	
	// a constant for the gravitational pull on the bird
	private final double GRAVITY = .4;

	// arrays
	private int[] enemyX = new int [NUM_ENEMIES];
	private int[] enemyY = new int [NUM_ENEMIES];
	private boolean[] dead = new boolean [NUM_ENEMIES];
	
	//All the images used
	private Image water, waterSplash, cannon, island, sky, cloud, 
	cannonBall, pirateShip, explosion, bossBoat;
	
	//booleans
	private boolean isGravityOn = false, launched = false, splash = false, bossDead = false, win = false,
	backward = true, foward = false;
	
	//int, coords, and sizes for the images
	private int birdStartingPositionX = 300, birdStartingPositionY = 450, cloudLength = 160, cloudHeight = 80,
	cloudX1 = 200 - cloudLength, cloudX2 = W_WIDTH/2 - cloudLength, cloudX3 = 1200 - cloudLength, islandX = -40,
	islandY = W_HEIGHT-420, islandLength = 500, cannonX = 100, cannonLength = 200, cannonHeight = 100, 
	bossBoatX = 1100, bossBoatY = W_HEIGHT/2, explosionX = 280, attempts, startX, startY, splashX, cloudY = 50,
	pirateShipLength = 100;
	
	//doubles
	private double speedX = 0, speedY = 0, birdX = 300, birdY = 450;
	
	// this method is for setting up any arrays that need filling in and loading images. 
	// This method will run once at the start of the game.
	public void setup() {

		// example of loading an image file - edit to suit your project
		try {
			water = ImageIO.read(new File("background_water.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			waterSplash = ImageIO.read(new File("waterSplash.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			cannon = ImageIO.read(new File("Cannon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			island = ImageIO.read(new File("island.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			sky = ImageIO.read(new File("background_sky.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			cloud = ImageIO.read(new File("cloud.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			explosion = ImageIO.read(new File("explosion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			cannonBall = ImageIO.read(new File("cannon ball.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			pirateShip = ImageIO.read(new File("pirate ship.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bossBoat = ImageIO.read(new File("boss boat.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//boundary variables
		int xMin = 500, xMax = 1000, yMin = 200, yMax = 500;
		//assigns a random x and y coord to each enemy
		for(int i = 0; i < enemyX.length; i++) {
			enemyX[i] = (int)(Math.random() * ((xMax - xMin)) + xMin);
			enemyY[i] = (int)(Math.random() * ((yMax - yMin)) + yMin);
			}
	}
	
	// move your 'bird' and apply any gravitational pull 
	public void moveBird() {
		birdX += speedX;
		birdY += speedY;
		//Moves the clouds
		cloudX1 += 1;
		cloudX2 += 1;
		cloudX3 += 1;
		//If the clouds go off the screen, they get sent back to 0
		if (cloudX1 == W_WIDTH)
			cloudX1 = -cloudLength;
		if (cloudX2 == W_WIDTH)
			cloudX2 = -cloudLength;
		if (cloudX3 == W_WIDTH)
			cloudX3 = -cloudLength;
		
		//If the enemys are dead, they will drop down
		for(int i = 0; i < dead.length; i++) {
			if (dead[i] == true || win == true) {
				enemyY[i] += 10;
				
			}
		}
		
		//Applys gravity to the bird
		if (isGravityOn)
			speedY += GRAVITY;
		//Used for the splashing animation when the cannon ball goes off screen
		if (birdY < W_HEIGHT)
			splashX = (int)birdX;
		
		if (birdY >= W_HEIGHT) 
			splash = true;
		
		//Resets bird position, speed, and gravity
		if (birdY >= W_HEIGHT + W_HEIGHT) {
			isGravityOn = false;
			
			birdX = birdStartingPositionX;
			birdY = birdStartingPositionY;
			
			speedX = 0;
			speedY = 0;
			
			launched = false;
			splash = false;	
		}	
		//bondary variables for the boss and the speed
		int bossBondary1 = 1300, bossBondary2 = 1100, bossSpeed = 2;
		//Makes the boss fall if it is defeated
		if (bossDead) 
			bossBoatY += 10;
		
		//Moves the boss backwards and fowards
		if (backward)
			bossBoatX += bossSpeed;
		
		if (bossBoatX >= bossBondary1) {
			backward = false;
			foward = true;
		}
		if (bossBoatX <= bossBondary2) {
			backward = true;
			foward = false;
		}
		
		if (foward) {
			bossBoatX -= bossSpeed;
		}
			
	}
	
	// check for any collisions between your 'bird' and the enemies.
	// if there is a collision, address it
	public void checkHits() {
	//If a collision happens, the boss is set to dead and the speed becomes negative
		for(int i = 0; i < enemyX.length; i++) {				
			if (distance(birdX, birdY, enemyX[i], enemyY[i]+40) <= DIAM/2 + pirateShipLength/2) {
				dead[i] = true;
				speedX = -1;
				}
			}
		//Collision for the boss. If a collision happens, you win and the boss stops moving
		if (distance(birdX, birdY, bossBoatX, bossBoatY+40) <= DIAM/2 + pirateShipLength/2) {
			bossDead = true;
			win = true;
			backward = false;
			foward = false;
			speedX = -1;
		}
			}
	
	//Distance 
	private int distance(double birdX2, double birdY2, int x2, int y2) {
		int distance = (int) Math.sqrt((x2-birdX2)*(x2-birdX2)+(y2-birdY2)*(y2-birdY2)); 
		return distance;
	}
	
	// what you want to happen at the moment when the 
	// mouse is first pressed down.
	//The two variables are set equal to the mouse coordinates
	public void mousePressed(int mouseX, int mouseY) {
		if (launched == false) {
			startX = mouseX;
			startY = mouseY;
		}
	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		
		if (launched == false) {
			//calculates what the speed of the bird should be
			int distDraggedX = mouseX - startX;
			int distDraggedY = mouseY - startY;
			
			speedX = -distDraggedX/10.0;
			speedY = -distDraggedY/10.0;
			//Turns on gravity
			isGravityOn = true;
			launched = true;
			//Adds an attempt if you haven't won the game
			if(win == false)
				attempts += 1;
		}
	}
	
	// draws everything in the game
	public void paint(Graphics g) {
		// draws a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
		
		g.drawImage(water, 0,0, W_WIDTH, W_HEIGHT, null);
		
		g.drawImage(sky, 0,0, W_WIDTH, W_HEIGHT/3, null);		
		
		//Draws the three clouds
		g.drawImage(cloud, cloudX1, cloudY, cloudLength, cloudHeight, null);
		g.drawImage(cloud, cloudX2, cloudY, cloudLength, cloudHeight, null);
		g.drawImage(cloud, cloudX3, cloudY, cloudLength, cloudHeight, null);
		
		//Displays the attempts
		Font f = new Font("Arial", Font.BOLD, 30);
		
		g.setFont(f);
		g.setColor(Color.RED);
		
		g.drawString("Attempts " + attempts, 0, 30);
		
		//For loop to draw the enemys
		for(int i = 0; i < enemyX.length; i++) {
			g.drawImage(pirateShip, enemyX[i], enemyY[i], pirateShipLength, pirateShipLength, null);
		}
		
		g.drawImage(bossBoat, bossBoatX, bossBoatY, pirateShipLength, pirateShipLength, null);
		
		g.drawImage(island, islandX, islandY, islandLength, islandLength, null);
		
		g.drawImage(cannon, cannonX, birdStartingPositionY, cannonLength, cannonHeight, null);
		
		if (launched)
			g.drawImage(cannonBall, (int)birdX, (int)birdY, DIAM, DIAM, null);
		
		if (splash) 
			g.drawImage(waterSplash, splashX, W_HEIGHT-DIAM*3, DIAM*3, DIAM*2, null);
		//When the cannon ball is launched, an explosion appears
		
		if (isGravityOn)
			g.drawImage(explosion, explosionX, birdStartingPositionY-DIAM/2, DIAM*2, DIAM*2, null);
		//Prints text if you win
		
		if (win) {
			g.setFont(f);
			g.setColor(Color.RED);
			g.drawString("You win!", W_WIDTH/2-30, W_HEIGHT/2);
		}
			
	}

	// ************** DON'T TOUCH THE BELOW CODE ********************** //
	
	public void run() {
		while (true) {
			moveBird();
			checkHits();
			repaint();
			
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	public AngryBirdsFiller() {
		setup();
		
		JFrame frame = new JFrame();
		frame.setSize(W_WIDTH,W_HEIGHT);
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				AngryBirdsFiller.this.mousePressed(e.getX(),e.getY());	
			}
			public void mouseReleased(MouseEvent e) {
				AngryBirdsFiller.this.mouseReleased(e.getX(),e.getY());
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		run();
	}
	public static void main(String[] args) {
		new AngryBirdsFiller();
	}
}
