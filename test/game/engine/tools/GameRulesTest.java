package game.engine.tools;

import game.engine.tools.exceptions.AmountOfCitiesException;
import game.engine.tools.exceptions.BoardDimensionsException;
import game.engine.tools.exceptions.GameParameterIsAlreadySetException;
import game.engine.tools.exceptions.NoGameParameterException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class GameRulesTest {

    GameRules gameRules;

    @BeforeEach
    void setUp() {
        gameRules = new GameRules();
    }

    @Test
    void HeightOfTheBoardIsTooLarge() {

        BoardDimensionsException exception = assertThrows(
                BoardDimensionsException.class,
                () -> gameRules.setBoardHeight(gameRules.getMaxBoardHeight() + 10)
        );
        assertEquals("Incorrect board height! The height of the board should be between "
                        + gameRules.getMinBoardHeight() + " to " + gameRules.getMaxBoardHeight() + "! The width should be "
                        + "between " + gameRules.getMinBoardWidth() + " to " + gameRules.getMaxBoardWidth() + "!",
                exception.getMessage());
    }

    @Test
    void HeightOfTheBoardIsTooLow() {

        BoardDimensionsException exception = assertThrows(
                BoardDimensionsException.class,
                () -> gameRules.setBoardHeight(gameRules.getMinBoardHeight() - 10)
        );
        assertEquals("Incorrect board height! The height of the board should be between "
                        + gameRules.getMinBoardHeight() + " to " + gameRules.getMaxBoardHeight() + "! The width should be "
                        + "between " + gameRules.getMinBoardWidth() + " to " + gameRules.getMaxBoardWidth() + "!",
                exception.getMessage());
    }

    @Test
    void HeightOfTheBoardIsAsMuchAsMaxBoardHeight() throws BoardDimensionsException, GameParameterIsAlreadySetException {
        Assertions.assertTrue(gameRules.setBoardHeight(gameRules.getMaxBoardHeight()));
    }

    @Test
    void HeightOfTheBoardIsAsMuchAsMinBoardHeight() throws BoardDimensionsException, GameParameterIsAlreadySetException {
        Assertions.assertTrue(gameRules.setBoardHeight(gameRules.getMinBoardHeight()));
    }

    @Test
    void HeightOfTheBoardIsAsOK() throws BoardDimensionsException, GameParameterIsAlreadySetException {
        Assertions.assertTrue(gameRules.setBoardHeight(gameRules.getMinBoardHeight() + 1));
    }

    @Test
    void setBoardHeightAgain() throws BoardDimensionsException, GameParameterIsAlreadySetException {

        gameRules.setBoardHeight(gameRules.getMinBoardHeight() + 1);

        GameParameterIsAlreadySetException exception = assertThrows(
                GameParameterIsAlreadySetException.class,
                () -> gameRules.setBoardHeight(gameRules.getMaxBoardHeight() - 10)
        );
        assertEquals("The parameter is already set! You cannot change the rules while the game is in progress!", exception.getMessage());
    }

    @Test
    void boardHeightIsNotSet() {

        NoGameParameterException exception = assertThrows(
                NoGameParameterException.class,
                () -> gameRules.getBoardHeight()
        );
        assertEquals("No parameter! Set the parameter first!", exception.getMessage());
    }

    @Test
    void WidthOfTheBoardIsTooLarge() {

        BoardDimensionsException exception = assertThrows(
                BoardDimensionsException.class,
                () -> gameRules.setBoardWidth(gameRules.getMaxBoardWidth() + 10)
        );
        assertEquals("Incorrect board height! The height of the board should be between "
                        + gameRules.getMinBoardHeight() + " to " + gameRules.getMaxBoardHeight() + "! The width should be "
                        + "between " + gameRules.getMinBoardWidth() + " to " + gameRules.getMaxBoardWidth() + "!",
                exception.getMessage());
    }

    @Test
    void WidthOfTheBoardIsTooLow() {

        BoardDimensionsException exception = assertThrows(
                BoardDimensionsException.class,
                () -> gameRules.setBoardWidth(gameRules.getMinBoardWidth() - 10)
        );
        assertEquals("Incorrect board height! The height of the board should be between "
                        + gameRules.getMinBoardHeight() + " to " + gameRules.getMaxBoardHeight() + "! The width should be "
                        + "between " + gameRules.getMinBoardWidth() + " to " + gameRules.getMaxBoardWidth() + "!",
                exception.getMessage());
    }

    @Test
    void WidthOfTheBoardIsAsMuchAsMaxBoardHeight() throws BoardDimensionsException {
        Assertions.assertTrue(gameRules.setBoardWidth(gameRules.getMaxBoardWidth()));
    }

    @Test
    void WidthOfTheBoardIsAsMuchAsMinBoardHeight() throws BoardDimensionsException {
        Assertions.assertTrue(gameRules.setBoardWidth(gameRules.getMinBoardWidth()));
    }

    @Test
    void WidthOfTheBoardIsOk() throws BoardDimensionsException {
        Assertions.assertTrue(gameRules.setBoardWidth(gameRules.getMinBoardWidth() + 1));
    }

    @Test
    void setBoardWidthAgain() throws BoardDimensionsException {

        gameRules.setBoardWidth(gameRules.getMinBoardWidth() + 1);

        GameParameterIsAlreadySetException exception = assertThrows(
                GameParameterIsAlreadySetException.class,
                () -> gameRules.setBoardWidth(gameRules.getMaxBoardWidth() - 10)
        );
        assertEquals("The parameter is already set! You cannot change the rules while the game is in " +
                "progress!", exception.getMessage());
    }

    @Test
    void boardWidthIsNotSet() {

        NoGameParameterException exception = assertThrows(
                NoGameParameterException.class,
                () -> gameRules.getBoardWidth()
        );
        assertEquals("No parameter! Set the parameter first!", exception.getMessage());
    }

    @Test
    void AmountOfTheCitiesIsTooLarge() throws BoardDimensionsException, GameParameterIsAlreadySetException {

        gameRules.setBoardHeight(10);
        gameRules.setBoardWidth(20);
        int maxAmountOfCities = gameRules.getBoardHeight() * gameRules.getBoardWidth()
                / gameRules.getMaxProcentRatioOfCitiesToTheNumberOfFields();

        AmountOfCitiesException exception = assertThrows(
                AmountOfCitiesException.class,
                () -> gameRules.setAmountOfCities(maxAmountOfCities + 1)
        );
        assertEquals("Incorrect amount of the cities! Amount of the cities should be between " +
                        gameRules.getMinProcentRatioOfCitiesToTheNumberOfFields() + "% to " +
                        gameRules.getMaxProcentRatioOfCitiesToTheNumberOfFields() + "% of the size of the Board!",
                exception.getMessage());
    }

    @Test
    void AmountOFTheCitiesIsTooLow() throws BoardDimensionsException, GameParameterIsAlreadySetException {

        gameRules.setBoardHeight(10);
        gameRules.setBoardWidth(20);
        int minAmountOfCities = gameRules.getBoardHeight() * gameRules.getBoardWidth()
                / gameRules.getMinProcentRatioOfCitiesToTheNumberOfFields();

        AmountOfCitiesException exception = assertThrows(
                AmountOfCitiesException.class,
                () -> gameRules.setAmountOfCities(minAmountOfCities - 1)
        );
        assertEquals("Incorrect amount of the cities! Amount of the cities should be between " +
                        gameRules.getMinProcentRatioOfCitiesToTheNumberOfFields() + "% to " +
                        gameRules.getMaxProcentRatioOfCitiesToTheNumberOfFields() + "% of the size of the Board!",
                exception.getMessage());
    }

    @Test
    void AmountOfTheCitiesIsAsMuchAsMinProcentRatioOfCitiesToTheNumberOfFields() throws BoardDimensionsException, GameParameterIsAlreadySetException {

        gameRules.setBoardHeight(10);
        gameRules.setBoardWidth(20);
        int minAmountOfCities = gameRules.getBoardHeight() * gameRules.getBoardWidth()
                / gameRules.getMinProcentRatioOfCitiesToTheNumberOfFields();

        Assertions.assertTrue(gameRules.setAmountOfCities(minAmountOfCities));
    }

    @Test
    void AmountOfTheCitiesIsAsMuchAsMaxProcentRatioOfCitiesToTheNumberOfFields() throws BoardDimensionsException, GameParameterIsAlreadySetException {

        gameRules.setBoardHeight(10);
        gameRules.setBoardWidth(20);
        int maxAmountOfCities = gameRules.getBoardHeight() * gameRules.getBoardWidth()
                / gameRules.getMaxProcentRatioOfCitiesToTheNumberOfFields();

        Assertions.assertTrue(gameRules.setAmountOfCities(maxAmountOfCities));
    }

    @Test
    void AmountOfTheCitiesIsOk() throws BoardDimensionsException, GameParameterIsAlreadySetException {

        gameRules.setBoardHeight(10);
        gameRules.setBoardWidth(20);

        Assertions.assertTrue(gameRules.setAmountOfCities(30));
    }

    @Test
    void setAmountOfTheCitiesAgain() throws BoardDimensionsException, GameParameterIsAlreadySetException {

        gameRules.setBoardHeight(10);
        gameRules.setBoardWidth(20);
        gameRules.setAmountOfCities(30);

        GameParameterIsAlreadySetException exception = assertThrows(
                GameParameterIsAlreadySetException.class,
                () -> gameRules.setAmountOfCities(35)
        );
        assertEquals("The parameter is already set! You cannot change the rules while the game is in " +
                "progress!", exception.getMessage());
    }

    @Test
    void AmountOfTheCitiesIsNotSet() {

        NoGameParameterException exception = assertThrows(
                NoGameParameterException.class,
                () -> gameRules.getAmountOfCities()
        );
        assertEquals("No parameter! Set the parameter first!", exception.getMessage());
    }
}