import java.io.*;

public class ScoreTracker {

    public static void saveScore(String name, int score) {
        try {
            FileWriter writer = new FileWriter("ScoreHistory", true);
            writer.write(name + ": " + score + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving score.");
        }
    }

    public static void readScores() {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("ScoreHistory"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No scores found yet.");
        }
    }
}