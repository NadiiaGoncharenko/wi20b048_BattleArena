import Pawn.Hero;
import Singleton.Singleton;

import java.util.Scanner;

// check user input
public class UserIO {

    private static Scanner readInput = new Scanner(System.in);

    public void printFightMenu(String name) {
        System.out.println("+--------------------------------------->  ");
        System.out.println("| Your turn: " + name + "                  ");
        System.out.println("|                                          ");
        System.out.println("| 0: End game                              ");
        System.out.println("| 1: Fight the enemy                       ");
        System.out.println("| 2: Create a new leprechaun    ( 2 Coins )");
        System.out.println("| 3: Create a new tiny goblin   ( 1 Coin  )");
        System.out.println("| 4: Create a new medium goblin ( 3 Coins )");
        System.out.println("| 5: Create a new big goblin    ( 6 Coins )");
        System.out.println("+--------------------------------------->  ");
    }

    public void printPlayerInformation(Hero[] playerList) {
        System.out.println("####################################################################");
        for (Hero player : playerList) {

            System.out.println("## " + player.getName() + " | Health: " + player.getHealth() + " | Coins: "
                    + player.getCoins() + " | Leprechaun: " + player.getLeprechaun() + " | Goblins: "
                    + player.getNumberofGoblins());

        }
        System.out.println("####################################################################\n");
    }

    public int getUserIput() {
        return readInput.nextInt();
    }

    public void endGame(String name) {
        clearScreen();
        System.out.println(name + "lost the game!");
    }

    public void exitGame() {
        clearScreen();
        System.out.println("Bye\n");
        Singleton.getInstance().exportSingleton();

        //für static singleton
       // StaticSingleton.getInstance().exportStaticSingleton();
        System.exit(0);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
