package src;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the gamemode:");
        System.out.print("('s' to single player, other character to multiplayer): ");
        boolean isSinglePlayer = sc.next().charAt(0) == 's'; 

        String word;
        if (isSinglePlayer) {
            word = SortWord.getWord();
        } else {
            System.out.println("Write a word for your opponent: ");
            sc.nextLine();
            word = sc.nextLine();

            ClearConsole();
        }

        Controller controller = new Controller(); 
        Game game = new Game(controller, word, sc);
        game.run();

    }

    private static void ClearConsole() {
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
    }
}
