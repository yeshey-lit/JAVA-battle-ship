
import battleship.BattleShip;

/**
 * main method that:
 * start the game
 *
 * @author group member
 * * shing kit wan
 * * 000826521
 * * yeshey dema
 * * 000824243
 * * Eugenio Diaz Munoz
 * * 000801681
 */

public class A6 {
    static final int NUMBEROFGAMES = 10000; //how many games you want to play

    public static void startingSolution() {
        int totalShots = 0;
        System.out.println(BattleShip.version());
        long start = System.nanoTime();
        for (int game = 0; game < NUMBEROFGAMES; game++) {

            BattleShip battleShip = new BattleShip();
            SampleBot sampleBot = new SampleBot(battleShip);

            // Call SampleBot Fire randomly - You need to make this better!
            while (!battleShip.allSunk()) {
                sampleBot.fireShot();

            }
            int gameShots = battleShip.totalShotsTaken();

            totalShots += gameShots;
        }

        System.out.println((((double) System.nanoTime() - (double) start) / 1000000000) + " seconds is taken to run all " + NUMBEROFGAMES + "games");
        System.out.printf("SampleBot - The Average # of Shots required in %d games to sink all Ships = %.2f\n", NUMBEROFGAMES, (double) totalShots / NUMBEROFGAMES);

    }

    public static void main(String[] args) {
        startingSolution();
    }
}
