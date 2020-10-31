// filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	//Measurements for each shape
	private int PADDLE_WIDTH = 20, DIAM = 15, PADDLE_HEIGHT = 130, paddleRX = WIDTH-PADDLE_WIDTH,
	paddleRY = (HEIGHT/2)-PADDLE_HEIGHT/2;
	
	private int scoreP1 = 0;
	private int scoreP2 = 0;
	private int difficulty = 1;
	private int PADDLE_SPEED = 0;
	private int PADDLE_SPEED2 = 0;
	private int PADDLE_SPEED_UP = 0;
	private int PADDLE_SPEED_UP2 = 0;
	private int botPaddleSpeed;
	
	
	// your instance variables here, I've given you a few 

	private int ballX= WIDTH/2, ballY=HEIGHT/2, speedX, speedY;
	private int paddleLY = (HEIGHT/2)-PADDLE_HEIGHT/2;
	private boolean p1 = false;
	private boolean p2 = false;
	private boolean gameOver = false;
	private boolean gameStart = false;
	
	// this method moves the ball at each timestep
	public void move_ball() {
if(gameStart == true) {
	speedX = 1;
	speedY = 2;
}
		ballX+=speedX;
		ballY+=speedY;
		
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
	
	paddleLY += PADDLE_SPEED2;
	
	paddleRY += PADDLE_SPEED;
	
	paddleLY += PADDLE_SPEED_UP;
	
	paddleRY += PADDLE_SPEED_UP2;
	
	paddleRY += botPaddleSpeed;
	
	if(ballY-DIAM/2<paddleRY && p1 == true) {
		botPaddleSpeed = -5;
	}
	if(ballY-DIAM/2>paddleRY+PADDLE_HEIGHT && p1 == true) {
		botPaddleSpeed = 5;
	}
	if(ballY-DIAM/2 >= paddleRY && ballY-DIAM/2 <= paddleRY + PADDLE_HEIGHT && p1 == true) {
		botPaddleSpeed = 0;
	}
	}
	
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		if(ballX>=WIDTH-DIAM||ballX<=0) {
			if(ballX>=WIDTH-DIAM) {
				scoreP1 = scoreP1 + 1;
				}
			if(ballX<=0) {
				scoreP2 = scoreP2 + 1;
			}
			ballX=WIDTH/2;
			ballY=HEIGHT/2;
			speedX = -speedX;
			
		}
		// your code goes here
		if(ballY>=HEIGHT-DIAM||ballY<=0) {
			speedY = -speedY;
		}
	
		if(ballY-DIAM <= paddleRX+ PADDLE_WIDTH && ballY+DIAM>= paddleRX && ballY+DIAM<= paddleRY + PADDLE_HEIGHT && ballY + DIAM > paddleRY) {
			speedX = -speedX;
			
		}
		
			if(ballY>=paddleLY && ballY<= paddleLY+PADDLE_HEIGHT && ballX<=0+PADDLE_WIDTH) {
			speedX = -speedX;
			
				
	}
	
	if(ballX-DIAM<=0) {
		speedX =+speedX;
		
		
	
	}
	if(paddleLY <= 0) {
		paddleLY = 0;
	}
	if(paddleLY + PADDLE_HEIGHT >= HEIGHT) {
		paddleLY = HEIGHT - PADDLE_HEIGHT;
	}
	
	if(paddleRY <= 0) {
		paddleRY = 0;
	}
	if(paddleRY + PADDLE_HEIGHT >= HEIGHT) {
		paddleRY = HEIGHT - PADDLE_HEIGHT;
	}
	
	}
	
	
	
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(new Color(255,255,255));
	
		g.fillRect(WIDTH/2-DIAM/2,0,DIAM/2,HEIGHT);
		
		// draw your rectangles and circles here
		g.setColor(new Color(255,0,0));
		//Left side paddle
		g.fillRect(0, paddleLY, PADDLE_WIDTH, PADDLE_HEIGHT);
		
		g.setColor(new Color(0,255,0));
		//Right side paddle
		g.fillRect(paddleRX, paddleRY, PADDLE_WIDTH, PADDLE_HEIGHT);
		
		// writes the score of the game - you just need to fill the scores in
		
		Font f = new Font("Arial", Font.BOLD, 60);
		g.setFont(f);
		g.setColor(Color.RED);
		g.drawString("" + scoreP1, WIDTH/2-60, 50);
		g.setColor(Color.GREEN);
		g.drawString("" + scoreP2, WIDTH/2+12, 50);
		
		Font h = new Font("Arial", Font.BOLD, 20);
		
		g.setFont(h);
		g.setColor(Color.RED);
		g.drawString("Difficulty: " + difficulty, 20,20 );
		
		
		
		//Ball
		if(gameStart == true && gameOver == false) {
		g.setColor(new Color(0,118,156));
		g.fillOval(ballX, ballY, DIAM, DIAM);
		}
		
		
		if(scoreP1 == 6) {
		
			g.setFont(f);
			g.setColor(Color.RED);
			g.drawString("Player 1 wins", 0+WIDTH/5, HEIGHT/2);
			gameOver = true;
			speedX = 0;
			speedY = 0;
		}
		if(scoreP2 == 6) {
			
			g.setFont(f);
			g.setColor(Color.GREEN);
			g.drawString("Player 2 wins", 0+WIDTH/5, HEIGHT/2);
			gameOver = true;
			speedX = 0;
			speedY = 0;
		}
		Font c = new Font("Arial", Font.BOLD, 50);
		if(p1 == false && p2 == false) {
			g.setFont(c);
			g.setColor(Color.BLUE);
			g.drawString("Type 2 for two players", 0+WIDTH/20, HEIGHT/2);
			g.drawString("Type 1 for one player", 0+WIDTH/20, HEIGHT/3);
		}
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN && p2 == true && gameStart == true) {
			PADDLE_SPEED = 3;
		
		
				}
		if (keyCode == KeyEvent.VK_UP && p2 == true && gameStart == true) {
			// fill this in
			PADDLE_SPEED = -3;
		}
		
		

		if (e.getKeyChar() == 'w'&& gameStart == true) {
			PADDLE_SPEED2 = -3;
			
		}
			// move paddle down
			
		
		if (e.getKeyChar() =='s'&& gameStart == true) {
			PADDLE_SPEED2 = 3;
		}
			// fill this in
			
	// turn 1-player mode on
		if (e.getKeyChar() == '1'&& gameStart == false)
			
			p1 = true;
			
			gameStart = true;
		// turn 2-player mode on
		if (e.getKeyChar() == '2'&& gameStart == false) {
			p2 = true;
			
			gameStart = true;
		}
			
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP && gameStart == true) {
			PADDLE_SPEED = 0;
		}
			// fill this in

		if (keyCode == KeyEvent.VK_DOWN && gameStart == true) {
			PADDLE_SPEED = 0;
		}
			// fill this in
  
		if(e.getKeyChar() == 'w'&& gameStart == true) {
			PADDLE_SPEED2 = 0;
			}
		
		if (e.getKeyChar() == 's'&& gameStart == true) {
			PADDLE_SPEED2 = 0;
	}
		}
	
	// restarts the game, including scores
	public void restart() {

		scoreP1 = 0;
		scoreP2 = 0;
		gameStart = false;
		gameOver = false;
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}