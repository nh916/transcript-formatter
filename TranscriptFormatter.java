import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

public class TranscriptFormatter {
    public TranscriptFormatter() {

    }


    // all the words without returns will be here
    String all = "";


    public void loadingData(String fileName, String firstPerson, String secondPerson) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream(fileName));

        String line = scanner.nextLine();

        all = line.replaceAll(" (" + firstPerson + "|" + secondPerson + ") :", "\n$1:");

    }


    // writes the text to file
    private void writeToFile(String newFile) throws IOException {
        Path file = Paths.get(newFile);
        Files.write(file, Collections.singleton(all));
    }

    public static void main(String[] args) throws IOException {
        TranscriptFormatter transcriptFormatter = new TranscriptFormatter();

        transcriptFormatter.loadingData("transcript.txt", "Me", "You");

        transcriptFormatter.writeToFile("transcript.txt");

    }

}
