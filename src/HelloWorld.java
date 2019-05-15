import java.io.*;
import java.util.*;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        WordStatCounter statCounter = new WordStatCounter("C:\\Users\\Галина\\IdeaProjects\\TestTaskFocusStart\\src\\input.txt");
        statCounter.calculateStat();

        ArrayList<Map.Entry<String, Integer>> sortedStat = statCounter.getSortedStat();

        PrintWriter writer= new PrintWriter("C:\\Users\\Галина\\IdeaProjects\\TestTaskFocusStart\\src\\output.txt", "UTF-8");

        for (Map.Entry<String ,Integer>currentPair: sortedStat) {
            writer.println(currentPair.getKey() + ";" + currentPair.getValue());
        }
        writer.close();

    }
}