import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.event.KeyEvent;

public class GameoverScreen implements IWorld {

	private Score score;
	private Integer highScore;
	
	/*
	 * x and y values for the text on screen.
	 */
	float x, y;
	float x2, y2;
	
	PFont FlappyFont;
	PFont GameoverFont;
	
	/*
	 * Initiates score input/output code
	 */
	public GameoverScreen(Score score) {
		this.score = score;
		
		ArrayList<Integer> allScores = loadScores();
		allScores.add(this.score.getScore());
		
		highScore = Collections.max(allScores);
		saveScores(allScores);
	}
	
	
	/* save all the scores in the list to the data file */
	private void saveScores(ArrayList<Integer> allScores) {
		Collections.sort(allScores, Collections.reverseOrder());
	    int maxScoresToKeep = 10; 
	    
	    if (allScores.size() > maxScoresToKeep) {
	        allScores = new ArrayList<Integer>(allScores.subList(0, maxScoresToKeep));
	    }

	    try {
	        PrintWriter writer = new PrintWriter(new File("highscore.txt"));
	        for (int score : allScores) {
	            writer.println(score);
	        }
	        writer.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("Error writing to file: " + e.getMessage());
	    }
	}
	
	
	/* open data file and read all existing scores */
	public ArrayList<Integer> loadScores() {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		File file = new File("highscore.txt");
		
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextInt()) {
				scores.add(scanner.nextInt());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		}
		
		return scores;
	}
	
	@Override
	public IWorld update() {
		return this;
	}
	
	/*
	 * Handles drawing all the text and such on screen
	 */
	@Override
	public PApplet draw(PApplet c) {
		c.background(91, 134, 194);
		c.fill(0);
		FlappyFont = c.createFont("FlappyBirdy.ttf", 150, true);
		GameoverFont = c.createFont("Serif", 20, true);
		c.textAlign(PConstants.CENTER);
		
		c.textFont(FlappyFont);
		c.textSize(150);
		c.text("Game Over", 300, 270);
		
		c.textSize(50);
		c.text("Press space to retry", 300, 350);
		
		c.textSize(20);
		c.textFont(GameoverFont);
		c.text("Your Score: " + score.getScore(), 300, 400);
		c.text("High score: " + highScore, 300, 430);
		
		return c;
	}
	
	/*
	 * Handles new flappybird instance when space is pressed
	 */
	@Override
	public IWorld keyPressed(KeyEvent kev) {
	    if (kev.getKey() == ' ') {
	    	return new FlappyWorld(new Ball(100, 200, 10), 
					new WallManager(50, 120, 2), 
					new Score());
	    } else {
	        return this;
	    }
	}



}
