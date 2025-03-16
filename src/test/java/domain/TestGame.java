package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {

    @Test
    public void shouldWinFirstPlayers() {
        Player player1 = new Player(513, "Семен", 100);
        Player player2 = new Player(714, "Иван", 78);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Иван", "Семен");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayers() {
        Player player1 = new Player(513, "Иван", 100);
        Player player2 = new Player(714, "Семен", 78);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Иван", "Семен");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {
        Player player1 = new Player(513, "Иван", 100);
        Player player2 = new Player(714, "Семен", 100);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Иван", "Семен");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstPlayerNotRegistered() {
        Player player1 = new Player(513, "Борис", 100);

        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Евгений", "Борис"));
    }

    @Test
    public void shouldSecondPlayerNotRegistered() {
        Player player1 = new Player(513, "Борис", 100);

        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Борис", "Евгений"));
    }
}
