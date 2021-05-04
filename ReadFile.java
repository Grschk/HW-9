import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadFile {

    private final Pattern PATTERN_1 = Pattern.compile("[(][0-9]{3}[)]\s[0-9]{3}[-][0-9]{4}");

    private final Pattern PATTERN_2 = Pattern.compile("[0-9]{3}[-][0-9]{3}[-][0-9]{4}");

    private boolean isCorrect(String number) {
        Matcher matchA = PATTERN_1.matcher(number);
        Matcher matchB = PATTERN_2.matcher(number);
        return matchA.find() || matchB.find();
    }

    public void validNumbers(String pathToFile) throws IOException {
        List<String> numbers = Files.readAllLines(Paths.get(pathToFile));
        for (String number : numbers) {
            if (isCorrect(number)) {
                System.out.println("Number is: " + number);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ReadFile isCorrect = new ReadFile();
        isCorrect.validNumbers("src/resources/phoneNumbers.txt");
    }
}
