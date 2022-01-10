package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Controller controller;
    String word;
    Scanner sc;
    List<Character> playerGuesses = new ArrayList<>();

    public Game(Controller controller, String word, Scanner sc) {
        this.controller = controller;
        this.word = word;
        this.sc = sc;
    }

    public void run() {
        while ( true ) {

            printHangedman();

            if (loseCheck()) break;

            printWord();

            getPlayerGuess();

            if (controller.GetCorrectCount() == word.length()) {    // Win Check
                System.out.println("You Win! =D"); break;
            }

            controller.ResetCorrectCount();
        }
    }

    private void getPlayerGuess() {
        System.out.println("Guess the letter: ");
        Character letterGuess = sc.next().charAt(0);
        playerGuesses.add(letterGuess);

        if (!word.contains(letterGuess.toString())){
            controller.AddWrongCount();
        } 
    }

    private void printWord() {
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                controller.AddCorrectCount();
            } else {
                System.out.print('_');
            }
        }
        System.out.println();
    }

    private boolean loseCheck() {

        if (controller.GetWrongCount() >= 6) {
            System.out.println("You Lose ;-;");
            System.out.println("The Word is: " + word);
            return true;
        } else {
            return false;
        }
    }

    private void printHangedman() {
        System.out.println(" -------");
            System.out.println(" |     |");

            if (controller.GetWrongCount() >= 1) {
                System.out.println(" O");
            }
            if (controller.GetWrongCount() >= 2) {
                System.out.print("\\ ");
                if (controller.GetWrongCount() >= 3) {
                    System.out.println("/");
                } else {
                    System.out.println("");
                }
            }
            if (controller.GetWrongCount() >= 4) {
                System.out.println(" |");
            }
            if (controller.GetWrongCount() >= 5) {
                System.out.print("/ ");
                if (controller.GetWrongCount() >= 6) {
                    System.out.println("\\");
                } else {
                    System.out.println("");
                }
            }
            System.out.println();
            System.out.println();
    }
}
