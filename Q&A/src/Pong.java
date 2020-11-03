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
	private int PADDLE_WIDTH = 20, DIAM = 15, PADDLE_HEIGHTR = 130, PADDLE_HEIGHTL = 130, paddleRX = WIDTH-PADDLE_WIDTH,
	paddleRY = (HEIGHT/2)-PADDLE_HEIGHTR/2, paddleLY = (HEIGHT/2)-PADDLE_HEIGHTL/2, ballX= WIDTH/2, ballY=HEIGHT/2, 
	PADDLE_HEIGHT = 130;
	//Contains random data such as player scores
	private int scoreP1 = 0, scoreP2 = 0, paddleMovementR = 0, paddleMovementL = 0, botPaddleMovement, botPaddleSpeed = 5, 
	speedX =-1, speedY =2, speedX2 = -1, speedY2 = 2, subtractPaddle = 10, increaseSpeed = 1, paddleSpeed = 3;
	//Checks if game is 1 player or 2 players
	private boolean p1 = false, p2 = false;
	// this method moves the ball at each timestep
	public void move_ball() {
		ballX+=speedX;
		ballY+=speedY;	
	}
	// this method moves the paddles at each timestep
	public void move_paddles() {
	paddleLY += paddleMovementL;
	paddleRY += paddleMovementR;
	paddleRY += botPaddleMovement;
	//Movement for bot
	if(ballY-DIAM/2<paddleRY && p1 == true) {
		botPaddleMovement = -botPaddleSpeed;
	}
	if(ballY-DIAM/2>paddleRY+PADDLE_HEIGHTR && p1 == true) {
		botPaddleMovement = botPaddleSpeed;
	}
	if(ballY-DIAM/2 >= paddleRY && ballY-DIAM/2 <= paddleRY + PADDLE_HEIGHTR && p1 == true) {
		botPaddleMovement = 0;
	}
	}
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		//Checks if the ball goes off screen
	if(ballX>=WIDTH-DIAM||ballX<=0) {
			//If the ball goes to the left side, it runs this code
		if(ballX>=WIDTH-DIAM) {
				scoreP1 = scoreP1 + 1;
				speedX = speedX2; 
				speedY = speedY2;
				PADDLE_HEIGHTR = PADDLE_HEIGHT;
				PADDLE_HEIGHTL = PADDLE_HEIGHT;
				paddleLY = (HEIGHT/2)-PADDLE_HEIGHTL/2;
				paddleRY = (HEIGHT/2)-PADDLE_HEIGHTR/2;
				}
			//If the ball goes to the right, it runs this
		if(ballX<=0) {
				scoreP2 = scoreP2 + 1;
				speedX =-speedX2; 
				speedY =speedY2;
				PADDLE_HEIGHTR = PADDLE_HEIGHT;
				PADDLE_HEIGHTL = PADDLE_HEIGHT;
				paddleLY = (HEIGHT/2)-PADDLE_HEIGHTL/2;
				paddleRY = (HEIGHT/2)-PADDLE_HEIGHTR/2;
			}
			
			ballX=WIDTH/2;
			ballY=HEIGHT/2;
			speedX = -speedX;
		}
		//If the ball hits the roof or floor, it bounces because of this code
		if(ballY>=HEIGHT-DIAM||ballY<=0) {
			speedY = -speedY;
		}
		//Collision for the right side paddle. This also includes my extra feature. If the ball hits the paddle, 
		//it shrinks by 10 pixels
		if(ballX>=WIDTH-PADDLE_WIDTH-DIAM && paddleRY <= ballY && ballY<=PADDLE_HEIGHTR+paddleRY) {
			speedX = -speedX;
			PADDLE_HEIGHTR += -subtractPaddle;
			speedX += -increaseSpeed;
			speedY += -increaseSpeed;
		}
		//Collision for left side paddle
		if(ballY>=paddleLY && ballY<= paddleLY+PADDLE_HEIGHTL && ballX<=0+PADDLE_WIDTH) {
			speedX = -speedX;
			PADDLE_HEIGHTL += -subtractPaddle;
			speedX += increaseSpeed;
			speedY += increaseSpeed;
		}
	//These 4 if statements prevent the paddle from going off the screen
	if(paddleLY <= 0) {
		paddleLY = 0;
	}
	if(paddleLY + PADDLE_HEIGHTL >= HEIGHT) {
		paddleLY = HEIGHT - PADDLE_HEIGHTL;
	}
	
	if(paddleRY <= 0) {
		paddleRY = 0;
	}
	if(paddleRY + PADDLE_HEIGHTR >= HEIGHT) {
		paddleRY = HEIGHT - PADDLE_HEIGHTR;
	}
}
	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		// background color is black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(new Color(255,255,255));
	
		g.fillRect(WIDTH/2-DIAM/2,0,DIAM/2,HEIGHT);
		
		// draw your rectangles and circles here
		g.setColor(new Color(255,0,0));
		//Left side paddle
		g.fillRect(0, paddleLY, PADDLE_WIDTH, PADDLE_HEIGHTL);
		
		g.setColor(new Color(0,255,0));
		//Right side paddle
		g.fillRect(paddleRX, paddleRY, PADDLE_WIDTH, PADDLE_HEIGHTR);
		
		//Writes the score
		Font f = new Font("Arial", Font.BOLD, 60);
		g.setFont(f);
		g.setColor(Color.RED);
		//player 1 score
		g.drawString("" + scoreP1, WIDTH/2-55, 50);
		//player 2 score
		g.setColor(Color.GREEN);
		g.drawString("" + scoreP2, WIDTH/2+15, 50);
		
		//Ball This color is blue
		g.setColor(new Color(0,118,156));
		g.fillOval(ballX, ballY, DIAM, DIAM);
		
		//If the p1 or p2 score is equal to 6, they win
		if(scoreP1 == 6) {
			g.setFont(f);
			g.setColor(Color.RED);
			g.drawString("Player 1 wins", WIDTH/5, HEIGHT/2);
			ballY = HEIGHT + HEIGHT;
			speedX = 0;
			speedY = 0;
			PADDLE_HEIGHTR = 0;
			PADDLE_HEIGHTL = 0;
		}
		if(scoreP2 == 6) {
			g.setFont(f);
			g.setColor(Color.GREEN);
			g.drawString("Player 2 wins", WIDTH/5, HEIGHT/2);
			ballY = HEIGHT + HEIGHT;
			speedX = 0;
			speedY = 0;
			PADDLE_HEIGHTR = 0;
			PADDLE_HEIGHTL = 0;
		}
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN && p2 == true) {
			paddleMovementR = paddleSpeed;
		}
		if (keyCode == KeyEvent.VK_UP && p2 == true) {
			paddleMovementR = -paddleSpeed;
		}
		
		if (e.getKeyChar() == 'w') {
			paddleMovementL = -paddleSpeed;	
		}
			
		if (e.getKeyChar() =='s') {
			paddleMovementL = paddleSpeed;
		}
			
		// turn 1-player mode on
		if (e.getKeyChar() == '1'&& p2 == false) {
			p1 = true;
		}	
		
		// turn 2-player mode on
		if (e.getKeyChar() == '2'&& p1 == false) {
			p2 = true;	
		}		
	}

	// defines what we want to happen if a keyboard button
	// has been released
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) {
			paddleMovementR = 0;
		}

		if (keyCode == KeyEvent.VK_DOWN) {
			paddleMovementR = 0;
		}
  
		if(e.getKeyChar() == 'w') {
			paddleMovementL = 0;
			}
		
		if (e.getKeyChar() == 's') {
			paddleMovementL = 0;
		}
	}
	
	// restarts the game, including scores
	public void restart() {
		scoreP1 = 0;
		scoreP2 = 0;
		p1 = false;
		p2 = false;
		ballY = HEIGHT/2;
		ballX = WIDTH/2;
		speedX = -1;
		speedY = 2;
		PADDLE_HEIGHTR = PADDLE_HEIGHT;
		PADDLE_HEIGHTL = PADDLE_HEIGHT;
		paddleLY = (HEIGHT/2)-PADDLE_HEIGHTL/2;
		paddleRY = (HEIGHT/2)-PADDLE_HEIGHTR/2;	
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