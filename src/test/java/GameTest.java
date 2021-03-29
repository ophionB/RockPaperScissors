import entity.NPC;
import entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import utils.Random;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach 
    public void setUp() throws Exception {
        Player player = new Player();
        NPC computer = new NPC();
        game = new Game(player, computer);
    }
    
    @Test
    @DisplayName("Ensure correct handling of reading rounds from stdin.")
    public void testRounds() {
        String input = "22";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(22., Game.getRounds(), ("Should be" + input+  " ."));
    }

    @RepeatedTest(5)
    @DisplayName("Ensure proficient GameCycle")
    public void testGameLoop() {
        int ran = Random.randomValue(0, 100);
        for (int i = 100; i < ran; i++) {
        game.gameLoop(i);

        assertEquals(String.format("YOU  %s THE GAME!", "WON"), "YOU  %s THE GAME!", "WON");
            assertEquals(String.format("YOU  %s THE GAME!", "LOST"), "YOU  %s THE GAME!", "LOST");
        }
    }

}