import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    @Test
    public void ShouldSecondWin() {
        Player player1 = new Player(1, "Innokentiy", 20);
        Player player2 = new Player(2, "Arseniy", 30);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Innokentiy", "Arseniy");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldFirstWin() {
        Player player1 = new Player(1, "Innokentiy", 50);
        Player player2 = new Player(2, "Arseniy", 30);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Innokentiy", "Arseniy");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldBeDrawnGame() {
        Player player1 = new Player(1, "Innokentiy", 50);
        Player player2 = new Player(2, "Arseniy", 50);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Innokentiy", "Arseniy");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldThrowExceptionIfFirst() {
        Player player2 = new Player(2, "Arseniy", 50);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Innokentiy", "Arseniy"));
    }

    @Test
    public void ShouldThrowExceptionIfSecond() {
        Player player1 = new Player(1, "Innokentiy", 50);
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Innokentiy", "Arseniy"));
    }

}
