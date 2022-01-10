package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class SortWord {
    private static final String filePath = "./words_alpha.txt";
    private static final File file = new File(filePath);
    public static Scanner fileSc;
    private static List<String> wordsList = new ArrayList<>();
    private static String word;
    private static Random rand = new Random();

    public static String getWord() throws FileNotFoundException {
        Scanner fileSc = new Scanner(file);
        while (fileSc.hasNext()){
            wordsList.add(fileSc.nextLine());
        }
        fileSc.close();

        word = wordsList.get(rand.nextInt(wordsList.size() -1));
        return word;
    }
}
