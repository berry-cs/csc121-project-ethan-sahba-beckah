import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Highscore {

	/*
     * Saves a list of scores to a file, keeping only the top scores.
     */
    public void saveScores(ArrayList<Integer> allScores) {
        Collections.sort(allScores, Collections.reverseOrder());
        int maxScoresToKeep = 10;										// Saves a maximum of 10 scores in the file

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

    /*
     * Loads scores from a file.
     */
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
}
