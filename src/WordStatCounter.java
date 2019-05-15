import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordStatCounter {
    private String inputFileName;
    private HashMap<String, Integer> stat;

    public WordStatCounter(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public void calculateStat() throws IOException {
        File input = new File(this.inputFileName);
        FileReader fr = new FileReader(input);
        BufferedReader reader = new BufferedReader(fr);

        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("[ \\-\\?\\.]");
            for (String word : words) {
                if (!word.isEmpty()) {
                    if (stat.containsKey(word)) {
                        Integer count = stat.get(word);
                        Integer newCount = count + 1;
                        stat.put(word, newCount);
                    } else {
                        stat.put(word, 1);
                    }


                }
            }
        }
    }

    public ArrayList<Map.Entry<String, Integer>> getSortedStat() {
        Set<Map.Entry<String, Integer>> pairs = stat.entrySet();
        ArrayList<Map.Entry<String, Integer>> orderedPair = new ArrayList<>();
        //pair.getValue();

        for (Map.Entry<String, Integer> pair : pairs) {
            orderedPair.add(pair);
        }

        for (int i = pairs.size() - 1; i > 0; i--) {
            int minIndex = 0;
            for (int j = 1; j < i; j++) {
                if (orderedPair.get(j).getValue() < orderedPair.get(minIndex).getValue()) {
                    minIndex = j;
                }
            }
            Map.Entry<String, Integer> tmpElement = orderedPair.get(i);
            orderedPair.set(i, orderedPair.get(minIndex));
            orderedPair.set(minIndex, tmpElement);
        }

        return orderedPair;

    }


}
