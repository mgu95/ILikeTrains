package game.engine.tools;

import game.engine.tools.exceptions.BoardDimensionsException;
import game.engine.tools.exceptions.GameParameterIsAlreadySetException;

public class GameRules {

    private final int minBoardHeight = 10;
    private final int maxBoardHeight = 20;
    private final int minBoardWidth = 20;
    private final int maxBoardWidth = 30;
    private final int minProcentRatioOfCitiesToTheNumberOfFields = 10;
    private final int maxProcentRatioOfCitiesToTheNumberOfFields = 20;
    private final int minPlayers = 2;
    private final int maxPlayers = 5;
    private final String[] routeColors = new String[]{"Red", "Yellow", "Blue", "Orange", "Pink", "Grey"};
    private final String[] cardColors = new String[]{"Red", "Yellow", "Blue", "Orange", "Pink", "Rainbow"};

    private Integer boardHeight;
    private Integer boardWidth;
    private Integer amountOfCities;

    public int getBoardHeight() {
        return boardHeight;
    }

    public boolean setBoardHeight(Integer boardHeight) throws BoardDimensionsException,
            GameParameterIsAlreadySetException {

        if (boardHeight < minBoardHeight || boardHeight > maxBoardHeight) {
            throw new BoardDimensionsException();
        } else if (boardHeight != null) {
            throw new GameParameterIsAlreadySetException();
        }
        this.boardHeight = boardHeight;

        return true;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public boolean setBoardWidth(int boardWidth) throws BoardDimensionsException {

        if (boardWidth < minBoardWidth || boardWidth > maxBoardWidth) {
            throw new BoardDimensionsException();
        }
        this.boardWidth = boardWidth;

        return true;
    }

    public int getAmountOfCities() {
        return amountOfCities;
    }

    public boolean setAmountOfCities(int amountOfCities) {
        this.amountOfCities = amountOfCities;

        return false;
    }

    public int getMinBoardHeight() {
        return minBoardHeight;
    }

    public int getMaxBoardHeight() {
        return maxBoardHeight;
    }

    public int getMinBoardWidth() {
        return minBoardWidth;
    }

    public int getMaxBoardWidth() {
        return maxBoardWidth;
    }

    public int getMinProcentRatioOfCitiesToTheNumberOfFields() {
        return minProcentRatioOfCitiesToTheNumberOfFields;
    }

    public int getMaxProcentRatioOfCitiesToTheNumberOfFields() {
        return maxProcentRatioOfCitiesToTheNumberOfFields;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String[] getRouteColors() {
        return routeColors;
    }

    public String[] getCardColors() {
        return cardColors;
    }
}
