import processing.sound.*;

public class Sound {

	public static SoundFile flapSound;
	public static SoundFile deathSound;
	public static SoundFile scoreSound;
	
	/*
	 * Handles playing the flap sound
	 */
	public static void flapSound() {
		flapSound.amp((float) 0.4);
		flapSound.play();
	}
	
	/*
	 * Handles playing the death sound
	 */
	public static void deathSound() {
		deathSound.amp((float) 0.2);
		deathSound.play();
	}
	
	/*
	 * Handles playing the score sound
	 */
	public static void scoreSound() {
		scoreSound.amp((float) 0.3);
		scoreSound.play();
	}
}
