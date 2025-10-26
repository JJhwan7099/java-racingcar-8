package racingcar.dto;

import java.util.List;

public class GameInitDto {
    private final List<String> carNames;
    private final int gameCount;

    public GameInitDto(List<String> carNames, int gameCount) {
        this.carNames = carNames;
        this.gameCount = gameCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getGameCount() {
        return gameCount;
    }
}
