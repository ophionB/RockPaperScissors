import entity.NPC;
import entity.Player;

public class Main
{
    public static void main(String[] args) {
        Player player = new Player();
        NPC computer = new NPC();
        Game game = new Game(player, computer);

        System.out.println("Welcome to Rock, Paper, Scissors!");
        game.gameLoop(Game.getRounds());
    }
}
