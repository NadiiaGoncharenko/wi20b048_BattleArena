import Items.OldVersion.LatharSwordAdapter;
import Pawn.Hero;
import Singleton.Singleton;
import java.util.Random;

public class Game {

    public Game() {
    }

    public static void main(String[] args) {
        //Publisher publisher = new Publisher();
        //Hero hero1 = new Hero(publisher);
        //hero1.subscribe("COIN_EVENT", new LepreconSubscriber());
        // String message = "5 Leprecons is bought";
        //when 5 leprekon gekauft wird
        // publisher.send(message);


        UserIO userinteraction = new UserIO();

        Random randomNumberGenerator = new Random();

        //mit CynradBow /aus Angabe

        /*Hero[] playerList = {new Hero("Player 1", new CynradBow(randomNumberGenerator)),
                new Hero("Player 2", new CynradBow(randomNumberGenerator))};
        */

        // mit LatharSword zum probieren

        Hero[] playerList = {new Hero("Player 1", new LatharSwordAdapter()),

                new Hero("Player 2", new LatharSwordAdapter())};

        //  zum probieren, ob es funktioniert würde LatharSwordAdapter in OldVersion Package refactored
        //  sonst, müsste man LatharSword Konstruktor public machen,
        //  was nicht erwünscht ist.Oder mit Packages überlegen.
        //  falls es ein Fehler in Angabe war (und LatharSword constructor darf public sein),
        //  könnte man LatharSword noch so aufrufen :

        /*
        Hero[] playerList = {new Hero("Player 1", new LatharSwordAdapter(new LatharSword(randomNumberGenerator))),

                new Hero("Player 2", new LatharSwordAdapter(new LatharSword(randomNumberGenerator)))};

         */


        boolean run = true;

        while (run) {
            userinteraction.clearScreen();
            userinteraction.printPlayerInformation(playerList);

            for (Hero currentHero : playerList) {

                boolean action = false;
                do {
                    int userinput = -1;
                    do {
                        userinteraction.printFightMenu(currentHero.getName());
                        userinput = userinteraction.getUserIput();
                    } while (userinput < 0 || userinput > 5);

                    switch (userinput) {
                        case 0:
                            // exit game
                            run = false;
                            userinteraction.exitGame();
                            Singleton.getInstance().exportSingleton();

                            //für static singleton
                            //StaticSingleton.getInstance().exportStaticSingleton();

                            break;
                        case 1:
                            if (currentHero.getName() == "Player 1") {
                                action = currentHero.action(playerList[1]);
                            } else {
                                action = currentHero.action(playerList[0]);
                            }
                            break;

                        case 2:
                            action = currentHero.addLeprechaun();
                            break;
                        case 3:
                            action = currentHero.addTinyGoblin(randomNumberGenerator);
                            break;
                        case 4:
                            action = currentHero.addMediumGoblin(randomNumberGenerator);
                            break;
                        case 5:
                            action = currentHero.addBigGoblin(randomNumberGenerator);
                            break;

                        default:
                            break;
                    }

                    if (!action) {
                        userinteraction.clearScreen();
                        userinteraction.printPlayerInformation(playerList);
                        System.out.println("\nNot enought money");
                    }
                } while (!action);

                currentHero.updateCoins();

                if (currentHero.getName() == "Player 1") {
                    currentHero.useGoblins(playerList[1]);
                } else {
                    currentHero.useGoblins(playerList[0]);
                }
            }

            // end condition
            if (playerList[0].getHealth() <= 0) {
                userinteraction.endGame(playerList[0].getName());
                run = false;
            } else if (playerList[1].getHealth() <= 0) {
                userinteraction.endGame(playerList[1].getName());
                run = false;
            }
        }
    }
}