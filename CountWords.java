import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountWords {
    public static void main(String[] args) throws IOException {
        int ch;
        StringBuilder sb = new StringBuilder();
        boolean isRepeat = false;
        try(FileReader is = new FileReader("src/resources/Words.txt")) {

            while ((ch = is.read()) !=-1){
                if ((((char) ch) != '\r') && (((char) ch) != '\n')) {
                    sb.append((char) ch);
                    isRepeat = false;
                }
                else if (((((char) ch) == '\r') || (((char) ch) != '\n')) && !isRepeat) {
                    sb.append(' ');
                    isRepeat = true;
                }
            }
        }
        String [] stringLine = sb.toString().split(" ");
        List<Countwords> countwordsList = new ArrayList<>();
        for (int i = 0; i < stringLine.length; i++) {
            if (!stringLine[i].equals("")) {
                int count = 0;
                String equal = stringLine[i];
                for (int j = 0; j < stringLine.length; j++) {
                    if (stringLine[j].equals(equal)) {
                        count++;
                        stringLine[j] = "";
                    }
                }
                countwordsList.add(new Countwords(equal, count));
            }
        }
        countwordsList.sort(Countwords::compareTo);
        for (Countwords cWords:countwordsList) {
            System.out.println(cWords.toString());
        }
    }

    static class Countwords implements Comparable<Countwords>{
        private String word;
        private int count;

        public Countwords(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Countwords o) {
            return o.count - this.count;
        }

        @Override
        public String toString() {
            return word + " " + count + "\n";
        }
    }
}