import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner file = new Scanner(new File("./words_alpha.txt"));
        Scanner keyboard = new Scanner(System.in);
        List<String> wordsList = new ArrayList<>();
        List<Character> playerGuesses = new ArrayList<>();
        Random rand = new Random();

        String word;
        int wrongCount = 0;

        // seleciona aleatoriamente uma palavra para o jogo
        while (file.hasNext()) {
            wordsList.add(file.nextLine());
        }
        word = wordsList.get(rand.nextInt(wordsList.size()));

        while (true) {

            printHangedman(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose!");
                System.out.println("The word is " + word);
                break;
            }


            printWordState(word, playerGuesses);
            if (!getPlayerGuess(keyboard, word, playerGuesses)) {
                wrongCount++;
            }

            if (printWordState(word, playerGuesses)) {
                System.out.println("You win!!!");
                break;
            }


        }

    }

    private static void printHangedman(int wrongCount) {
        System.out.println(" -------");
            System.out.println(" |     |");

            if (wrongCount >= 1) {
                System.out.println(" O");
            }
            if (wrongCount >= 2) {
                System.out.print("\\ ");
                if (wrongCount >= 3) {
                    System.out.println("/");
                } else {
                    System.out.println("");
                }
            }
            if (wrongCount >= 4) {
                System.out.println(" |");
            }
            if (wrongCount >= 5) {
                System.out.print("/ ");
                if (wrongCount >= 6) {
                    System.out.println("\\");
                } else {
                    System.out.println("");
                }
            }
            System.out.println();
            System.out.println();
    }

    private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Guess the letter: ");
        Character letterGuess = keyboard.next().charAt(0);
        playerGuesses.add(letterGuess);

        return word.contains(letterGuess.toString());
    }
    
    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("_");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }
}
