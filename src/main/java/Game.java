import entity.NPC;
import entity.Player;
import entity.Entity;
import entity.Entity.Gesture;

import javax.inject.Inject;
import java.util.Scanner;

public class Game
{
    private static final int MAX_ROUNDS = 25;
    
    @Inject
    private final Player player;

    @Inject
    private final NPC opponent;
    
    @Inject
    Game(Player player, NPC opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    /**
     * Reads from the stdin the amount of rounds.
     * @return the amount of game rounds
     */
    public static final int getRounds() {
        Scanner scanner = new Scanner(System.in);
        int gameRounds = 0;

        while (gameRounds == 0) {
            System.out.println("How many rounds would you like to play? 1 - " +MAX_ROUNDS+ " Rounds.");
            gameRounds = scanner.nextInt();
            if (!(gameRounds > 0 && gameRounds <= MAX_ROUNDS)) {
                gameRounds = 0;
                System.out.println("Please select within the range of 1 - " +MAX_ROUNDS+ " rounds.");
            }
        }
        System.out.println("We're playing " + gameRounds + " " + (gameRounds == 1 ? "round" : "rounds") +  " of Rock, Paper, Scissors!.");
        return (gameRounds);
    }

    /**
     * Functions as the game cycle
     * @param maxRounds represents the maximum amount of rounds executed.
     */
    protected final void gameLoop(int maxRounds) {
        int round = 1;

        while (round <= maxRounds) {
            System.out.println("Round " + round);
            assignGestures();
            round++;
        }
        System.out.println("YOU " + (getWinner().equals(player) ? "WON" : "LOST" + " THE GAME!"));
    }

    private void assignGestures() {
        Scanner scanner = new Scanner(System.in);
        int index = -1;
        
        while (index < 0 || index > 2) {
            System.out.println("choose your gesture: Rock (0), Paper (1), Scissors (2).");
            index = scanner.nextInt();
            player.setGesture(Gesture.fromValue(index));
        }
        opponent.setGesture(opponent.randomGesture());
        revealGestures();
    }

    private void revealGestures() {
        System.out.println("YOU: " + player.getGesture().name());
        System.out.println("Opponent: " + opponent.getGesture().name());

        if (player.getGesture().equals(opponent.getGesture())) {
            player.setTies(player.getTies() + 1);
            opponent.setTies(opponent.getTies() + 1);
            System.out.println("its a TIE!");
            return;
        }
        if ((player.getGesture().ordinal() > opponent.getGesture().ordinal())) {
            player.setWins(player.getWins() + 1);
            opponent.setLoss(opponent.getLoss() + 1);
            System.out.println("You WON this round! You: " + player.getWins() + ", Opponent: " +opponent.getWins());
        } else {
            opponent.setWins(opponent.getWins() + 1);
            player.setLoss(player.getLoss() + 1);
            System.out.println("You LOST this round! You: " + opponent.getWins() + ", Opponent: " +opponent.getWins());
        }
    }

    private Entity getWinner() {
        return player.getWins() > opponent.getWins() ? player : opponent;
    }
}
